package com.psychologicalcounseling.course.buy_course.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psychologicalcounseling.entity.Course;
import com.psychologicalcounseling.util.PaymentRequestUtil;
@Controller
public class BuyCourseController extends PaymentRequestUtil {
	@RequestMapping("/course_payment")
	public String toPayment(HttpServletRequest request) {
		HttpSession session = request.getSession();
		String orderId = (String) session.getAttribute("course_randomOrderId");
		 String price = ((Course)session.getAttribute("course")).getCoursePrice()+"";
		String bank = request.getParameter("bank");
		sendData(orderId, price, request, bank);
		return "sendpay";
	}
}
