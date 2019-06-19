package com.courseing.course.course.service;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.courseing.course.course.dao.UpdateJoinInPersonDaoImpl;

@Service
@Transactional(readOnly=false)
public class JoinInService {
	@Resource
	private UpdateJoinInPersonDaoImpl updateJoinInPersonDaoImpl;
	private Logger logger = Logger.getLogger(JoinInService.class);
	
	public void addJoinInPerson(int courseId) {
		int i = updateJoinInPersonDaoImpl.updateJoinInPerson(courseId);
		if(i==0) {
			logger.info("加入人数更新失败");
		}else {
			logger.info("加入人数更新成功");
		}
		
	}
}
