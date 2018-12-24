package com.Consultation.appointmentconsult.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Consultation.appointmentconsult.dao.ConsultOrderDao;
import com.Consultation.appointmentconsult.dao.ConsultOrderTeacherDao;
import com.Consultation.appointmentconsult.dao.ConsultOrderUserDao;
import com.Consultation.appointmentconsult.dao.ListenOrderDao;
import com.entity.ConsultationRecord;
import com.entity.ListenRecord;
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
	@Resource
	private ConsultOrderUserDao consultOrderUserDao;
	@Resource
	private ConsultOrderTeacherDao consultOrderTeacherDao;
	@Resource
	private ListenOrderDao listenOrderDao;
	
	@Transactional(readOnly=true)
	public boolean findIsHasPhone(int userId) {
		return this.consultOrderDao.selectIsHasPhoneNum(userId);
	}
	public void modifyUserPhoneById(int userId,String userPhone) {
		this.consultOrderDao.updateUserPhoneById(userId, userPhone);
	}
	/**
	 * 
	 *@desc:咨询记录表生成订单
	 *@param userId
	 *@param teacherId
	 *@param date
	 *@param teacherPrice
	 *@param content
	 *@param consultType
	 *@return
	 *@return:int
	 *@trhows
	 */
	public int generateConsultOrder(int userId,int teacherId,String date,String teacherPrice,String content,String consultType) {
		String[] aStrings=content.split("-");
		User user=this.consultOrderUserDao.selectUserById(userId);
		Teacher teacher=this.consultOrderTeacherDao.selectTeacherById(teacherId);
		float price=Float.valueOf(teacherPrice);
		ConsultationRecord consultationRecord=new ConsultationRecord();
		consultationRecord.setUser(user);
		consultationRecord.setTeacher(teacher);
		consultationRecord.setConsultationrecordOrderTime(date);
		consultationRecord.setConsultationrecordStartTime(aStrings[0]);
		consultationRecord.setConsultationrecordEndTime(aStrings[1]);
		consultationRecord.setConsultationrecordPrice(price);
		consultationRecord.setConsultationrecordMethod(consultType);
		//订单流水号	
		int consultOrderId=this.consultOrderDao.insertConsultOrder(consultationRecord);
		return consultOrderId;
	}
	/**
	 * 
	 *@desc:倾听记录表生成订单
	 *@param userId
	 *@param teacherId
	 *@param teacherPrice
	 *@param date
	 *@return
	 *@return:int
	 *@trhows
	 */
	public int generateListenOrder(int userId,int teacherId,String teacherPrice,String date) {
		System.out.println("当前时间为："+new Date());
		User user=this.consultOrderUserDao.selectUserById(userId);
		Teacher teacher=this.consultOrderTeacherDao.selectTeacherById(teacherId);
		float price=Float.valueOf(teacherPrice);
		ListenRecord listenRecord=new ListenRecord();
		listenRecord.setUser(user);
		listenRecord.setTeacher(teacher);
		listenRecord.setListenrecordOrderTime(date);
		listenRecord.setListenrecordPrice(price);
		int listenOrderId=this.listenOrderDao.insertListenOrder(listenRecord);
		return listenOrderId;
	}
	public void modifyRandomNum(String randomNum,int orderId) {
		this.consultOrderDao.updateConsultOrder(randomNum,orderId);
	}
	public void modifyListenRandomNum(String randomNum,int orderId) {
		this.consultOrderDao.updateListenOrderRandom(randomNum, orderId);
	}
	@Transactional(readOnly=true)
	public boolean findIsConsult(int teacherId,String orderTime,String startTime,String endTime) {
		return this.consultOrderDao.selectIsConsult(teacherId, orderTime, startTime, endTime);
	}
	public void modifyConsultState(int consultOrderId) {
		this.consultOrderDao.updateConsultState(consultOrderId);
	}
	public void modifyConsulterTime(String date,int teacherId,int number) {
		this.consultOrderTeacherDao.updateConsulterTime(date,teacherId, number);
	}
	
	public void modifyListenState(int listenOrderId) {
		this.listenOrderDao.updateListenState(listenOrderId);
	}
	public void modifyCanListen(int teacherId) {
		this.listenOrderDao.updateConsulterCanListen(teacherId);
	}
	public void delConsultOrderMessage(int consultOrderId) {
		this.consultOrderDao.deleteConsultOrderMessage(consultOrderId);
	}

}
