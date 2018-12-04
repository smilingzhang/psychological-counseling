package com.psychologicalcounseling.course.course.dao;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.CourseCatalog;
import com.psychologicalcounseling.util.BaseDao;
@Repository
public class CoursePathDaoImpl extends BaseDao<CourseCatalog> {
	
	public CourseCatalog findCourseCatalog(int logId) {
		System.out.println("lujing: "+find("from CourseCatalog c where c.coursecatalogId=?", logId).get(0).getCoursecatalogResourcePath());
		return find("from CourseCatalog c where c.coursecatalogId=?", logId).get(0);
	}
}
