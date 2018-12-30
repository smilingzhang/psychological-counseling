package com.courseing.course.course_intr.dao;

import org.springframework.stereotype.Repository;

import com.entity.Course;
import com.util.BaseDao;

@Repository
public class CourseIntrDaoImpl extends BaseDao<Course> {

	/**
	 * 通过课程Id进行课程的查询
	 * 
	 * @param id
	 * @return 查询到的课程
	 */
	public Course findById(int id) {

		return get(Course.class, id);
	}

}
