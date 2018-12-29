package com.Consultation.consulterlist.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Consultation.consulterlist.service.ConsulterService;
import com.entity.Teacher;
import com.util.Page;

/**
 * 
 * @desc:预约功能咨询索引页对应的controller
 * @author chunhui
 * @date:Nov 28, 20181:18:19 PM
 */
@Controller
@RequestMapping("/consult")
public class ConsulterListController {
	@Resource
	private ConsulterService consulterService;

	/**
	 * 
	 * @desc:展示筛选出来的咨询师
	 * @param type
	 * @param date
	 * @param request
	 * @return
	 * @return:String
	 * @trhows
	 */
	@RequestMapping("/show")
	public String showConsults(@RequestParam(value = "fenlei", required = false) int type,
			@RequestParam(value = "shijian", required = false) String date,
			@RequestParam(value = "pageNum", required = false) String pageNum, HttpServletRequest request) {
		
		System.out.println("获取的日期时间为=============================================="+date);
		// 右侧热门专家
		Page<Teacher> page = this.consulterService.showByConditions(type, date, pageNum, 2);
		request.setAttribute("page", page);
		List<Teacher> listTeachers = this.consulterService.showPopularConsulter();
		request.setAttribute("listTeachers", listTeachers);
		request.setAttribute("date", date);
		request.setAttribute("fenlei", type);
		return "consult-list";
	}

	/**
	 * 
	 * @desc:展示热门专家 展示左端默认咨询师
	 * @param request
	 * @return
	 * @return:String
	 * @trhows
	 */
	@RequestMapping("/default")
	public String showPopularConsult(@RequestParam("pageNum") Integer num, HttpServletRequest request) {
		@SuppressWarnings("unchecked")
		Page<Teacher> page = this.consulterService.showDefault(num, 6);
		DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date();
		String format = bf.format(date1);
		request.setAttribute("page", page);
		List<Teacher> listTeachers = this.consulterService.showPopularConsulter();
		request.setAttribute("listTeachers", listTeachers);
		request.setAttribute("format", format);
		return "consult-list";
	}

}
