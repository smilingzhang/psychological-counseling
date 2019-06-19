package com.teacher.coursemanager.dao;

import org.springframework.stereotype.Repository;

import com.entity.TypeTable;
import com.util.BaseDao;
@Repository
public class insertCourseType extends BaseDao<TypeTable> {
	public void insertType(int courseId,String ctype) {
		int typeId =find("from TypeTable tt where tt.typetableName=?",ctype).get(0).getTypetableId();
		try {
			excuteBySql("insert into businesstype (businesstypeWorkType,businesstypeWorkId,typetableId)values(?,?,?)", 3,courseId,typeId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
