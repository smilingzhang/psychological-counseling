package com.courseing.course.course_record.dao;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.entity.CourseRecord;
import com.util.BaseDao;

@Repository
/**
 * 
 * @desc:update课程播放记录表
 * @author X段智兴
 * @date:2018年12月10日上午11:19:51
 */
public class UpdateCourseRecordDaoImpl extends BaseDao<CourseRecord> {
	private Logger logger = Logger.getLogger(UpdateCourseRecordDaoImpl.class);

	public int updateCourseRecord(int time, int percent, int crid) {
		try {
			logger.info("crid: " + crid);
			logger.info("percent: " + percent);
			logger.info("time: " + time);
			return excuteBySql(
					"update courserecord set courserecordIsFinish=?,courserecordStopPosition=? where courserecordId=?",
					percent, time, crid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
