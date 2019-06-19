package com.courseing.course.course_intr.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Collection;
import com.util.BaseDao;
@Repository
/**
 * 
 *@desc:查询用户是否收藏了该课程
 *@author 段智兴
 *@date:2018年12月7日下午5:04:11
 */
public class CourseConllectionDaoImpl extends BaseDao<Collection> {
	
	public int findCollection(int userId,int courseId) {
		List<Collection> list =find("from Collection c where c.uesrId = ? and c.course.courseId = ?", userId,courseId);
		return list.size();
	}
}
