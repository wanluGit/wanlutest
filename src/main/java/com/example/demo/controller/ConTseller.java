package com.example.demo.controller;

import com.example.demo.pojo.Tseller;
import com.example.demo.pojo.TsellerQuery;
import com.example.demo.service.ServiceCommon;
import com.example.demo.service.ServiceTsellerInter;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/tseller")
public class ConTseller {
	@Autowired
	private ServiceTsellerInter serTseller;


	@Value("${file.uploadFolder}")
	private String path;


	@RequestMapping(value="ajaxAddTseller",method= RequestMethod.POST)
	public String addTseller(MultipartFile file, Tseller tseller, HttpServletRequest request)throws IOException{
		//--- 文件上传代码  start ---
		//String path = request.getSession().getServletContext().getRealPath("upload");  

		//上传到本地路径本地路径
		//String path ="D:\\temp\\upload";

		//取得文件名
		String fileName=file.getOriginalFilename(); 
		if(fileName!=null&&fileName.length()>0) {
			fileName = ServiceCommon.getFileName(file.getOriginalFilename());
			File dir = new File(path, fileName);
			if (!dir.exists()) {
				dir.mkdirs();
			}
			// MultipartFile自带的解析方法
			file.transferTo(dir);
			
			//修改对象里图片的url
			tseller.setComments(fileName);
		}
        //--- 文件上传代码  end ---
        
        //System.out.println("--- 文件完整路径："+(path+"/"+fileName));
        
        //获取session里的用户名
        String username=(String) request.getSession().getAttribute("name");
        //取得生产的商家id
        tseller.setId(ServiceCommon.getTsellerId(username));

        //--- 添加tseller对象  start ---
		if(serTseller.addTseller(tseller)) {
			return "redirect:../query.html";
		}else {
			return "redirect:../add.html";
		}
		//--- 添加tseller对象  end ---
	}

	@RequestMapping(value="ajaxGetPage",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
	public PageInfo<Tseller> getPage(TsellerQuery query, int page,int size){
		return serTseller.getPage(query,page,size);
	}

	@RequestMapping(value="ajaxUpdateTseller",method= RequestMethod.POST)
	public String update(MultipartFile file, Tseller tseller, HttpServletRequest request) throws IllegalStateException, IOException {
		//--- 文件上传代码  start ---
		// String path = request.getSession().getServletContext().getRealPath("upload");
		//String path = "D:\\temp\\upload";
		//取得文件名
		if(file!=null){
			String fileName=file.getOriginalFilename();
			if(fileName!=null&&fileName.length()>0) {
				fileName = ServiceCommon.getFileName(file.getOriginalFilename());
				File dir = new File(path, fileName);
				if (!dir.exists()) {
					dir.mkdirs();
				}
				// MultipartFile自带的解析方法
				file.transferTo(dir);

				//修改对象里图片的url
				tseller.setComments(fileName);
			}
		}
		// --- 文件上传代码 end ---
		serTseller.updateMember(tseller);
		return "redirect:../query.html";
	}

	@RequestMapping(value="ajaxdelete",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
	public void delete(String[] ids) {
		serTseller.deleteIds(ids);
	}

	@RequestMapping(value="deleteId",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
	public void deleteId(String id) {
		serTseller.deleteId(id);
	}

	@RequestMapping(value="ajaxGetTseller",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
	public Tseller getTsell(String id) {
		return serTseller.getTseller(id);
	}

}
