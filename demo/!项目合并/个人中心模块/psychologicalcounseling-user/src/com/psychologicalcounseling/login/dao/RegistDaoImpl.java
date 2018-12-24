package com.psychologicalcounseling.login.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.util.BaseDao;

@Repository
public class RegistDaoImpl extends BaseDao{
     
	public int insertUser(String phone) {
		String sql="insert into user(userPhone,userRegistTime,userIdentity,userHeadPath) values(?,?,?,?)";
		//返回影响的条数
		return insert(sql,phone,new Date(),User.IDENTITY_USER,"/images/20181220105121201");
	}
	public int selectUserId(String phone) {
		String hql=" from User where userPhone=?";
		List list=find(hql,phone);
		return ((User) list.get(0)).getUserId();
	}
	public String selectUserHeadPath(String phone) {
		String hql=" from User where userPhone=?";
		List list=find(hql,phone);
		return ((User) list.get(0)).getUserHeadPath();
	}

}
