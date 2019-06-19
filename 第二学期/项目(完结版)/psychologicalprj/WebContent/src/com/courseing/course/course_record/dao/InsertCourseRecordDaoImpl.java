package com.courseing.course.course_record.dao;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

import com.entity.Course;
import com.entity.CourseRecord;
import com.entity.User;
import com.util.BaseDao;

@Repository
public class InsertCourseRecordDaoImpl extends BaseDao<CourseRecord> {
	public Serializable insertCourseRecord(User user, Course course, Date date, int logId) {
		try {
			CourseRecord cr = new CourseRecord();
			cr.setCourse(course);
			cr.setUser(user);
			cr.setCourserecordStartTime(date);
			cr.setCoursecatalogId(logId);

			return save(cr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
