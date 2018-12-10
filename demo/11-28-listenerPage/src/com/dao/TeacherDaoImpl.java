package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.Teacher;


@Repository
public class TeacherDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 
	* @Desc:   
	* @date 2018年12月3日:下午2:38:06
	* @author baozhangjun
	* @throws
	 */
	public List<Teacher> findTeachers(){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Teacher";
		Query q = session.createQuery(hql);
		return q.list();
	}
	
	public List<Teacher> findTeachersBySex(String gender){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Teacher t where t.user.userSex=?";
		Query q = session.createQuery(hql);
		q.setString(0, gender);
		return q.list();
	}
	
	public List<Teacher> findTeachersByAge(String age){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Teacher t where t.user.userSex=?";
		Query q = session.createQuery(hql);
		q.setString(0, age);
		return q.list();
	}
	public List<Teacher> findTeachersBySexAndAge(String gender, String age){
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Teacher t where t.user.userSex=?";
		Query q = session.createQuery(hql);
		q.setString(0, gender);
		return q.list();
	}
	
	public Teacher findTeacherById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Teacher t where t.id=?";
		Query q = session.createQuery(hql);
		q.setInteger(0, id);
		return (Teacher) q.uniqueResult();
	}
}
