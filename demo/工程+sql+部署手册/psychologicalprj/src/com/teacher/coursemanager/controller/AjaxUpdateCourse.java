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
public class AjaxUpdateCourse {
	@Resource
	private CourseInformationService courseInformationService;
	@RequestMapping("/updatacourseinformation")
	public Map<String, Object> updateCourseInformation(HttpServletRequest request) {
		String ctype=request.getParameter("ctype");
		String cname=request.getParameter("cname");
		String cprice=request.getParameter("cprice");
		String imgpath = request.getParameter("imgFileName");
		Float fprice =Float.parseFloat(cprice);
		String csynopsis=request.getParameter("csynopsis");
		String wang=request.getParameter("wang");
		String cid = request.getParameter("courseId");
		int courseId= Integer.parseInt(cid);
		courseInformationService.UpdateCourse(ctype,cname, fprice, csynopsis, wang, courseId,imgpath);
		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");
		
		return map;
	}
}
