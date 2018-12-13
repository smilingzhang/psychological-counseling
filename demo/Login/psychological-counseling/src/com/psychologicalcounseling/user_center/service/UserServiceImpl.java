package com.psychologicalcounseling.user_center.service;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.user_center.dao.UserDaoImpl;

@Service
public class UserServiceImpl {
    @Resource
    private UserDaoImpl udi;
	
	public User getUser(int userId) {
		return udi.selectUser(userId);
	}
	public  Map<String, Object> getUser4Json() {
		try {
			return udi.selectUser4Json();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("查询结果集失败");
			return null;
		}
	}
	public void reviseEssentialInfo(String userNickName,String userSex,String userProvince,String userCity,String userAutograph,int userId) {
		System.out.println(userSex);
		if(userSex.equals("male")) {
			userSex="男";
		}else if(userSex.equals("female")) {
			userSex="女";
		}
		System.out.println(userSex);
		udi.updateEssentialInfo(userNickName, userSex, userProvince, userCity, userAutograph,userId);
		
	}
	public void reviseRealName(String userRealName,String userIdNumber,int userId ) {
		udi.updateRealName(userRealName, userIdNumber,userId);
	}
    public boolean verifyOldPwd(String oldPwd,int userId) {
    	
    	//这个用的找到当前用户，从而找到密码
    	String pwd=udi.selectUser(userId).getUserPassword();
    	if(pwd.equals(oldPwd)) {
    		return true;
    	}else {
    		return false;
    	}
    }
    public void revisePwd(String newPwd,int userId) {
    	udi.updatePwd(newPwd, userId);
    	
    }
}
