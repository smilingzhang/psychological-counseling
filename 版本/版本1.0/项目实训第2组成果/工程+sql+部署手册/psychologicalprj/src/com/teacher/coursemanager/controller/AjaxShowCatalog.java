package com.teacher.coursemanager.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.courseing.lesson.service.LessonServiceImp;
import com.entity.CourseCatalog;

import net.sf.json.JSONArray;

@Controller
@ResponseBody
public class AjaxShowCatalog {
	@Resource
	private LessonServiceImp lessonServiceImp;
	@RequestMapping("/ajaxshowcatalog")
	public Map<String, Object> showCatalog(@RequestParam(name="courseId")String cid){
		int courseId = Integer.parseInt(cid);
		List<CourseCatalog> list = null;
		List<String> ajaxlist = new ArrayList<String>();
		Map<String, Object> map = new HashMap<>();
		try {
			 list =lessonServiceImp.showContentLesson(courseId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(CourseCatalog cc :list) {
			String s1 ="0|"+cc.getCoursecatalogName();
			ajaxlist.add(s1);
			for(CourseCatalog sonc : cc.getCourseCatalogs()) {
				String s2= "1|"+sonc.getCoursecatalogName()+"|"+sonc.getCoursecatalogResourcePath();
				ajaxlist.add(s2);
			}
		}
		
		JSONArray ja = JSONArray.fromObject(ajaxlist);
		map.put("catalog", ja);
		return map;
	}
}
