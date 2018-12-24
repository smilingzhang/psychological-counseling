package com.psychologicalcounseling.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.psychologicalcounseling.login.dao.VerifyPwdDaoImpl;

@Service
public class VerifyPwdServiceImpl {
    
	@Resource
	private VerifyPwdDaoImpl vpdi;
	public boolean verifyPwd(String phone,String pwd){
		
		if(pwd.equals(vpdi.findPwdByPhone(phone))) {
			return true;
		}else {
			return false;
		}
	}

}
