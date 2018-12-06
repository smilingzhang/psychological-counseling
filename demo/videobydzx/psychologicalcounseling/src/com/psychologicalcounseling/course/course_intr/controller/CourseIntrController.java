package com.psychologicalcounseling.course.course_intr.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psychologicalcounseling.course.course_intr.service.CourseIntrService;
import com.psychologicalcounseling.entity.Course;

@Controller
public class CourseIntrController {
	@Resource
	private CourseIntrService courseIntrService;
	
	@RequestMapping("/course-intr")
	public void getCourseIntr(@RequestParam("courseId") int courseId,@RequestParam("userId") int userId,HttpServletRequest request) {
		Course course =courseIntrService.findCourse(courseId);
		request.getSession().setAttribute("course", course);
		boolean b = true;
		if(course.getCoursePrice()!=0.0) {
			b = courseIntrService.ifBuyCourse(courseId, userId);
		}else {
			b = courseIntrService.ifCollectionCourse(userId, courseId);
		}
		request.getSession().setAttribute("ifbc", b);
		System.out.println("课程名："+course.getCourseName()+"价格："+course.getCoursePrice()+"ifbc:"+b+"user:"+course.getTeacher().getUser().getUserNickName());
		
	}
}
