package com.Consultation.appointmentconsult.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Consultation.appointmentconsult.dao.ConsultOrderDao;
import com.entity.ConsultationRecord;
import com.entity.Teacher;
/**
 * 
 *@desc:咨询订单相关service
 *@author chunhui
 *@date:Nov 29, 20182:02:02 PM
 */
import com.entity.User;
@Service
@Transactional(readOnly=false)
public class ConsultOrderService {
	@Resource
	private ConsultOrderDao consultOrderDao;
	
	public int addConsultOrder(ConsultationRecord consultOrder) {
		return this.consultOrderDao.insertConsultOrder(consultOrder);
	}
	@Transactional(readOnly=true)
	public User findUserById(int userId) {
		return this.consultOrderDao.selectUserById(userId);
	}
	@Transactional(readOnly=true)
	public Teacher findTeacherById(int teacherId) {
		return this.consultOrderDao.selectTeacherById(teacherId);
	}
	public void modifyRandomNum(String randomNum,int orderId) {
		this.consultOrderDao.updateConsultOrder(randomNum,orderId);
	}
	@Transactional(readOnly=true)
	public boolean findIsConsult(int teacherId,String orderTime,String startTime,String endTime) {
		return this.consultOrderDao.selectIsConsult(teacherId, orderTime, startTime, endTime);
	}
	public void modifyConsultState(int consultOrderId) {
		this.consultOrderDao.updateConsultState(consultOrderId);
	}
	public boolean findIsHasPhone(int userId) {
		return this.consultOrderDao.selectIsHasPhoneNum(userId);
	}
	public void modifyUserPhoneById(int userId,String userPhone) {
		this.consultOrderDao.updateUserPhoneById(userId, userPhone);
	}

}
