package com.video.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.video.dao.CourseDao;
import com.video.entity.Course;
import com.video.entity.CourseCatalog;

@Service
public class CourseServiceImpl {
	@Resource
	private  CourseDao courseDao;
	
	public List<CourseCatalog> getResourceById(int courseId){
		return this.courseDao.list(courseId);
	}
//	public List<Course> getCourseById(int courseId){
//		return this.courseDao.list1(courseId);
//	}
	public  void insertCourseCatalog(CourseCatalog courseCatalog) {
		courseDao.insertCourseCatalog(courseCatalog);
		
	}
	public void insertCourse(Course course) {
		 this.courseDao.insertCourse(course);
	}
	
}
