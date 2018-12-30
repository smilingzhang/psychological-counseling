package com.Consultation.appointmentconsult.dao;

import org.springframework.stereotype.Repository;

import com.entity.User;
import com.util.BaseDao;

@Repository
public class ConsultOrderUserDao extends BaseDao<User> {

	/**
	 * 
	 * @desc:根据用户Id查询用户对象，实际上应该从session中获取，此方法应该不存在
	 *
	 * @param userId
	 * @return
	 * @return:User
	 * @trhows
	 */
	public User selectUserById(int userId) {
		return get(User.class, userId);
	}

}
