package com.Consultation.appointmentconsult.dao;

import org.springframework.stereotype.Repository;

import com.entity.Teacher;
import com.util.BaseDao;
@Repository
public class ConsultOrderTeacherDao extends BaseDao<Teacher>{

	/**
	 * 
	 *@desc:查询咨询师对象存到咨询订单表中
	 *@param teacherId
	 *@return
	 *@return:Teacher
	 *@trhows
	 */
	public Teacher selectTeacherById(int teacherId) {
		return get(Teacher.class, teacherId);
		
	}

}
