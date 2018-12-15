package com.psychologicalcounseling.course.join_study.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psychologicalcounseling.course.course.service.CourseCatalogService;
import com.psychologicalcounseling.course.join_study.service.FindCourseRecordService;
import com.psychologicalcounseling.entity.CourseRecord;

@Controller
public class JoinStudyController {
	@Resource
	private FindCourseRecordService findCourseRecordService;
	@Resource
	private CourseCatalogService courseCatalogService;
	@RequestMapping("/joinstudy")
	public void ifHaveRecord(@RequestParam(name="userId")int userId,@RequestParam(name="courseId")int courseId,@RequestParam(name="ifbc") Boolean ifbc,HttpSession session,HttpServletResponse response) {
		CourseRecord cr =findCourseRecordService.findCourseRecord(userId, courseId);
		int startPosition = 0;
		int logId = courseCatalogService.findFirstLog(courseId);
		if(cr!=null) {
			startPosition=cr.getCourserecordStopPosition();
			logId=cr.getCoursecatalogId();
		}
		try {
			response.sendRedirect("course?courseCatalogId="+logId+"&startPosition="+startPosition+"&courseId="+courseId+"&ifbc="+ifbc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
