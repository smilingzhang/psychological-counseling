package com.psychologicalcounseling.getpassage.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psychologicalcounseling.entity.TypeTable;
import com.psychologicalcounseling.getpassage.service.DemoServiceImpl;

@Controller
public class DemoControllerImpl {

	@Resource
	private DemoServiceImpl demoServiceImpl;
	
	@RequestMapping("demo")
	public String show(HttpServletRequest request) {
		List<TypeTable> list = this.demoServiceImpl.findtypeTable(5);
		request.setAttribute("list", list);
		return "demo";
	}
}
