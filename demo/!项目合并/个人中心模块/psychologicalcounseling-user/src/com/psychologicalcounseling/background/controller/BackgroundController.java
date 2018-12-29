/**
 * 
 */
package com.psychologicalcounseling.background.controller;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.psychologicalcounseling.background.service.BackgroundService;
import com.sun.javafx.collections.MappingChange.Map;

/**
 *@desc:后台，判断订单时间
 *@author 邓旸
 *@date:2018年12月27日下午4:11:40
 */
@Controller
public class BackgroundController {
	@Resource
	private BackgroundService backgroundService;
	
	@RequestMapping(value="/timeConsultationChecking",method=RequestMethod.POST)
	@ResponseBody
	public String timeChecking(@RequestParam("time")String time) {
		if(backgroundService.checkTime(time)) {
			return "{\"result\":\"success\"}";
		}else return "{\"result\":\"false\"}";
	}
}
