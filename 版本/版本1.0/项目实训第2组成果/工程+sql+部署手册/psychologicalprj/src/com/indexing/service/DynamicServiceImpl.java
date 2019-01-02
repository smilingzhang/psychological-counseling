package com.indexing.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Dynamic;
import com.indexing.dao.DynamicDaoImpl;

@Service
public class DynamicServiceImpl {

	@Resource
	private DynamicDaoImpl dynamicDaoImpl;
	
	public List<Dynamic> findDynamicsByPage(){
		return dynamicDaoImpl.selectDynamicsByPage();
	}
}
