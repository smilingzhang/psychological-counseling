package com.Consultation.consulterlist.controller;

import java.util.ArrayList;
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
		if(pageNum==null||pageNum.equals("")) {
			num=1;
		}
		else {
			num=Integer.parseInt(pageNum);
		}
		if(date == null||date.equals("")) {
			date=new Date().toString();
		}
		if(type==0) {
			type=1;
		}
		List<Teacher> teachers =this.consulterService.findByScreen(num, 2, type, date);
		//右侧热门专家
		List<Teacher> listTeachers=this.consulterService.findByRate();
		request.setAttribute("listTeachers", listTeachers);
		//request.getSession().setAttribute("teachers", teachers);
	
		request.setAttribute("date", date);
		request.setAttribute("fenlei", type);
		request.setAttribute("totalpagecount", teachers.size());
	
		//分页显示
		List<Teacher> reTeachers=new ArrayList<>();
		for(int n=((num - 1) * 2);n<num*2&&n<teachers.size();n++) {
			reTeachers.add(teachers.get(n));
		}		
		Page page = new Page(num, 2);
		page.setTeacher(reTeachers);
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
	public String showPopularConsult(@RequestParam("pageNum")Integer num,HttpServletRequest request) {
		if(num==0) {
			num=1;
		}
		//右侧热门专家
		List<Teacher> listTeachers=this.consulterService.findByRate();
		//左侧默认展示的咨询师
		List<Teacher> defaultTeachers=this.consulterService.findDefault();
		request.setAttribute("listTeachers", listTeachers);
		//request.setAttribute("defaultTeachers", defaultTeachers);
		
		List<Teacher> showTeachers=new ArrayList<>();
		for(int i=(num-1)*6;i<6*num&&i<defaultTeachers.size();i++) {
			showTeachers.add(defaultTeachers.get(i));
		}
		//request.setAttribute("showTeachers", showTeachers);
		
		Page page = new Page(num, 6);
		page.setTeacher(showTeachers);
		page.setPageNum(num);
		page.setPrePageNum(num - 1);
		page.setNextPageNum(num + 1);
		page.setTotalCount(defaultTeachers.size());
		page.setTotalPageCount(defaultTeachers.size());
		request.setAttribute("page", page);
		
		
		return "consult-list";
	}

}
