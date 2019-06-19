package com.courseing.course.join_study.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.courseing.course.course.service.CourseCatalogService;
import com.courseing.course.join_study.service.FindCourseRecordService;
import com.entity.CourseRecord;
import com.util.EncryUtil;

@Controller
public class JoinStudyController {
	@Resource
	private FindCourseRecordService findCourseRecordService;
	@Resource
	private CourseCatalogService courseCatalogService;
	@RequestMapping("/joinstudy")
	public void ifHaveRecord(@RequestParam(name="courseId")String cid,@RequestParam(name="ifbc") String eifbc,HttpSession session,HttpServletResponse response) {
		response.setContentType("text/html;charset=utf-8");
		cid=EncryUtil.decrypt(cid);
		//eifbc=EncryUtil.decrypt(eifbc);
		int courseId = Integer.parseInt(cid);
		
		int userId = 0;
		Object obj = session.getAttribute("userId");
		if(obj == null) {
			try {
				response.getWriter().write(
						"<script>alert('请您先完成登录!'); window.location='login.jsp' ;window.close();</script>");
				response.getWriter().flush();
				return ;
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
			//String ifbcs = EncryUtil.encrypt(eifbc);
			response.sendRedirect("course?courseCatalogId="+logIds+"&startPosition="+startPositions+"&courseId="+courseIds+"&firesun="+eifbc);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
