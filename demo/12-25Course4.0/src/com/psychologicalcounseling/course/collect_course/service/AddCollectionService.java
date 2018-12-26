package com.psychologicalcounseling.course.collect_course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psychologicalcounseling.course.collect_course.dao.InsertCollectionDaoImpl;

@Service
@Transactional(readOnly=false)
public class AddCollectionService {
	//注入插入收藏表的dao
	@Resource
	private InsertCollectionDaoImpl insertCollectionDaoImpl;
	
	public void addCollection(int userId,int courseId) {
		//调用dao层方法
		int i = insertCollectionDaoImpl.insertCollection(userId, courseId);
		//对返回的影响行数进行判断
		if(i==0) {
			System.out.println("课程收藏表插入失败");
		}else {
			System.out.println("课程收藏表插入成功");
		}
	}
}
