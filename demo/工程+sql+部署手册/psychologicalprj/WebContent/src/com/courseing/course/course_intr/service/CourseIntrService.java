package com.courseing.course.course_intr.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.courseing.course.course_intr.dao.CourseConllectionDaoImpl;
import com.courseing.course.course_intr.dao.CourseIntrDaoImpl;
import com.courseing.course.course_intr.dao.CourseOrderDaoImpl;
import com.entity.Course;

@Service
@Transactional(readOnly = true)
public class CourseIntrService {
	@Resource
	private CourseIntrDaoImpl courseIntrDaoImpl;

	@Resource
	private CourseOrderDaoImpl courseOrderDaoImpl;

	@Resource
	private CourseConllectionDaoImpl courseConllectionDaoImpl;

	// 通过课程id查课程
	public Course findCourse(int id) {
		return courseIntrDaoImpl.findById(id);
	}

	// 查询该用户是否购买过该课程
	public Boolean ifBuyCourse(int courseId, int userId) {
		boolean b = courseOrderDaoImpl.findOrder(courseId, userId);
		return b;
	}

	// 查询该用户是否收藏过该课程
	public Boolean ifCollectionCourse(int userId, int courseId) {
		int i = courseConllectionDaoImpl.findCollection(userId, courseId);
		if (i == 0)
			return false;
		else
			return true;
	}
}
