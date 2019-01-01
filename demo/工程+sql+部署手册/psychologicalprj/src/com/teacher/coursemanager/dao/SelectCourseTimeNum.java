package com.teacher.coursemanager.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.CourseCatalog;
import com.util.BaseDao;


@Repository
public class SelectCourseTimeNum extends BaseDao<CourseCatalog> {
	public int SelectCourseTimeNum(int courseId) {
		try {
			List<CourseCatalog> list =find("from CourseCatalog cc where cc.courseId=?", courseId);
			return list.size() ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
