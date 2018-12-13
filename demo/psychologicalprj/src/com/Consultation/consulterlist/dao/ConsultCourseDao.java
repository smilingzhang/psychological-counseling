package com.Consultation.consulterlist.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Course;
import com.util.BaseDao;
/**
 * 
 *@desc:查询咨询师的8个精品课程
 *@author chunhui
 *@date:Dec 10, 201810:33:50 AM
 */
@Repository
public class ConsultCourseDao extends BaseDao<Course> {

	/**
	 * 
	 * @desc:查询咨询师的课程，展示8个
	 * @param teacherId
	 * @return
	 * @return:List<Course>
	 * @trhows
	 */
	public List<Course> selectCourseByTeacherId(int teacherId) {
		return findByPage("from Course c where c.teacher.teacherId=?", 0, 8, teacherId);
	}
}
