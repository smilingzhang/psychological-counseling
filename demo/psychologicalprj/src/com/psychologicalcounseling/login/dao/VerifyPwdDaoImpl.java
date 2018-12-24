package com.psychologicalcounseling.login.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.User;
import com.util.BaseDao;

@Repository

public class VerifyPwdDaoImpl extends BaseDao {

	public String findPwdByPhone(String phone) {
		String hql = "from User where userPhone=?";
		List<User> list = find(hql, phone);
		return list.get(0).getUserPassword();

	}

}
