package com.psychologicalcounseling.getpassage.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.TypeTable;

@Repository
public class DemoDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 查询文章的所有的类别
	 * @param businesstypeWorkType
	 * @return
	 */
	public List<TypeTable> selectList(int businesstypeWorkType){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select distinct typeTable from BusinessType where businesstypeWorkType = ?");
		q.setInteger(0,businesstypeWorkType);
		return q.list();
		
	}
}
