package com.teacher.coursemanager.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.CourseCatalog;
import com.util.BaseDao;
@Repository
public class SelectParentNum extends BaseDao<CourseCatalog> {
	public int SelectParentNum(int courseId) {
		
		try {
			List<CourseCatalog> list = find("from CourseCatalog cc where cc.courseId=? and cc.parentCourseCatalog.coursecatalogId=null", courseId);
			
			return list.size();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
	}
}
