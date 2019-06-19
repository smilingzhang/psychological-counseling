package com.teacher.articlemanager.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.TypeTable;

@Repository
public class TypetableDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	
	public List<TypeTable> selectTypeTable(int businesstypeWorkType){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select distinct typeTable from BusinessType where businesstypeWorkType = ?");
		q.setInteger(0,businesstypeWorkType);
		return q.list();
	}
}
