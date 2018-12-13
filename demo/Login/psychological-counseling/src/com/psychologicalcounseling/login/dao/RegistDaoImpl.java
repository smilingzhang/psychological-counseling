package com.psychologicalcounseling.login.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.util.BaseDao;

@Repository
public class RegistDaoImpl extends BaseDao{
     
	public int insertUser(String phone) {
		String sql="insert into user(userPhone,userRegistTime) values(?,?)";
		//返回影响的条数
		return insert(sql,phone,new Date());
	}
	

}
