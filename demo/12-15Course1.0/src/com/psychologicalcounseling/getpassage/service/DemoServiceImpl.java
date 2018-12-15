package com.psychologicalcounseling.getpassage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.psychologicalcounseling.entity.TypeTable;
import com.psychologicalcounseling.getpassage.dao.DemoDaoImpl;

@Service
public class DemoServiceImpl {

	@Resource
	private DemoDaoImpl demoDaoImpl;
	
	public List<TypeTable> findtypeTable(int businesstypeWorkType){
		return this.demoDaoImpl.selectList(businesstypeWorkType);
	}
}
