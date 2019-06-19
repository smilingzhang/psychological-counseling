package com.teacher.coursemanager.dao;

import org.springframework.stereotype.Repository;

import com.entity.Course;
import com.util.BaseDao;
@Repository
public class InsertCourse extends BaseDao<Course> {
	public int insertCourse(int teacherId,String cname,String ctype,float fprice,String imgFileName,String csynopsis,String articleContent) {
		try {
			excuteBySql("insert into course (courseName,teacherId,coursePrice,courseIntroduction,courseImgPath,courseSynopsis)values(?,?,?,?,?,?)", 
					cname,teacherId,fprice,articleContent,"images/"+imgFileName,csynopsis);
			int i=find("from Course c where c.courseName=? and c.teacher.teacherId=?", cname,teacherId).get(0).getCourseId();
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
