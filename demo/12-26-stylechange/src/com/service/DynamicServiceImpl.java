package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.DynamicDaoImpl;
import com.entity.Dynamic;

@Service
public class DynamicServiceImpl {

	@Resource
	private DynamicDaoImpl dynamicDaoImpl;
	
	public List<Dynamic> findDynamicsByPage(){
		return dynamicDaoImpl.selectDynamicsByPage();
	}
}
