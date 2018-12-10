package com.searchcourse.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Course;
import com.util.BaseDao;
/**
 * 
 *@desc:搜索所有课程
 *@author chunhui
 *@date:Dec 10, 201810:34:54 AM
 */
@Repository
public class SearchCourseDao extends BaseDao<Course>{

	public List<Course> searchAllCourses() {
		return findAll(Course.class);	
	}

}
