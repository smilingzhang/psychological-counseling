package com.courseing.coursebypython;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.CourseRecord;

@Service
@Transactional(readOnly = true)
public class Uplogservice {
	@Resource
	private UpdataCourseLog updataCourseLog;
	public  List<CourseRecord> upCourseLog(Session session) {
		return updataCourseLog.updataCourseLog(session);
	}
}
