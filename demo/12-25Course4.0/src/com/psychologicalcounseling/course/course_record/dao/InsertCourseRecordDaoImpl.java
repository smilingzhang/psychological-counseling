package com.psychologicalcounseling.course.course_record.dao;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.Course;
import com.psychologicalcounseling.entity.CourseRecord;
import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.util.BaseDao;
@Repository
public class InsertCourseRecordDaoImpl extends BaseDao<CourseRecord> {
	public Serializable insertCourseRecord(User user,Course course,Date date,int logId) {
		try {
			CourseRecord cr = new CourseRecord();
			cr.setCourse(course);
			cr.setUser(user);
			cr.setCourserecordStartTime(date);
			cr.setCoursecatalogId(logId);
			
			return save(cr);
		//	return excuteBySql("insert into courserecord(userId,courseId,courserecordStartTime,coursecatalogId)values(?,?,?,?)",userId,courseId,date,logId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
