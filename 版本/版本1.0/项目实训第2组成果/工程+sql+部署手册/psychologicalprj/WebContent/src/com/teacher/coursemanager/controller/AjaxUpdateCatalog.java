package com.teacher.coursemanager.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.teacher.coursemanager.service.CourseInformationService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@ResponseBody
public class AjaxUpdateCatalog {
	@Resource
	private CourseInformationService courseInformationService;
	@RequestMapping("/allsave")
	public Map<String, Object> saveVideos(HttpServletRequest request,HttpServletResponse response) {
		String data=request.getParameter("data");
		int cid = Integer.parseInt(request.getParameter("cid"));
		System.out.println(data);
		courseInformationService.UpdateCourseCatalog(data, cid);
		

		Map<String, Object> map = new HashMap<>();
		map.put("result", "success");

		return map;

	}
}
