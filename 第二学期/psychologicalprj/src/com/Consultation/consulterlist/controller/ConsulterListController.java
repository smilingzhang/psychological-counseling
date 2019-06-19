package com.Consultation.consulterlist.controller;

import java.io.IOException;
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
	 * @throws InterruptedException
	 * @throws IOException
	 * @trhows
	 */
	@RequestMapping("/show")
	public String showConsults(@RequestParam(value = "fenlei", required = false) int type,
			@RequestParam(value = "shijian", required = false) String date,
			@RequestParam(value = "pageNum", required = false) String pageNum, HttpServletRequest request)
			throws InterruptedException, IOException {

		// 筛选的咨询师
		Page<Teacher> page = this.consulterService.showByConditions(type, date, pageNum, 2);
		request.setAttribute("page", page);
		// 右侧热门咨询师
		List<Teacher> listTeachers = this.consulterService.showPopularConsulter();
		request.setAttribute("listTeachers", listTeachers);
		// 右端热门咨询师改成推荐的咨询师
		// 补充：先获取用户id,如果用户没有登录或者咨询记录为空则展示当前可以咨询的所有咨询师；否则向其推荐咨询师
		if (request.getSession().getAttribute("userId") != null
				|| !(request.getSession().getAttribute("userId").equals(" "))) {
			int userId = (int) request.getSession().getAttribute("userId");
			// 被推荐的咨询师
			List<Teacher> consulationRecord = this.consulterService.showAllConsulationTeeachers(userId);
			if (consulationRecord.size() == 0) {
				request.setAttribute("listTeachers", listTeachers);
			} else {
				if (consulationRecord.size() <= 8) {
					request.setAttribute("listTeachers", consulationRecord);
				} else {
					request.setAttribute("listTeachers", consulationRecord.subList(0, 8));
				}
			}
		}

		request.setAttribute("date", date);
		request.setAttribute("fenlei", type);
		return "consult-list";
	}

	/**
	 * 
	 * @desc:展示右端
	 * @param request
	 * @return
	 * @return:String
	 * @throws InterruptedException
	 * @throws IOException
	 * @trhows
	 */
	@RequestMapping("/default")
	public String showPopularConsult(@RequestParam("pageNum") Integer num, HttpServletRequest request)
			throws InterruptedException, IOException {
		Page<Teacher> page = this.consulterService.showDefault(num, 6);
		DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date();
		String format = bf.format(date1);
		request.setAttribute("page", page);

		List<Teacher> listTeachers = this.consulterService.showPopularConsulter();
		request.setAttribute("listTeachers", listTeachers);
		request.setAttribute("format", format);

		if (request.getSession().getAttribute("userId") != null
				|| !(request.getSession().getAttribute("userId").equals(" "))) {
			int userId = (int) request.getSession().getAttribute("userId");
			// 被推荐的咨询师
			List<Teacher> consulationRecord = this.consulterService.showAllConsulationTeeachers(userId);
			if (consulationRecord.size() == 0) {
				request.setAttribute("listTeachers", listTeachers);
			} else {
				if (consulationRecord.size() <= 8) {
					request.setAttribute("listTeachers", consulationRecord);
				} else {
					request.setAttribute("listTeachers", consulationRecord.subList(0, 8));
				}
			}
		}

		return "consult-list";
	}

}
