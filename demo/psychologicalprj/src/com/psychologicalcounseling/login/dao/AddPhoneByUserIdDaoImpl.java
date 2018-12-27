package com.psychologicalcounseling.login.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.util.BaseDao;

@Repository
public class AddPhoneByUserIdDaoImpl extends BaseDao {
	private Logger logger = Logger.getLogger(AddPhoneByUserIdDaoImpl.class);

	public void updatePhone(String userPhone, String userId) {

		// 这里用的sql语句，用BaseDao里面的insert方法，insert方法同时兼具update的功能。
		String sql = "update user set userPhone=? where userId=?";
		int result = insert(sql, userPhone, userId);

		if (result == 1) {
			logger.info("第三方用户手机号更新成功");
		} else {
			logger.info("第三方用户手机号更新失败");

		}
	}

}
