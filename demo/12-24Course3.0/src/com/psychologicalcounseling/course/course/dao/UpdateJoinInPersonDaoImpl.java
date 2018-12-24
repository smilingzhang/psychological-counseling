package com.psychologicalcounseling.course.course.dao;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.Course;
import com.psychologicalcounseling.util.BaseDao;
@Repository
public class UpdateJoinInPersonDaoImpl extends BaseDao<Course> {
	
	public int updateJoinInPerson(int courseId) {
		try {
			return excuteBySql("update course set courseStudentNumber=courseStudentNumber+1 where courseId=?", courseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
	
}
