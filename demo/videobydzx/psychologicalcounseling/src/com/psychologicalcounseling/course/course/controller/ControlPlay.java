package com.psychologicalcounseling.course.course.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.hql.internal.ast.tree.BooleanLiteralNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psychologicalcounseling.course.course.service.CourseCatalogService;
import com.psychologicalcounseling.entity.Course;
import com.psychologicalcounseling.entity.CourseCatalog;

@Controller
public class ControlPlay {
	@Resource
	private CourseCatalogService courseCatalogService;
	@RequestMapping("/course")
	public String controlPlay(@RequestParam(name="courseCatalogId") int logId,HttpServletRequest request) {
		Course course =(Course) request.getSession().getAttribute("course");
		Boolean ifbc = (Boolean) request.getSession().getAttribute("ifbc");
//		System.out.println(course.getCourseName());
//		System.out.println("ifbc: "+ ifbc);
		Boolean ifplay = false;
		if(course.getCoursePrice()==0||(true==ifbc)) {
			ifplay=true;
		}
		request.getSession().setAttribute("ifplay", ifplay);
		CourseCatalog courseCatalog =courseCatalogService.getCourseCatalog(logId);
		request.getSession().setAttribute("courseCatalog", courseCatalog);
		return "course";
	}
}
