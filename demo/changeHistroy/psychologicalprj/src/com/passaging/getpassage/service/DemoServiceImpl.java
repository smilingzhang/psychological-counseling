package com.passaging.getpassage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.TypeTable;
import com.passaging.getpassage.dao.DemoDaoImpl;

@Service
public class DemoServiceImpl {

	@Resource
	private DemoDaoImpl demoDaoImpl;

	public List<TypeTable> findtypeTable(int businesstypeWorkType) {
		return this.demoDaoImpl.selectList(businesstypeWorkType);
	}
}
