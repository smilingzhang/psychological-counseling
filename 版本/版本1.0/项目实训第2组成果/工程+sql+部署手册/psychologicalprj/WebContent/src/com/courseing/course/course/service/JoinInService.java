package com.courseing.course.course.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.courseing.course.course.dao.UpdateJoinInPersonDaoImpl;

@Service
@Transactional(readOnly = false)
public class JoinInService {
	@Resource
	private UpdateJoinInPersonDaoImpl updateJoinInPersonDaoImpl;

	public void addJoinInPerson(int courseId) {
		int i = updateJoinInPersonDaoImpl.updateJoinInPerson(courseId);
		if (i == 0) {
			System.out.println("加入人数更新失败");
		} else {
			System.out.println("加入人数更新成功");
		}

	}
}
