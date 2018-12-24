package com.psychologicalcounseling.course.course_intr.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.CourseOrder;
import com.psychologicalcounseling.util.BaseDao;


@Repository
public class CourseOrderDaoImpl extends BaseDao<CourseOrder> {
	
	/**
	 * 通过用户Id和课程Id 来查询订单表，返回用户是否购买了该课程
	 * @param courseId
	 * @param userId
	 * @return
	 */
	public Boolean findOrder(int courseId, int userId) {
		List<CourseOrder> ifbuy = find("from CourseOrder co where co.course.courseId = ? and co.user.userId = ?",courseId,userId);
		if(ifbuy.size()==0) return false;
		else return true;
	}
}
