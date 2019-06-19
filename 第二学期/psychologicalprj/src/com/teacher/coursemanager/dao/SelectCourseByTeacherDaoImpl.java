package com.teacher.coursemanager.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Course;
import com.util.BaseDao;
@Repository
/**
 * 
 *@desc:通过teacherId和pageNo 查询该咨询师已上传的课程信息
 *@author 段智兴
 *@date:2018年12月24日下午2:07:21
 */
public class SelectCourseByTeacherDaoImpl extends BaseDao<Course> {
	public List<Course> selectCourseByTeacher(int teacherId,int pageNo){
//		List<Course> list = find("from Course c where c.teacher.teacherId=? order by c.courseId desc",teacherId);
		List<Course> list =findByPage("from Course c where c.teacher.teacherId=? order by c.courseId desc", pageNo, 4, teacherId);
		return list;
		
	}
}
