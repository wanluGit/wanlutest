package com.example.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class ServiceCommon {
	//静态方法：根据用户名返回生成的商家id
	public static String getTsellerId(String username) {
		String id="";
		if(username!=null&&username.length()>0) {
			SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
			
			id=username.toUpperCase().charAt(0)+format.format(new Date());
		}
		
		return id;
	}

	//静态方法：根据随机生成的图片名字
	public static String getFileName(String path) {
		//20211203 修改，图片里含有中文信息，使用有问题
//		String url=path.substring(0,path.indexOf("."));
//		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
//		url+=format.format(new Date());
//		url+=path.substring(path.indexOf("."));

		//通过uuid随机生成一个文件名
		String url= UUID.randomUUID().toString();

		return url;
	}

}
