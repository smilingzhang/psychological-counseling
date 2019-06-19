package com.courseing.course.join_study.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.CourseRecord;
import com.util.BaseDao;

@Repository
public class SelectCourseRecordDaoImpl extends BaseDao<CourseRecord> {
	public List<CourseRecord> selectCourseRecord(int userId, int courseId) {
		List<CourseRecord> list = find(
				"from CourseRecord cr where cr.user.userId=? and cr.course.courseId=? order by cr.courserecordStartTime desc",
				userId, courseId);
		return list;
	}
}
