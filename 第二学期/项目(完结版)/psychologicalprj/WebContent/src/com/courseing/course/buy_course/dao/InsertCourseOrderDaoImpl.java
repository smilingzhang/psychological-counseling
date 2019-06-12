package com.courseing.course.buy_course.dao;

import java.util.Date;

import org.springframework.stereotype.Repository;

import com.entity.CourseOrder;
import com.util.BaseDao;

@Repository
/**
 * @desc:向课程订单表进行数据的插入操作
 * @author XX
 * @date:2018年12月7日下午4:29:47
 */
public class InsertCourseOrderDaoImpl extends BaseDao<CourseOrder> {

	public int insertCourseOrder(Date date, float price, int userId, int courseId, String orderId) {
		int i = insert(
				"insert into courseorder(courseId,userId,courseorderBuyTime,courseorderPrice,courseorderRandomId) values(?,?,?,?,?)",
				courseId, userId, date, price, orderId);
		return i;
	}
}
