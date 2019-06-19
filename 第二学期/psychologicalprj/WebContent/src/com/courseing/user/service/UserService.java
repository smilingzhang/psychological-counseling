package com.courseing.user.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.courseing.user.dao.FindUserDaoImpl;
import com.entity.User;

@Service
@Transactional(readOnly=true)
public class UserService {
	@Resource
	private FindUserDaoImpl findUserDaoImpl;
	public User FindUser(int userId) {
		return findUserDaoImpl.selectUserById(userId);
	}
}
