package com.psychologicalcounseling.course.buy_course.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psychologicalcounseling.util.GenerateRandomUtil;
@Controller
public class RandomOrder extends GenerateRandomUtil {
	@RequestMapping("/random_order")
	public String RandomOrder(HttpServletRequest request) {
		String result = generateRandom();
		request.getSession().setAttribute("course_randomOrderId", result);
		return "buy-course";
	}
}
