package com.teacher.coursemanager.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.courseing.course.course_intr.service.CourseIntrService;
import com.courseing.lesson.service.LessonServiceImp;
import com.entity.Course;
import com.entity.TeacherCourse;
import com.entity.TypeTable;
import com.sun.glass.ui.CommonDialogs.Type;
import com.teacher.coursemanager.dao.SelectCourseType;

@Controller
@ResponseBody
public class AjaxShowCourse {
	@Resource
	private LessonServiceImp lessonServiceImp;
	@Resource
	private CourseIntrService courseIntrService;
	@Resource
	private SelectCourseType selectCourseType;
	@RequestMapping("/ajaxeditcourse")
	public Map<String, Object> ajaxEditCourse(@RequestParam(name="courseId")String courseId,HttpSession session) {
		int cid = Integer.parseInt(courseId);
		Course course =courseIntrService.findCourse(cid);
//		Set<TypeTable> alltype = lessonServiceImp.showLessonType();
		String ctype =selectCourseType.SelectCourseType(cid).get(0);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ctype", ctype);
		map.put("cname", course.getCourseName());
		map.put("cprice", course.getCoursePrice());
		map.put("cimgpath", course.getCourseImgPath());
		map.put("csynopsis", course.getCourseSynopsis());
		map.put("cintroduction", course.getCourseIntroduction());
//		map.put("alltype", alltype);
		map.put("cid", cid);
		return map;
	}
}
