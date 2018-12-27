package com.courseing.course.join_study.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.courseing.course.join_study.dao.SelectCourseRecordDaoImpl;
import com.entity.CourseRecord;

@Service
@Transactional(readOnly = true)
public class FindCourseRecordService {
	@Resource
	private SelectCourseRecordDaoImpl selectCourseRecordDaoImpl;

	public CourseRecord findCourseRecord(int userId, int courseId) {
		List<CourseRecord> list = selectCourseRecordDaoImpl.selectCourseRecord(userId, courseId);
		if (list.size() == 0) {
			return null;
		} else {
			CourseRecord cr = list.get(0);
			return cr;
		}
	}
}
