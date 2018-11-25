package com.psychologicalcounseling.login.dao;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.psychologicalcounseling.login.service.IsNewPhoneDaoImpl;


@Service
public class IsNewPhoneServiceImpl {

	@Resource
	private IsNewPhoneDaoImpl inpdl;
	
	public boolean isNewPhoneDaoImpl(String phone) {
		return inpdl.isNewPhoneDaoImpl(phone);
	}

}
