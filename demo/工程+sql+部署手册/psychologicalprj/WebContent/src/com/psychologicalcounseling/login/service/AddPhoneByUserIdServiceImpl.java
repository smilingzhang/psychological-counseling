package com.psychologicalcounseling.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.psychologicalcounseling.login.dao.AddPhoneByUserIdDaoImpl;

@Service
public class AddPhoneByUserIdServiceImpl {
	@Resource
	private AddPhoneByUserIdDaoImpl apbaidi;

	public void addPhone(String userPhone, String userId) {
		apbaidi.updatePhone(userPhone, userId);
	}

}
