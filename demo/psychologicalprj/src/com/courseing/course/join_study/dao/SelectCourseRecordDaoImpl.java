package com.courseing.course.join_study.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.CourseRecord;
import com.util.BaseDao;
@Repository
public class SelectCourseRecordDaoImpl extends BaseDao<CourseRecord> {
	public List<CourseRecord> selectCourseRecord(int userId,int courseId) {
		 List<CourseRecord>list =find("from CourseRecord cr where cr.user.userId=? and cr.course.courseId=? order by cr.courserecordStartTime desc",userId,courseId);
		// System.out.println("第一个记录："+list.get(0).getCourserecordStartTime());
		// System.out.println("第二个记录："+list.get(1).getCourserecordStartTime());
		// System.out.println("第三个记录："+list.get(2).getCourserecordStartTime());
		 return list;
	}
}
