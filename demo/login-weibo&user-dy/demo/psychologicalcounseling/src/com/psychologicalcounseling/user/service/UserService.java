/**
 * 
 */
package com.psychologicalcounseling.user.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psychologicalcounseling.entity.ConsultationRecord;
import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.user.dao.UserDao;

/**
 *@desc:一句话被描述
 *@author 邓旸
 *@date:2018年12月3日下午4:08:53
 */
@Service
@Transactional(readOnly=false)
public class UserService {
	@Resource
	private UserDao userDao;
	
	//未开始
	private List<ConsultationRecord> toDoList = null;
	//已完成
	private List<ConsultationRecord> finishedList = null;
	//已取消
	private List<ConsultationRecord> canceledList = null;
	
	/**
	 *@desc:获取User实例对应的未开始咨询实例
	 *@param user
	 *@return
	 *@return:void
	 *@trhows
	 */
	public void splitConsultList(User user) {
		//0. 初始化三个表
		clearList();
		//1. 获取用户的咨询集合
		Set<ConsultationRecord> consultationRecords = user.getConsultationRecords();
		//2. 遍历集合，根据consultState字段拆分表
		for(ConsultationRecord record : consultationRecords) {
			switch(record.getConsultState()) {
			case ConsultationRecord.TODO:
				toDoList.add(record);
				break;
			case ConsultationRecord.FINISHED:
				finishedList.add(record);
				break;
			case ConsultationRecord.CANCELED:
				canceledList.add(record);
				break;
			}
		}
		
	}

	/**
	 *@desc:一句话描述
	 *@return:清空三个表
	 *@trhows
	 */
	private void clearList() {
		
		//未开始
		toDoList = new ArrayList<>();
		//已完成
		finishedList = new ArrayList<>();
		//已取消
		canceledList = new ArrayList<>();
	}

	/**
	 *@desc:通过用户id获取User实例
	 *@param uid
	 *@return
	 *@return:User
	 *@trhows
	 */
	public User getUser(int uid) {
		return userDao.getUser(uid);
	}

	public List<ConsultationRecord> getToDoList() {
		return toDoList;
	}

	public List<ConsultationRecord> getFinishedList() {
		return finishedList;
	}

	public List<ConsultationRecord> getCanceledList() {
		return canceledList;
	}

	/**
	 *@desc:修改咨询状态
	 *@return:boolean 修改结果
	 *@param String 咨询记录id
	 *@param String 用户id
	 *@trhows
	 */
	public boolean changeAppointmentState(int cid, int uid) {
		//获取用户对象
		User user = userDao.getUser(uid);
		//获取咨询记录对象
		Set<ConsultationRecord> crSet = user.getConsultationRecords();
		//遍历set，获取对应记录
		for(ConsultationRecord cr:crSet) {
			//若有相关记录，修改记录
			if(cr.getConsultationrecordId()==cid) {
				cr.setConsultState(ConsultationRecord.CANCELED);
				user.setConsultationRecords(crSet);
				userDao.save(user);
				return true;
			}
		}
		//如果没有相关记录
		return false;
	}
	
	
}
