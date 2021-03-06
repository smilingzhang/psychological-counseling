package com.psychologicalcounseling.user.dao;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.util.BaseDao;
@Repository
public class FindUserDaoImpl extends BaseDao<User> {
	public User selectUserById(int userId) {
		return get(User.class, userId);
	}
}
