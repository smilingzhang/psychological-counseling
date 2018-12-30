package com.Consultation.consulter.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Consultation.consulterlist.service.ConsulterService;
import com.entity.Course;
import com.entity.Teacher;

/**
 * 
 * @desc:预约功能的咨询师详细信息展示controller
 * @author chunhui
 * @date:Nov 28, 20187:44:01 PM
 */
@Controller
@RequestMapping("/consultdetail")
public class ConsultDetailController {
	@Resource
	private ConsulterService consulterService;

	@RequestMapping("/showdetail")
	public String showDetailConsult(@RequestParam("teacherId") String teacherId, HttpServletRequest request) {

		Teacher teacher = this.consulterService.showConsultDetail(Integer.parseInt(teacherId));
		request.setAttribute("teacher", teacher);
		String[] aStrings = teacher.getAuthenticationAptitudeName().split(" ");
		request.setAttribute("aStrings", aStrings);
		List<Course> courses = this.consulterService.showTeacherCourse(Integer.parseInt(teacherId));
		request.setAttribute("courses", courses);
		return "consulter";
	}

}
