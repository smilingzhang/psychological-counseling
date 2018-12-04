package com.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.Course;
import com.entity.Teacher;
import com.service.CourseServiceImpl;
import com.service.TeacherServiceImpl;

@Controller
public class ListenListController {

	@Resource
	private TeacherServiceImpl teacherServiceImpl;
	@Resource
	private CourseServiceImpl courseServiceImpl;
	
	@RequestMapping("/listenList")
	public String IndexConrol(HttpSession session, Model model) {
		Date d = new Date();
		System.out.println("listenList...");
		List<Teacher> teachers = teacherServiceImpl.listTeachers();
		System.out.println("teachers size: " + teachers.size());
		session.setAttribute("teachers", teachers);
		model.addAttribute("page", 1);
		return "listen-list";
	}
	
	
	@RequestMapping("/selectTeacher")
	public String selectControl(@RequestParam("gender") String gender, @RequestParam("age") String age, HttpSession session, Model model) {
		List<Teacher> teachers;
		if(gender.equals("default") && age.equals("default")) {
			teachers = teacherServiceImpl.listTeachers();
			
		} else if (gender.equals("default") && !age.equals("default")) {
			teachers = teacherServiceImpl.listTeachers(); // ch
		} else if (!gender.equals("default") && age.equals("default")){
			teachers = teacherServiceImpl.listTeachersBySex(gender);
		} else {
			teachers = teacherServiceImpl.listTeachers(); // ch
		}
		
		session.setAttribute("teachers", teachers);
		model.addAttribute("page", 1);
		return "listen-list";
	}
	
	@RequestMapping("/consulterDetail")
	public String consulterDetailController(@RequestParam("id") int id, Model model) {
		Teacher t = teacherServiceImpl.listTeacherById(id);
		String[] aString = t.getAuthenticationAptitudeName().split(" ");
		model.addAttribute("authentications", Arrays.asList(aString));
		List<Course> courses = courseServiceImpl.listCoursesByTeacherId(id);
		model.addAttribute("courses", courses);
		model.addAttribute("teacher", t);
		return "consulter";
	}
	
	@RequestMapping("/consultAppointment")
	public String consultAppointmentController1(@RequestParam("id") int id, Model model) {
		Teacher t = teacherServiceImpl.listTeacherById(id);
		List<Course> courses = courseServiceImpl.listCoursesByTeacherId(id);
		model.addAttribute("teacher", t);
		return "appointment-listening";
	}
	
	@RequestMapping("pageController")
	public String pageController(@RequestParam("page") int page, Model model) {
		model.addAttribute("page", page);
		return "listen-list";
	}
}
