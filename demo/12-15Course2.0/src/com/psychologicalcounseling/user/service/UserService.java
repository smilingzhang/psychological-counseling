package com.psychologicalcounseling.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.user.dao.FindUserDaoImpl;

@Service
@Transactional(readOnly=true)
public class UserService {
	@Resource
	private FindUserDaoImpl findUserDaoImpl;
	public User FindUser(int userId) {
		return findUserDaoImpl.selectUserById(userId);
	}
}
