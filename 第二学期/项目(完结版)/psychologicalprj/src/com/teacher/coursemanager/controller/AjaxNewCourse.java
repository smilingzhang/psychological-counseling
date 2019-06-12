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
		//System.out.println("ctype="+ctype+",cname="+cname+",carticleContent="+articleContent);
		Map<String, Object>map = new HashMap<>();
		int cid = courseInformationService.addCourse(teacherId, cname, ctype, fprice, imgFileName, csynopsis, articleContent);
		map.put("result", "success");
		map.put("ctype", ctype);
		map.put("cname", cname);
		map.put("cprice", fprice);
		map.put("cimgpath", "images/"+imgFileName);
		map.put("csynopsis", csynopsis);
		map.put("cintroduction", articleContent);
		map.put("cid", cid);
		return map;
	}
}
