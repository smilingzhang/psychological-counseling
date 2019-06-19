package com.indexing.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Course;
import com.entity.Teacher;
import com.indexing.service.ConsultationRecordServiceImpl;
import com.indexing.service.CourseServiceImpl;
import com.indexing.service.TeacherServiceImpl;
import com.indexing.service.TypeServiceImpl;

@Controller
public class IndexController {

	@Resource
	private TeacherServiceImpl teacherServiceImpl;
	
	@Resource
	private ConsultationRecordServiceImpl consultationRecordServiceImpl; 

	@Resource
	private TypeServiceImpl typeServiceImpl;
	
	@Resource
	private CourseServiceImpl courseServiceImpl;
	
	/**
	 * 
	 *@desc: ajax 请求的目标
	 *@param condition
	 *@param model
	 *@return:String
	 * @throws Exception 
	 * @trhows
	 */
	@RequestMapping("/selectConsulter")
	public void selectConsulter(String condition, Model model, HttpServletResponse response,HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter p = response.getWriter();
		List<Teacher> consulters = teacherServiceImpl.listConsulterByTypeAndPage(condition);
		
		// 一一对应 咨询的次数
		List<Long> counts = new ArrayList<Long>();
		for(Teacher t: consulters) {
			Long res = consultationRecordServiceImpl.countConsultationRecordByTeacherId(t.getTeacherId());
			counts.add(res);
		}
		model.addAttribute("counts", counts);
		for(int i = 0; i < consulters.size(); ++i) {
			String[] arr = consulters.get(i).getAuthenticationAptitudeName().split(" ");
			String partHtml = "";
			for(int j = 0; j <= 1; ++j) {
				partHtml += "<span class='tag'>" + arr[j] + "</span>";
			}
			p.print("<div class=\"consultor\">\r\n" + 
					"								<!--头像-->\r\n" + 
					"								<div class=\"avatar\">\r\n" + 
					"						<img src='/psychologicalprj/images/" + consulters.get(i).getUser().getUserHeadPath() + "' alt='咨询师'>\r\n" + 
					"								</div>\r\n" + 
					"								<div class=\"info\">\r\n" + 
					"									<!--名字-->\r\n" + 
					"								<span><a href=\"#\">" + consulters.get(i).getUser().getUserRealName() + "</a></span>\r\n" + 
					"									<!--资质-->\r\n"  +
					partHtml + 
					"									<br/>\r\n" + 
					"									<!--咨询人次-->\r\n" + 
					"								<span class=\"tag\">咨询人次&nbsp;<span class=\"stress\">" + counts.get(i) + "</span></span>\r\n" + 
					"									\r\n" + 
					"									<!--好评率-->\r\n" + 
					"								<span class=\"tag\">好评率<span class=\"stress\">" + consulters.get(i).getTeacherPraiseRate() +"%</span></span>\r\n" +
					"								</div>\r\n" + 
					"							</div>");
			
			
		}
		
		
	}
	
	
	@RequestMapping("/selectCourse")
	public void selectCourse(String condition, Model model, HttpServletResponse response,HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter p = response.getWriter();
		List<Course> courses = courseServiceImpl.listCoursesByTypeAndPage(condition);
		
		p.print("<div class=\"recommend-course\" >");
		int len = courses.size();
		for(int i = 0; i < 2 && i < len; ++i) {
			p.print("<a class=\"card\" href=\"###\">");
			p.println("<img src='" + courses.get(i).getCourseImgPath() + "' >"); 
			p.println("<div class=\"caption\">" + courses.get(i).getCourseName() +  "</div></a>"); 
		}
		p.println("</div>");
	
		p.println("<div class=\"recommend-course-small\">");
	
		for(int i = 2; i < 6 && i < len; ++i) {
			p.println("<a class=\"card course\" href=\"###\">");
			p.println("<img src='" + courses.get(i).getCourseImgPath() + "' alt=\"\">"); 
			p.println("<div class=\"card-heading\"><strong>" + courses.get(i).getCourseName() + "</strong></div>"); //${course.courseName } 
			p.println("<div class=\"card-content text-muted\">" + courses.get(i).getTeacher().getUser().getUserRealName() + "</div></a>"); 
			
		}
		p.println("</div>");
	
	}
}
