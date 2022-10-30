package com.example.demo.service;

import com.example.demo.dao.TsellerMapper;
import com.example.demo.pojo.Tseller;
import com.example.demo.pojo.TsellerQuery;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ServiceTsellerImp implements ServiceTsellerInter {
	@Autowired
	private TsellerMapper tsellerDao;
	
	
	@Override
	public boolean addTseller(Tseller tseller) {
		tseller.setDelFlg("0");
		tseller.setCreateTime(new Date());
		if(tsellerDao.insert(tseller)>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public PageInfo<Tseller> getPage(TsellerQuery query,int page,int size) {
		//注意：自动的对PageHelper.startPage 方法下的第一个sql 查询进行分页
		//在你需要进行分页的 MyBatis 查询方法前调用 PageHelper.startPage 静态方法即可，
		//紧跟在这个方法后的第一个MyBatis 查询方法会被进行分页
		PageHelper.startPage(page, size);
		List<Tseller> list = tsellerDao.selectPage(query);

		PageInfo<Tseller> pageInfo = new PageInfo<Tseller>(list);
		return pageInfo;
	}

	@Override
	public boolean updateMember(Tseller tseller) {
		tseller.setUpdateTime(new Date());
		if(tsellerDao.updateByPrimaryKeySelective(tseller)>0) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void deleteIds(String[] ids) {
		tsellerDao.deleteIds(ids);
	}

	@Override
	public Tseller getTseller(String id) {
		// TODO Auto-generated method stub
		return tsellerDao.selectByPrimaryKey(id);
	}

	@Override
	public boolean deleteId(String id) {
		if(tsellerDao.deleteByPrimaryKey(id)>0) {
			return true;
		}else {
			return false;
		}
	}


}
