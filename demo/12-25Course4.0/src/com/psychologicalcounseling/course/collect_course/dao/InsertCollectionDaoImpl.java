package com.psychologicalcounseling.course.collect_course.dao;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.Collection;
import com.psychologicalcounseling.util.BaseDao;
@Repository
public class InsertCollectionDaoImpl extends BaseDao<Collection> {
	
	public int insertCollection(int userId,int courseId) {
		//使用原生sql进行数据插入
		return insert("insert into collection(userId,courseId)values(?,?)",userId,courseId);
	}
}
