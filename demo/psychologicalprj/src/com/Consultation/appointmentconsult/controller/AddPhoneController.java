package com.Consultation.appointmentconsult.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Consultation.appointmentconsult.service.ConsultOrderService;

@Controller
public class AddPhoneController {
	@Resource
	private ConsultOrderService consultOrderService;
	@RequestMapping("addphone")
	public String addPhone(@RequestParam("reOrderId")String reOrderId,@RequestParam("teacherPrice")String teacherPrice,
			@RequestParam("phoneNum")String phoneNum,HttpServletRequest request,@RequestParam("teacherId") String teacherId,
			@RequestParam("date")String date,@RequestParam("content")String content,@RequestParam("consultOrderId") String consultOrderId) {
		//应该从session中获取
		int userId=1;
		this.consultOrderService.modifyUserPhoneById(userId, phoneNum);
		request.setAttribute("reOrderId", reOrderId);
		request.setAttribute("teacherPrice", teacherPrice);
		request.setAttribute("teacherId", teacherId);
		request.setAttribute("date", date);
		request.setAttribute("content", content);
		request.setAttribute("consultOrderId", consultOrderId);
		return "checkout";
	}
}
