package com.listenning.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Course;
import com.listenning.dao.CourseDaoImpl;

@Service
public class CourseServiceImpl {

	@Resource
	private CourseDaoImpl courseDaoImpl;

	public List<Course> listCoursesByTeacherId(int id) {
		return courseDaoImpl.findCoursesByTeacherId(id);
	}
}
