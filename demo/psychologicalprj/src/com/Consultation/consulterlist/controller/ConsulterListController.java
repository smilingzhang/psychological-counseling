package com.Consultation.consulterlist.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Consultation.consulterlist.service.ConsulterService;
import com.entity.Page;
import com.entity.Teacher;
/**
 * 
 *@desc:预约功能咨询索引页对应的controller
 *@author chunhui
 *@date:Nov 28, 20181:18:19 PM
 */
@Controller
@RequestMapping("/consult")
public class ConsulterListController {
	@Resource
	private ConsulterService consulterService;
	/**
	 * 
	 *@desc:展示筛选出来的咨询师
	 *@param type
	 *@param date
	 *@param request
	 *@return
	 *@return:String
	 *@trhows
	 */
	@RequestMapping("/show")
	public String showConsults(@RequestParam(value="fenlei",required=false) int type,@RequestParam(value="shijian",required=false)String date,
			@RequestParam(value="pageNum",required=false) String pageNum,HttpServletRequest request) {
		int num=0;
		if (pageNum == null || pageNum.equals("")) {

			num = 1;
		} else {

			num = Integer.parseInt(pageNum);
		}
		if(type==0) {
			type=1;
		}
		if(date == null||date.equals("")) {
			date=new Date().toString();
		}
		List<Teacher> teachers =this.consulterService.findByScreen(num, 2, type, date);
		List<Teacher> listTeachers=this.consulterService.findByRate();
		request.setAttribute("listTeachers", listTeachers);
		request.setAttribute("teachers", teachers);
		request.setAttribute("date", date);
		
		Page page = new Page(num, 2);
		page.setTeacher(teachers);
		page.setPageNum(num);
		page.setPrePageNum(num - 1);
		page.setNextPageNum(num + 1);
		page.setTotalCount(teachers.size());
		page.setTotalPageCount(teachers.size());
		request.setAttribute("page", page);
		
		return "consult-list";
	}
	/**
	 * 
	 *@desc:展示热门专家 展示左端默认咨询师
	 *@param request
	 *@return
	 *@return:String
	 *@trhows
	 */
	@RequestMapping("/default")
	public String showPopularConsult(HttpServletRequest request) {
		List<Teacher> listTeachers=this.consulterService.findByRate();
		List<Teacher> defaultTeachers=this.consulterService.findDefault();
		request.setAttribute("listTeachers", listTeachers);
		request.setAttribute("defaultTeachers", defaultTeachers);
		return "consult-list";
	}

}
