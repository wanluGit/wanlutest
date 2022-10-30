package com.example.demo.controller;

import com.example.demo.pojo.Tuser;
import com.example.demo.service.ServiceTuserInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/tuser")
public class ConTuser {
	@Autowired
	private ServiceTuserInter serTuser;

	@RequestMapping(value="checkUname",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String checkUname(String name) {
		System.out.println("ajaxCheckUname name:"+name);
		if(serTuser.checkName(name)) {
			//用户名存在
			return "success";
		}else {
			//用户名不存在
			return "error";
		}
	}

	@RequestMapping(value="checkTuser",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String checkTuser(String name, String pwd, HttpSession session) {
		if(serTuser.checkTuser(name, pwd)) {
			//用户名添加到session里
			session.setAttribute("name", name);
			
			//用户名存在
			return "success";
		}else {
			//用户名不存在
			return "error";
		}
	}

	@RequestMapping(value="addTuser",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String addMember(Tuser tuser) {
		serTuser.addTuser(tuser);
		return "success";
	}

	@RequestMapping(value="upateTuser",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String upateTuser(Tuser tuser) {
		serTuser.updateTuser(tuser);
		return "success";
	}

	@RequestMapping(value="loginout",method= RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String loginout(HttpSession session){
		//session失效
		session.invalidate();

		//重定向到login页面
		return "success";

	}
}
