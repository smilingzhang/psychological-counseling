package com.teacher.coursemanager.dao;

import org.springframework.stereotype.Repository;

import com.entity.CourseCatalog;
import com.util.BaseDao;
@Repository
public class SelectParentNum extends BaseDao<CourseCatalog> {
	public int SelectParentNum(int courseId) {
		
		try {
			int i =(int)findCount("from CourseCatalog cc where cc.courseId=? and cc.parentCourseCatalog.coursecatalogId=null", courseId);
			
			return i;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
}
