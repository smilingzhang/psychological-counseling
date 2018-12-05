package com.Consultation.consulterlist.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Course;
import com.util.BaseDao;

@Repository
public class ConsultCourseDao extends BaseDao<Course> {

	/**
	 * 
	 * @desc:查询咨询的课程，展示8个
	 * @param teacherId
	 * @return
	 * @return:List<Course>
	 * @trhows
	 */
	public List<Course> selectCourseByTeacherId(int teacherId) {
		return findByPage("from Course c where c.teacher.teacherId=?", 0, 8, teacherId);
	}
}
