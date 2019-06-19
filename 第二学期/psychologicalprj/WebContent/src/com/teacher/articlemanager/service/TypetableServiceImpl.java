package com.teacher.articlemanager.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.TypeTable;
import com.teacher.articlemanager.dao.TypetableDaoImpl;

@Service
public class TypetableServiceImpl {
	@Resource
	private TypetableDaoImpl typetableDaoImpl;
	
	public List<TypeTable> findtypeTable(int businesstypeWorkType){
		return this.typetableDaoImpl.selectTypeTable(businesstypeWorkType);
	}
}
