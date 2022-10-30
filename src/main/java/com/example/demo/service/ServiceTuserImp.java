package com.example.demo.service;

import com.example.demo.dao.TuserMapper;
import com.example.demo.pojo.Tuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ServiceTuserImp implements ServiceTuserInter {
	@Autowired
	private TuserMapper tuserDao;
	
	@Override
	public boolean checkTuser(String name, String pwd) {
		int count=tuserDao.checkTuser(name, pwd);
		if(count>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean checkName(String name) {
		int count=tuserDao.checkName(name);
		if(count>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void addTuser(Tuser tuser) {
		tuser.setCreateTime(new Date());
		tuserDao.insert(tuser);
	}

	@Override
	public void updateTuser(Tuser tuser) {
		tuser.setUpdateTime(new Date());
		tuserDao.updateByPrimaryKeySelective(tuser);
	}
}
