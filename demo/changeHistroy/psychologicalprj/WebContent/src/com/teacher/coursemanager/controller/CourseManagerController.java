package com.teacher.coursemanager.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.TeacherCourse;
import com.teacher.coursemanager.service.FindTeacherCourseService;

@Controller
public class CourseManagerController {

	//通过userId查出该咨询师所有的课程，一页显示4个
	//查询内容包括：课程分类，课程名，价格，图片，简介，浏览人数，收藏/购买人数，章节数，课时数
	@Resource
	private FindTeacherCourseService findTeacherCourseService;
	@RequestMapping("/background")
	public String findTeacherCourse(@RequestParam(name="teacherId")int teacherId,@RequestParam(name="page")int pageNo,ServletRequest request) {
		List<TeacherCourse> list =findTeacherCourseService.findTeacherCourse(teacherId, pageNo);
		
		request.setAttribute("TeacherCourse", list);
		request.setAttribute("teacherId", teacherId);
		request.setAttribute("pageNo", pageNo);
		return "background";
	}
}
