package com.teacher.coursemanager.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.courseing.lesson.service.LessonServiceImp;
import com.entity.TypeTable;

@Controller
@ResponseBody
public class AjaxShowCourseType {
	@Resource
	private LessonServiceImp lessonServiceImp;
	@RequestMapping("/showcoursetype")
	public Map<String, Object> showType(){
		Set<TypeTable> alltype = lessonServiceImp.showLessonType();
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("alltype", alltype);
		return map;
	}
}

