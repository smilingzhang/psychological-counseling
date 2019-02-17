package com.teacher.coursemanager.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.util.BaseDao;
@Repository
public class SelectCourseType extends BaseDao<String> {
	public List<String> SelectCourseType(int courseId) {
		List<String>list =find("select bt.typeTable.typetableName from BusinessType bt where bt.businesstypeWorkType=3 and bt.businesstypeWorkId=?", courseId);
		if(list.size()==0) {return null;}
		else return list;
	}
}
