package com.psychologicalcounseling.login.dao;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.User;
import com.util.BaseDao;

@Repository
public class RegistDaoImpl extends BaseDao{
     
	public int insertUser(String phone) {
		String sql="insert into user(userPhone,userRegistTime,userIdentity) values(?,?,?)";
		//返回影响的条数
		return insert(sql,phone,new Date(),User.IDENTITY_USER);
	}
	public int selectUserId(String phone) {
		String hql=" from User where userPhone=?";
		List list=find(hql,phone);
		return ((User) list.get(0)).getUserId();
	}

}
