package com.teacher.coursemanager.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.teacher.coursemanager.dao.InsertCourse;
import com.teacher.coursemanager.dao.UpdateCourse;
import com.teacher.coursemanager.dao.UpdateCourseCatalog;
import com.teacher.coursemanager.dao.UpdateCourseType;
import com.teacher.coursemanager.dao.insertCourseType;
@Service
@Transactional(readOnly=false)
public class CourseInformationService {
	@Resource
	private UpdateCourse updateCourse;
	@Resource
	private UpdateCourseCatalog updateCourseCatalog;
	@Resource
	private InsertCourse insertCourse;
	@Resource
	private insertCourseType insertCourseType;
	@Resource
	private UpdateCourseType updateCourseType;
	public void UpdateCourse(String ctype,String cname,float fprice,String csynopsis,String wang,int courseId) {
		updateCourse.updateCurse(cname, fprice, csynopsis, wang, courseId);
		updateCourseType.updateType(courseId, ctype);
	}
	public void UpdateCourseCatalog(String data,int cid) {
		try {
			updateCourseCatalog.updateCourseCatalog(data, cid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void addCourse(int teacherId,String cname,String ctype,float fprice,String imgFileName,String csynopsis,String articleContent) {
		int i =insertCourse.insertCourse(teacherId, cname, ctype, fprice, imgFileName, csynopsis, articleContent);
		insertCourseType.insertType(i, ctype);
	}
}
