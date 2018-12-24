package com.listenning.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.entity.User;
import com.util.BaseDao;

@Repository
public class UserDaoImpl extends BaseDao<User> {

	public User findUserByUserNickName(String userNickName) {

		Session session = sessionFactory.getCurrentSession();
		Query q = session.createQuery("from User where userNickName=?");
		q.setString(0, userNickName);
		return (User) q.uniqueResult();
	}
}
