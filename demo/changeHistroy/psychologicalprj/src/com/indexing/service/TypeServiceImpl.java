package com.indexing.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.TypeTable;
import com.indexing.dao.TypeDaoImpl;

@Service
public class TypeServiceImpl {

	
	@Resource
	private TypeDaoImpl typeDaoImpl;
	
	
	public List<TypeTable> listAll(){
		return typeDaoImpl.findAll(TypeTable.class); 
	}
}
