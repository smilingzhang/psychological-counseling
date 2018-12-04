package com.psychologicalcounseling.course.course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psychologicalcounseling.course.course.dao.CoursePathDaoImpl;
import com.psychologicalcounseling.entity.CourseCatalog;

@Service
@Transactional(readOnly=true)
public class CourseCatalogService {
	@Resource
	private CoursePathDaoImpl coursePathDaoImpl;
	
	public CourseCatalog getCourseCatalog(int logId) {
		return coursePathDaoImpl.findCourseCatalog(logId);
	}
}
