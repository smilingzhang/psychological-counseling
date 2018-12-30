package com.teacher.coursemanager.dao;

import org.springframework.stereotype.Repository;

import com.entity.CourseCatalog;
import com.util.BaseDao;
@Repository
public class SelectCourseTimeNum extends BaseDao<CourseCatalog> {
	public int SelectCourseTimeNum(int courseId) {
		try {
			int i =(int)findCount("from CourseCatalog cc where cc.courseId=?", courseId);
			return i ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
