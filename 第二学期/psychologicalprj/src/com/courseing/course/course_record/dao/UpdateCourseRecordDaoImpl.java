package com.courseing.course.course_record.dao;

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
	public int updateCourseRecord(int time, int percent, int crid) {
		try {
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
