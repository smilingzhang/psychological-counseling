package com.teacher.coursemanager.dao;

import org.springframework.stereotype.Repository;

import com.entity.CourseRecord;
import com.util.BaseDao;
@Repository
public class SelectLookNum extends BaseDao<CourseRecord> {
	public int selectLookNum(int courseId) {
		try {
			int i =(int)findCount("from CourseRecord cr where cr.course.courseId=?", courseId);
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
