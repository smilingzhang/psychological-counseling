package com.psychologicalcounseling.course.course.dao;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.CourseCatalog;
import com.psychologicalcounseling.util.BaseDao;
@Repository
/**
 * 
 *@desc:通过logId查询到目录对象
 *@author XX
 *@date:2018年12月7日下午4:54:57
 */
public class CoursePathDaoImpl extends BaseDao<CourseCatalog> {
	
	public CourseCatalog findCourseCatalog(int logId) {
		return get(CourseCatalog.class, logId);
	
	}
}
