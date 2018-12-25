package com.psychologicalcounseling.test;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.Teacher;
import com.psychologicalcounseling.util.BaseDao;



@Repository
public class ConsultOrderTeacherDao extends BaseDao<Teacher> {

	/**
	 * 
	 * @desc:查询咨询师对象存到咨询订单表中
	 * @param teacherId
	 * @return
	 * @return:Teacher
	 * @trhows
	 */
	public Teacher selectTeacherById(int teacherId) {
		return get(Teacher.class, teacherId);

	}

	/**
	 * 
	 * @desc:根据咨询师id修改被预约时间的状态值为0
	 * @param teacherId
	 * @param number
	 * @return:void
	 * @trhows
	 */
	public void updateConsulterTime(String date, int teacherId, int number) {
		Session session = sessionFactory.getCurrentSession();
		Query query = null;

		if (number == 8) {
			query = session.createSQLQuery("update teachertime set time8=? where teacherId=? and date=?");
		}
		if (number == 9) {
			query = session.createSQLQuery("update teachertime set time9=? where teacherId=? and date=?");
		}
		if (number == 10) {
			query = session.createSQLQuery("update teachertime set time10=? where teacherId=? and date=?");
		}
		if (number == 11) {
			query = session.createSQLQuery("update teachertime set time11=? where teacherId=? and date=?");
		}
		if (number == 12) {
			query = session.createSQLQuery("update teachertime set time12=? where teacherId=? and date=?");
		}
		if (number == 13) {
			query = session.createSQLQuery("update teachertime set time13=? where teacherId=? and date=?");
		}
		if (number == 14) {
			query = session.createSQLQuery("update teachertime set time14=? where teacherId=? and date=?");
		}
		if (number == 15) {
			query = session.createSQLQuery("update teachertime set time15=? where teacherId=? and date=?");
		}
		if (number == 16) {
			query = session.createSQLQuery("update teachertime set time16=? where teacherId=? and date=?");
		}
		if (number == 17) {
			query = session.createSQLQuery("update teachertime set time17=? where teacherId=? and date=?");
		}
		if (number == 18) {
			query = session.createSQLQuery("update teachertime set time18=? where teacherId=? and date=?");
		}
		if (number == 19) {
			query = session.createSQLQuery("update teachertime set time19=? where teacherId=? and date=?");
		}
		query.setParameter(0, 0);
		query.setParameter(1, teacherId);
		query.setParameter(2, date);
		query.executeUpdate();
	}
}
