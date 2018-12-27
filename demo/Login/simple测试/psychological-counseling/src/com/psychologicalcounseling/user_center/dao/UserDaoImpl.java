package com.psychologicalcounseling.user_center.dao;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.util.BaseDao;

@Repository
public class UserDaoImpl extends BaseDao{
        public User selectUser(int userId) {
        	return (User) get(User.class,userId);
        }
        public Map<String, Object> selectUser4Json() throws Exception {
        	String sql="select * from user where userId=?";
        	return findOneBySql(sql,6);
        }
        public void updateEssentialInfo(String userNickName,String userSex,String userProvince,String userCity,String userAutograph,int userId) {
        	String sql="update user set userNickName=?,userSex=?,userProvince=?,userCity=?,userAutograph=? where userId=?";
        	
        	int result=insert(sql,userNickName,userSex,userProvince,userCity,userAutograph,userId);
        	if(result==1) {
        		System.out.println("更新用户基本信息成功");
        		
        	}else {
        		System.out.println("更新用户基本信息失败");
        	}
        }
        public void updateRealName(String userRealName,String userIdNumber,int userId) {
        	String sql="update user set userRealName=?,userIdNumber=? where userId=?";
        	
        	int result=insert(sql,userRealName,userIdNumber,userId);
        	if(result==1) {
        		System.out.println("更新用户实名信息成功");
        	}else {
        		System.out.println("更新用户实名信息失败");

        	}
        }
        public void updatePwd(String newPwd,int userId) {
        	String sql="update user set userPassword=?where userId=?";
        	int result=insert(sql,newPwd,userId);
        	if(result==1) {
        		System.out.println("更新用户密码成功");
        	}else {
        		System.out.println("更新用户密码失败");

        	}
        }
	    

}
