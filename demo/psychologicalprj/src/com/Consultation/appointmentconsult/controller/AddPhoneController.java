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
			@RequestParam("phoneNum")String phoneNum,HttpServletRequest request) {
		//应该从session中获取
		int userId=1;
		this.consultOrderService.modifyUserPhoneById(userId, phoneNum);
		request.setAttribute("reOrderId", reOrderId);
		request.setAttribute("teacherPrice", teacherPrice);
		return "checkout";
	}
}
