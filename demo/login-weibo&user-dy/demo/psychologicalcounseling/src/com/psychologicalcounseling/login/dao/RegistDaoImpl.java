package com.psychologicalcounseling.login.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.util.BaseDao;

@Repository
public class RegistDaoImpl extends BaseDao{
     
	public int insertUser(String phone) {
		String hql="insert into User(userPhone,registTime) values(?,?)";
		//返回影响的条数
		return insert(hql,phone,new Date());
	}
	

}
