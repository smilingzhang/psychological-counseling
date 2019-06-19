package com.courseing.user.dao;

import org.springframework.stereotype.Repository;

import com.entity.User;
import com.util.BaseDao;
@Repository
public class FindUserDaoImpl extends BaseDao<User> {
	public User selectUserById(int userId) {
		return get(User.class, userId);
	}
}
