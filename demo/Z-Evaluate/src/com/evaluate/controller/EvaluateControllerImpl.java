package com.evaluate.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.evaluate.entity.Evaluate;
import com.evaluate.service.EvaluateServiceImpl;



@Controller
public class EvaluateControllerImpl {
	@Resource
	private EvaluateServiceImpl evaluateServiceImpl;
	
	@RequestMapping("/EvaluateControllerImpl")
	public String comment(HttpServletRequest request) {
		List<Evaluate> list = this.evaluateServiceImpl.list();
		request.getServletContext().setAttribute("evaluate1", list);
		
		String content = request.getParameter("text.value");
		System.out.println(content);
		
		Evaluate evaluate = new Evaluate();
		evaluate.setEvaluateWorkType(3);
		evaluate.setEvaluateWorkId(4);
		evaluate.setEvaluateComment(content);
		evaluate.setEvaluateTime(new Date());
		evaluate.setEvaluateStar(5);
		this.evaluateServiceImpl.insert(evaluate);
		
		return "evaluate";
//		String comment = request.getParameter("")
	}
}
