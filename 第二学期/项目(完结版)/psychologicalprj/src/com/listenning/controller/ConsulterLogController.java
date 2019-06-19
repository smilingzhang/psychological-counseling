package com.listenning.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ConsulterLogController {

	private static Logger log = LoggerFactory.getLogger(ConsulterLogController.class);
	
	@RequestMapping("/consulterLog")
	public String deal(HttpServletRequest req) {
		System.out.println("ConsulterLogController...");
		String a = req.getParameter("A");
		String b = req.getParameter("B");
		String c = req.getParameter("C");
		String d = req.getParameter("D");
		String e = req.getParameter("E");
		String consulterId = req.getParameter("consulterId");
		log.info(consulterId + " " + 1 + " " + a);
		log.info(consulterId + " " + 2 + " " + b);
		log.info(consulterId + " " + 3 + " " + c);
		log.info(consulterId + " " + 4 + " " + d);
		log.info(consulterId + " " + 5 + " " + e);
		return "redirect:main.jsp";
	}
}
