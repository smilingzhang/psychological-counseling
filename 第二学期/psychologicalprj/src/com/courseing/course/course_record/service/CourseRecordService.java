package com.courseing.course.course_record.service;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.courseing.course.course_intr.dao.CourseIntrDaoImpl;
import com.courseing.course.course_record.dao.InsertCourseRecordDaoImpl;
import com.courseing.course.course_record.dao.UpdateCourseRecordDaoImpl;
import com.courseing.user.dao.FindUserDaoImpl;
import com.entity.Course;
import com.entity.User;


@Service
@Transactional(readOnly=false)
public class CourseRecordService {
	
	@Resource
	private InsertCourseRecordDaoImpl insertCourseRecordDaoImpl;
	@Resource
	private UpdateCourseRecordDaoImpl updateCourseRecordDaoImpl;
	@Resource
	private CourseIntrDaoImpl courseIntrDaoImpl;
	@Resource
	private FindUserDaoImpl findUserDaoImpl;
	private Logger logger = Logger.getLogger(CourseRecordService.class);
	
	public int addCourseRecord(int userId,int courseId,Date date,int logId) {
		Course course = courseIntrDaoImpl.findById(courseId);
		User user = findUserDaoImpl.selectUserById(userId);
		Serializable crid = insertCourseRecordDaoImpl.insertCourseRecord(user, course, date, logId);
		if(crid==null) {
			logger.info("课程学习记录插入失败");
			return 0;
		}else {
			int i = (int)crid;
			logger.info("课程学习记录插入成功");
			return i;
		}
	}
	
	@Transactional
	public void setCourseRecord(int time,int totaltime,int crid) {
		//计算播放了的视频的百分比
		int percent = time*100/totaltime;
		//调用dao方法更新数据
		int i =updateCourseRecordDaoImpl.updateCourseRecord(time, percent, crid);
		if(i==0) {
			logger.info("更新学习记录表失败");
		}else {
			logger.info("更新学习记录表成功");
		}
	}
	
}
