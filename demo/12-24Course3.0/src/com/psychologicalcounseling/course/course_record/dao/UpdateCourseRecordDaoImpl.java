package com.psychologicalcounseling.course.course_record.dao;

import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.CourseRecord;
import com.psychologicalcounseling.util.BaseDao;
@Repository
/**
 * 
 *@desc:update课程播放记录表
 *@author X段智兴
 *@date:2018年12月10日上午11:19:51
 */
public class UpdateCourseRecordDaoImpl extends BaseDao<CourseRecord> {
	public int updateCourseRecord(int time,int percent,int crid) {
		try {
			System.out.println("crid: "+crid);
			System.out.println("percent: "+percent);
			System.out.println("time: "+time);
			return excuteBySql("update courserecord set courserecordIsFinish=?,courserecordStopPosition=? where courserecordId=?",percent,time,crid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
