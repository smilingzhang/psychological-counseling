package com.psychologicalcounseling.course.course_intr.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psychologicalcounseling.course.course_intr.dao.CourseConllectionDaoImpl;
import com.psychologicalcounseling.course.course_intr.dao.CourseIntrDaoImpl;
import com.psychologicalcounseling.course.course_intr.dao.CourseOrderDaoImpl;
import com.psychologicalcounseling.entity.Course;

@Service
@Transactional(readOnly=true)
public class CourseIntrService {
	@Resource
	private CourseIntrDaoImpl<Course> courseIntrDaoImpl;
	
	@Resource
	private CourseOrderDaoImpl courseOrderDaoImpl;
	
	@Resource
	private CourseConllectionDaoImpl courseConllectionDaoImpl;
	
	public Course findCourse(int id) {
		return courseIntrDaoImpl.findById(id);
	}
	public Boolean ifBuyCourse(int courseId,int userId) {
		boolean b = courseOrderDaoImpl.findOrder(courseId, userId);
		return b;
	}
	public Boolean ifCollectionCourse(int userId,int courseId) {
		int i = courseConllectionDaoImpl.findCollection(userId, courseId);
		if(i==0) return false;
		else return true;
	}
}
