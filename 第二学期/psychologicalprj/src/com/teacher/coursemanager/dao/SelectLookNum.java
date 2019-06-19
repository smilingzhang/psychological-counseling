package com.teacher.coursemanager.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.CourseRecord;
import com.util.BaseDao;
@Repository
public class SelectLookNum extends BaseDao<CourseRecord> {
	public int selectLookNum(int courseId) {
		try {
			List<CourseRecord> list = find("from CourseRecord cr where cr.course.courseId=?", courseId);
			return list.size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
