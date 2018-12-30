package com.teacher.coursemanager.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teacher.coursemanager.service.CourseInformationService;

@Controller
@ResponseBody
public class AjaxUpdateCatalog {
	@Resource
	private CourseInformationService courseInformationService;
	@RequestMapping("/allsave")
	public Map<String, Object> saveVideos(HttpServletRequest request,HttpServletResponse response) {
		String data=request.getParameter("data");
		int cid = Integer.parseInt(request.getParameter("cid"));
		
		courseInformationService.UpdateCourseCatalog(data, cid);
		

		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");

		return map;

	}
}
