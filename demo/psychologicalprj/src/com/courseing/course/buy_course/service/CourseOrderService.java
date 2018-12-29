package com.courseing.course.buy_course.service;

import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.courseing.course.buy_course.dao.InsertCourseOrderDaoImpl;

@Service
@Transactional(readOnly=false)
/**
 *@desc:调用dao层的方法
 *@author 段智兴
 *@date:2018年12月7日下午4:35:00
 */
public class CourseOrderService {
	@Resource
	private InsertCourseOrderDaoImpl insertCourseOrderDaoImpl;
	
	public void addCourseOrder(Date date,float price,int userId,int courseId,String orderId) {
		int i =insertCourseOrderDaoImpl.insertCourseOrder(date, price, userId, courseId, orderId);
		if(i==0) {
			System.out.println("课程订单插入失败");
		}else {
			System.out.println("课程订单插入成功");
		}
		
	}
}
