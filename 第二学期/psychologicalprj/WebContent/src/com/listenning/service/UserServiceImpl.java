package com.listenning.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.Consultation.appointmentconsult.dao.ConsultOrderUserDao;
import com.entity.ConsultationRecord;
import com.entity.ListenRecord;
import com.entity.User;
import com.listenning.dao.UserDaoImpl;

@Service
public class UserServiceImpl {

	@Resource
	private UserDaoImpl userDaoImpl;
	@Resource
	private ConsultOrderUserDao consultOrderUserDao;

	public User getUserByUserNickName(String userNickName) {
		return userDaoImpl.findUserByUserNickName(userNickName);
	}

	public User getOtherUser(User my, ConsultationRecord r) {

		if (my.getUserId() == r.getUser().getUserId()) {

			return r.getTeacher().getUser();
		} else {
			return r.getUser();
		}
	}

	public User getOtherUser(User my, ListenRecord r) {

		if (my.getUserId() == r.getUser().getUserId()) {

			return r.getTeacher().getUser();
		} else {
			return r.getUser();
		}
	}

	public User getUserById(int userId) {
		return this.consultOrderUserDao.selectUserById(userId);
	}
}
