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
	public String showConsultTime(@RequestParam(value="teacherName",required=false) String teacherName,
			@RequestParam(value="price",required=false) String teacherPrice, @RequestParam(value="date",required=false) String date,
			@RequestParam(value="autograph",required=false) String autograph, @RequestParam(value="id",required=false) String teacherId,
			@RequestParam(value="content",required=false) String content, HttpServletRequest request) {
		DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date();
		String format = bf.format(date1);
		if (date == null || date.equals("")) {
			if(request.getSession().getAttribute("date")!=null) {
				request.getSession().setAttribute("date", request.getSession().getAttribute("date"));
			}
			date = format;
		}
		else {		
			request.getSession().setAttribute("date", date);
		}
		String url=request.getRequestURI();
		String[] aStrings=url.split("/");
		String newUrl="/"+aStrings[2]+"/"+aStrings[3];
		if(teacherName==null||teacherName.equals("")) {
			request.getSession().setAttribute("teacherName", request.getSession().getAttribute("teacherName"));
		}
		else {		
			request.getSession().setAttribute("teacherName", teacherName);
		}
		if(teacherPrice==null||teacherPrice.equals("")) {
			request.getSession().setAttribute("teacherPrice", request.getSession().getAttribute("teacherPrice"));
		}
		else {		
			request.getSession().setAttribute("teacherPrice", teacherPrice);
		}
		if(autograph==null||autograph.equals("")) {
			request.getSession().setAttribute("autograph", request.getSession().getAttribute("autograph"));
		}
		else {		
			request.getSession().setAttribute("autograph", autograph);
		}
		if(teacherId==null||teacherId.equals("")) {
			request.getSession().setAttribute("teacherId", request.getSession().getAttribute("teacherId"));
		}
		else {		
			request.getSession().setAttribute("teacherId", teacherId);
		}
		if(content==null||content.equals("")) {
			request.getSession().setAttribute("content", request.getSession().getAttribute("content"));
		}
		else {		
			request.getSession().setAttribute("content", content);
		}
		
		request.getSession().setAttribute("backToUrl",newUrl);
		return "appointment-consult";
	}

}
