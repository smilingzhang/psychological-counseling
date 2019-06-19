package com.search.searchconsulter.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.entity.Teacher;
import com.util.BaseDao;
@Repository
public class SearchConsulterDao extends BaseDao<Teacher>{
	/**
	 * 
	 *@desc:获取所有的咨询师 标识为2
	 *@return
	 *@return:List<Teacher>
	 *@trhows
	 */
	public List<Teacher> getAllConsulters(){
		Session session=sessionFactory.getCurrentSession();
		SQLQuery query=session.createSQLQuery("select teacher.* from teacher,user where teacherId=userId and userIdentity=?");
		query.setParameter(0, 2);
		query.addEntity(Teacher.class);
		return query.list();
	}
	/**
	 * 
	 *@desc:获取所有的咨询师和倾听师
	 *@return
	 *@return:List<Teacher>
	 *@trhows
	 */

	public List<Teacher> getAllConsulterAndListener(){
		return findAll(Teacher.class);
	}
}
