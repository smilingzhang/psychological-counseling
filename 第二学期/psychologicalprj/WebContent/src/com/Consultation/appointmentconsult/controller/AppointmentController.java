package com.Consultation.appointmentconsult.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Consultation.consulterlist.service.ConsulterService;

/**
 * 
 * @desc:获取显示在确认预约信息页面的数据
 * @author chunhui
 * @date:Nov 29, 20189:25:42 AM
 */
@Controller
@RequestMapping("/appointment")
public class AppointmentController {
	@Resource
	private ConsulterService consulterService;

	@RequestMapping("/showtime")
	public String showConsultTime(@RequestParam("teacherName") String teacherName,
			@RequestParam("price") String teacherPrice, @RequestParam("date") String date,
			@RequestParam("autograph") String autograph, @RequestParam("id") String teacherId,
			@RequestParam("content") String content, HttpServletRequest request) {
		DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date();
		String format = bf.format(date1);
		if (date == null || date.equals("")) {
			date = format;
		}
		request.setAttribute("teacherName", teacherName);
		request.setAttribute("teacherPrice", teacherPrice);
		request.setAttribute("date", date);
		request.setAttribute("autograph", autograph);
		request.setAttribute("teacherId", teacherId);
		request.setAttribute("content", content);
		return "appointment-consult";
	}

}
