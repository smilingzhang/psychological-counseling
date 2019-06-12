package com.teacher.homepage.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.teacher.homepage.service.ShowChartServiceImpl;

@Controller
public class ShowChartControllerImpl {

	@Resource
	private ShowChartServiceImpl showchartservice;
	
	//------------------------孙明伟----------------------
	@RequestMapping(value="/showchart",method=RequestMethod.POST)
	public void showchart(HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model) throws ServletException, IOException, ParseException {
		String beforeTime = request.getParameter("time");     
		int userId=(int) session.getAttribute("userId"); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
	 	System.out.println("今天的日期："+d);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
	 	if(beforeTime.equals("e")) {                        //一年前
			c.add(Calendar.YEAR, -1);
	 	}else if(beforeTime.equals("b")) {					//一个月前
	 		c.add(Calendar.MONTH, -1);
	 	}else if(beforeTime.equals("c")) {					//三个月前
	 		c.add(Calendar.MONTH, -3);
	 	}else if(beforeTime.equals("d")) {					//半年前
	 		c.add(Calendar.MONTH, -6);
	 	}else {					                            //一周前
	 		c.add(Calendar.DATE,-7);
	 	}
	 	Date d1 = c.getTime();
		String strd1 = sdf.format(d1);
		System.out.println(strd1);
		
		long totaltime = showchartservice.getTime(d1, userId);
		List<Map<Object,Object>> list = showchartservice.gettypeNum(d1, userId);
		System.out.println(list.size());
		System.out.println(list);
//		Map<String,Object> maps = new HashMap<String,Object>();
//		maps.put("totaltime", totaltime);
//		maps.put("map", map);
		
		int num = this.showchartservice.getUserNum(d1, userId);
		System.out.println("共咨询的用户数量为："+num);
		
		request.setAttribute("time", beforeTime);
		request.setAttribute("num", num);
		request.setAttribute("totaltime", totaltime);
		request.setAttribute("countlist", list);
		session.setAttribute("userId", userId);
		
		request.getRequestDispatcher("/consultTeacher/articleTypeTable").forward(request, response);
	}
	
	
	@RequestMapping(value="/preshowchart",method=RequestMethod.GET)
	public void preshowchart(HttpSession session,HttpServletRequest request,HttpServletResponse response,Model model) throws ServletException, IOException, ParseException {
		String beforeTime = request.getParameter("time");     
		int userId=(int) session.getAttribute("userId"); 
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date d = new Date();
	 	System.out.println("今天的日期："+d);
		Calendar c = Calendar.getInstance();
		c.setTime(d);
	 	if(beforeTime.equals("e")) {                        //一年前
			c.add(Calendar.YEAR, -1);
	 	}else if(beforeTime.equals("b")) {					//一个月前
	 		c.add(Calendar.MONTH, -1);
	 	}else if(beforeTime.equals("c")) {					//三个月前
	 		c.add(Calendar.MONTH, -3);
	 	}else if(beforeTime.equals("d")) {					//半年前
	 		c.add(Calendar.MONTH, -6);
	 	}else {					                            //一周前
	 		c.add(Calendar.DATE,-7);
	 	}
	 	Date d1 = c.getTime();
		String strd1 = sdf.format(d1);
		System.out.println(strd1);
		
		long totaltime = showchartservice.getTime(d1, userId);
		List<Map<Object,Object>> list = showchartservice.gettypeNum(d1, userId);
		System.out.println(list.size());
//		Map<String,Object> maps = new HashMap<String,Object>();
//		maps.put("totaltime", totaltime);
//		maps.put("map", map);
		
		int num = this.showchartservice.getUserNum(d1, userId);
		System.out.println("共咨询的用户数量为："+num);
		
		request.setAttribute("time", beforeTime);
		request.setAttribute("num", num);
		request.setAttribute("totaltime", totaltime);
		request.setAttribute("countlist", list);
		session.setAttribute("userId", userId);
		
		request.getRequestDispatcher("/consultTeacher/articleTypeTable").forward(request, response);
	}
}
