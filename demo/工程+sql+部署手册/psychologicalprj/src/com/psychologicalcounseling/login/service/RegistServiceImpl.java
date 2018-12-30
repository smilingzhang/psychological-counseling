package com.psychologicalcounseling.login.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.psychologicalcounseling.login.dao.RegistDaoImpl;

@Service

public class RegistServiceImpl {

    @Resource
    private RegistDaoImpl rdl;
    public int regist(String phone) {
    	return rdl.insertUser(phone);
    }
    public int getUserId(String phone ) {
    	return rdl.selectUserId(phone);
    }
    public String getUserHeadPath(String phone) {
    	return rdl.selectUserHeadPath(phone);
    }
	public int isTeacher(String phone) {
		return rdl.isTeacher(phone);
	}

}
