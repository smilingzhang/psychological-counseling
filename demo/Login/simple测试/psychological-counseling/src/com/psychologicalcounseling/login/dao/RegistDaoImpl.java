package com.psychologicalcounseling.login.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.util.BaseDao;
/**
 * 
 *@desc:一句话被描述
 *@author 刘田会
 *@date:2018年12月23日下午10:03:19
 */
@Repository
public class RegistDaoImpl extends BaseDao{
     
	public int insertUser(String phone) {
		String sql="insert into user(userPhone,userRegistTime,userIdentity,userHeadPath) values(?,?,?,?)";
		//返回影响的条数
		return insert(sql,phone,new Date(),User.IDENTITY_USER,"images/consultant.png");
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
