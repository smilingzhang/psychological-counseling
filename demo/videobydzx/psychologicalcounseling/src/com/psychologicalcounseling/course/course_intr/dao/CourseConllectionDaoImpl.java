package com.psychologicalcounseling.course.course_intr.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.Collection;
import com.psychologicalcounseling.util.BaseDao;
@Repository
public class CourseConllectionDaoImpl extends BaseDao<Collection> {
	
	public int findCollection(int userId,int courseId) {
		List<Collection> list =find("from Collection c where c.uesrId = ? and c.course.courseId = ?", userId,courseId);
		return list.size();
	}
}
