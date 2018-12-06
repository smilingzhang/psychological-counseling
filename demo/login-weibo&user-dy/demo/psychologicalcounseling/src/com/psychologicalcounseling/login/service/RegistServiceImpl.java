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

}
