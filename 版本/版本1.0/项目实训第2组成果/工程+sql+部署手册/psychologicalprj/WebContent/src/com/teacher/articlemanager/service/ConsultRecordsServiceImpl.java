package com.teacher.articlemanager.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.ConsultationRecord;
import com.entity.ListenRecord;
import com.entity.User;
import com.teacher.articlemanager.dao.ConsultRecordsDaoImpl;



@Service
public class ConsultRecordsServiceImpl {
	
	@Resource
	private ConsultRecordsDaoImpl consultRecordsDaoImpl;
	//---------------------------------咨询订单----------------------------------------
	/**
	 * 分页查询出已完成的咨询订单
	 * @param pageNum
	 * @param pageSize
	 * @param teacherId
	 * @return
	 */
	public List<ConsultationRecord> findFinishedConsultationRecordByPage(int pageNum,int pageSize,int teacherId){
		return this.consultRecordsDaoImpl.selectFinishedConsultationRecordByPage(pageNum,pageSize,teacherId);
	}
	/**
	 * 查询出已完成的咨询订单数量
	 * @param teacherId
	 * @return
	 */
	public int findCountFinishedConsultationRecord(int teacherId) {
		return this.consultRecordsDaoImpl.selectCountFinishedConsultationRecord(teacherId);
	}
	
	/**
	 *分页 查询出未咨询的订单
	 * @param pageNum
	 * @param pageSize
	 * @param teacherId
	 * @return
	 */
	public List<ConsultationRecord> findTodoConsultationRecordByPage(int pageNum,int pageSize,int teacherId){
		return this.consultRecordsDaoImpl.selectTodoConsultationRecordByPage(pageNum,pageSize,teacherId);
	}
	
	/**
	 * 查询出未咨询的订单数量
	 * @param teacherId
	 * @return
	 */
	public int findCountTodoConsultationRecord(int teacherId) {
		return this.consultRecordsDaoImpl.selectCountTodoConsultationRecord(teacherId);
	}
	/**
	 * 分页查询出已取消的咨询订单
	 * @param pageNum
	 * @param pageSize
	 * @param teacherId
	 * @return
	 */
	public List<ConsultationRecord> findCanceledConsultationRecordByPage(int pageNum,int pageSize,int teacherId){
		return this.consultRecordsDaoImpl.selectCanceledConsultationRecordByPage(pageNum,pageSize,teacherId);
	}
	
	/**
	 * 查询出已取消的咨询订单数量
	 * @param teacherId
	 * @return
	 */
	public int findCountCanceledConsultationRecord(int teacherId) {
		return this.consultRecordsDaoImpl.selectCountCanceledConsultationRecord(teacherId);
	}
	
	//--------------------------------倾听订单-------------------------------------------
	/**
	 * 分页查询已倾听的订单
	 * @param pageNum
	 * @param pageSize
	 * @param teacherId
	 * @return
	 */
	public List<ListenRecord>  findFinishedListenRecordByPage(int pageNum,int pageSize,int teacherId){
		return this.consultRecordsDaoImpl.selectFinishedListenRecordByPage(pageNum,pageSize,teacherId);
	}
	
	/**
	 * 分页查询未倾听的订单
	 * @param pageNum
	 * @param pageSize
	 * @param teacherId
	 * @return
	 */
	public List<ListenRecord>  findTodoListenRecordByPage(int pageNum,int pageSize,int teacherId){
		return this.consultRecordsDaoImpl.selectTodoListenRecordByPage(pageNum,pageSize,teacherId);
	}
	
	/**
	 * 分页查询已取消的订单
	 * @param pageNum
	 * @param pageSize
	 * @param teacherId
	 * @return
	 */
	public List<ListenRecord>  findCanceledListenRecordByPage(int pageNum,int pageSize,int teacherId){
		return this.consultRecordsDaoImpl.selectCanceledListenRecordByPage(pageNum,pageSize,teacherId);
	}
	
	/**
	 * 查询出已倾听的订单数量
	 * @param teacherId
	 * @return
	 */
	public int findCountfinishedListenRecord(int teacherId) {
		return this.consultRecordsDaoImpl.selectCountfinishedListenRecord(teacherId);
	}
	
	public int findCounttodoListenRecord(int teacherId) {
		return this.consultRecordsDaoImpl.selectCounttodoListenRecord(teacherId);
	}
	
	public int findCountcanceledListenRecord(int teacherId) {
		return this.consultRecordsDaoImpl.selectCountcanceledListenRecord(teacherId);
	}
	
	/**
	 * 查询用户
	 * @param userId
	 * @return
	 */
	public User findUserByUserId(int userId) {
		User user = this.consultRecordsDaoImpl.selectUserByUserId(userId);
		User user1 = new User();
		user1.setUserRealName(user.getUserRealName());
		user1.setUserSex(user.getUserSex());
		user1.setUserAge(user.getUserAge());
		user1.setUserPhone(user.getUserPhone());
		return user1;
	}

}
