package com.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public class UserDaoImpl {

	@Resource
	private SessionFactory sessionFactory;
	
	public User findUserByUserNickName(String userNickName) {
		
		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from User where userNickName=?");
		q.setString(0, userNickName);
		return (User) q.uniqueResult();
	}
}
