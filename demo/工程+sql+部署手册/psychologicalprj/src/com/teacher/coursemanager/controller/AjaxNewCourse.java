package com.teacher.coursemanager.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teacher.coursemanager.service.CourseInformationService;

@Controller
@ResponseBody
public class AjaxNewCourse {
	@Resource
	private CourseInformationService courseInformationService;
	@RequestMapping("/addcourse")
	public Map<String, Object> addCourse(HttpServletRequest request){
		String ctype=request.getParameter("ctype");
		String cname=request.getParameter("cname");
		String cprice=request.getParameter("cprice");
		Float fprice =Float.parseFloat(cprice);
		String imgFileName=request.getParameter("imgFileName");
		String csynopsis=request.getParameter("csynopsis");
		String articleContent=request.getParameter("articleContent");
		int teacherId = Integer.parseInt(request.getParameter("teacherId"));
		Map<String, Object>map = new HashMap<>();
		courseInformationService.addCourse(teacherId, cname, ctype, fprice, imgFileName, csynopsis, articleContent);
		map.put("result", "success");
		return map;
	}
}
