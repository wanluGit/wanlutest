package com.example.demo.service;

import com.example.demo.pojo.Tuser;

public interface ServiceTuserInter {
	boolean checkTuser(String name,String pwd);
	
	boolean checkName(String name);
	
	void addTuser(Tuser tuser);

	void updateTuser(Tuser tuser);
}
