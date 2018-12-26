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
import com.psychologicalcounseling.util.EncryUtil;

@Controller
public class JoinStudyController {
	@Resource
	private FindCourseRecordService findCourseRecordService;
	@Resource
	private CourseCatalogService courseCatalogService;
	@RequestMapping("/joinstudy")
	public void ifHaveRecord(@RequestParam(name="courseId")String cid,@RequestParam(name="ifbc") String eifbc,HttpSession session,HttpServletResponse response) {
		cid=EncryUtil.decrypt(cid);
		//eifbc=EncryUtil.decrypt(eifbc);
		int courseId = Integer.parseInt(cid);
		/*boolean ifbc = false;
		if(eifbc.equals("true")) {
			ifbc=true;
		}*/
		
		int userId = 0;
		Object obj = session.getAttribute("userId");
		if(obj == null) {
			try {
				response.sendRedirect("login.jsp");
				return;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			userId =(int)obj;
		}
		CourseRecord cr =findCourseRecordService.findCourseRecord(userId, courseId);
		int startPosition = 0;
		int logId = courseCatalogService.findFirstLog(courseId);
		if(cr!=null) {
			startPosition=cr.getCourserecordStopPosition();
			logId=cr.getCoursecatalogId();
		}
		try {
			String logIds = EncryUtil.encrypt(Integer.toString(logId));
			String startPositions = EncryUtil.encrypt(Integer.toString(startPosition));
			String courseIds = EncryUtil.encrypt(Integer.toString(courseId));
			String ifbcs = EncryUtil.encrypt(eifbc);
			response.sendRedirect("course?courseCatalogId="+logIds+"&startPosition="+startPositions+"&courseId="+courseIds+"&firesun="+ifbcs);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
