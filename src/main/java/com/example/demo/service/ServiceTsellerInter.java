package com.example.demo.service;

import com.example.demo.pojo.Tseller;
import com.example.demo.pojo.TsellerQuery;
import com.github.pagehelper.PageInfo;

public interface ServiceTsellerInter {
	
	boolean addTseller(Tseller tseller);
	
	PageInfo<Tseller> getPage(TsellerQuery query,int page,int size);
	
	boolean updateMember(Tseller mem);
	
	void deleteIds(String[] ids);
	
	Tseller getTseller(String id);

	boolean deleteId(String id);
}
