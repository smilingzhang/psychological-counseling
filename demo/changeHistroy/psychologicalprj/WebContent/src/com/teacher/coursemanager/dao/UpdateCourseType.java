package com.teacher.coursemanager.dao;

import org.springframework.stereotype.Repository;

import com.entity.TypeTable;
import com.util.BaseDao;
@Repository
public class UpdateCourseType extends BaseDao<TypeTable> {
	public void updateType(int courseId,String ctype) {
		int typeId =find("from TypeTable tt where tt.typetableName=?",ctype).get(0).getTypetableId();
		try {
			excuteBySql("update businesstype set typetableId=? where businesstypeWorkId=? and businesstypeWorkType=?",typeId,courseId,3);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
