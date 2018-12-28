package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.CourseDaoImpl;
import com.entity.Course;

@Service
public class CourseServiceImpl {

	@Resource
	private CourseDaoImpl courseDaoImpl;
	
	public List<Course> listCoursesByTeacherId(int id) {
		return courseDaoImpl.findCoursesByTeacherId(id);
	}
	
	public List<Course> listCoursesByPage() {	
		return courseDaoImpl.findCoursesByPage();
	}
	
	public List<Course> listCoursesByTypeAndPage(String conditicon) {	
		return courseDaoImpl.findCoursesByTypeAndPage(conditicon);
	}
}
