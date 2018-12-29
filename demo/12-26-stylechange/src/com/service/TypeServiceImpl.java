package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TypeDaoImpl;
import com.entity.TypeTable;

@Service
public class TypeServiceImpl {

	
	@Resource
	private TypeDaoImpl typeDaoImpl;
	
	
	public List<TypeTable> listAll(){
		return typeDaoImpl.findAll(TypeTable.class); 
	}
}
