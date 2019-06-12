package com.listenning.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.ConsultationRecord;
import com.entity.ListenRecord;
import com.entity.User;
import com.indexing.service.ConsultationRecordServiceImpl;
import com.indexing.service.TeacherServiceImpl;
import com.listenning.service.ListenRecordServiceImpl;
import com.listenning.service.OrderTimeCheckServiceImpl;
import com.listenning.service.UserServiceImpl;

@Controller
public class OrderTimeCheckController {
	
	private Logger logger = Logger.getLogger(OrderTimeCheckController.class);

	@Resource
	private OrderTimeCheckServiceImpl OrderTimeCheckServiceImpl;

	@Resource
	private UserServiceImpl userServiceImpl;

	@Resource
	private ConsultationRecordServiceImpl consultationRecordServiceImpl;
	
	@Resource
	private ListenRecordServiceImpl listenRecordServiceImpl;
	
	@Resource
	private TeacherServiceImpl teacherServiceImpl;

	/**
	 * 
	 * @Desc: 5s 循环监测当前时间是否在订单的时间内，如果在则显示提示框，并clearInterval();
	 * @date 2018年12月3日:下午8:08:57
	 * @author baozhangjun
	 */
	@RequestMapping("/OrderTimeCheck")
	
	public void check(HttpServletResponse res, HttpSession session) throws IOException, ParseException {
		
		res.setContentType("text/html; charset=utf-8");
		
		PrintWriter p = res.getWriter();
		User user = (User) session.getAttribute("user");
		if(user == null) return;
		// 如果未登录终止.
		
		int identity = user.getUserIdentity();
		System.out.println("user:" + user);
		int id = user.getUserId();
		logger.info("OrderTimeCheck...");
		
		
		List<ConsultationRecord> consultationRecords = consultationRecordServiceImpl
				.listUnusedConsultationRecordsById(id, identity);
		
		List<ListenRecord> listenRecords = listenRecordServiceImpl
				.listUnusedListenRecordsById(id, identity);
		
		logger.info("found listenRecords : " + listenRecords);
		logger.info("found consultationRecords : " + consultationRecords);
		
		if (consultationRecords != null) {
			logger.info("consultationRecords != null");
			ConsultationRecord cr = OrderTimeCheckServiceImpl.checkConsultationOrder(consultationRecords);
			if (cr != null) {
				logger.info("cr != null");
				// 放入videoChatAddress
				logger.info("放入videoChatAddress..");
				String videoChatAddress = cr.getRandomNum() + cr.getConsultationrecordId();
				logger.info("videoChatAddress:" + videoChatAddress);
				session.setAttribute("videoChatAddress", videoChatAddress);

				// 放入 consultationrecordId
				int consultationrecordId = cr.getConsultationrecordId();
				session.setAttribute("consultationrecordId", consultationrecordId);
				session.setAttribute("roomType", "consult");
				logger.info("放入roomType: consult");

				
				User other = userServiceImpl.getOtherUser(user, cr);
				session.setAttribute("other", other);
				
				// if 是客户
				if(identity == 1) {
					p.print("<div id=\"invite\">\r\n" + 
							"			        <div class=\"animate\">\r\n" + 
							"			            <span class=\"animate-snake\"><i class=\"icon icon-spin icon-spinner-snake icon-5x\"></i></span>\r\n" + 
							"			            <span class=\"animate-phone\"><i class=\"icon icon-phone icon-3x\"></i></span>\r\n" + 
							"			        </div>\r\n" + 
							"			        <div class=\"msg\">\r\n" + 
							"				            <div>您预约的&nbsp;<span class=\"stress\">在线视频咨询</span>&nbsp;即将开始</div>\r\n" + 
							"			        	\r\n" + 
							"			            <div>咨询师&nbsp;<span class=\"stress\">" + other.getUserRealName() + "</span>&nbsp;向你发出了邀请</div>\r\n" + 
							"			            <div class=\"tag\">请尽快进入咨询室</div>\r\n" + 
							"			            <button class=\"btn btn-block\" type=\"button\">立即进入咨询室&nbsp;<i class=\"icon icon-hand-right\"></i></button>\r\n" + 
							"			        </div>\r\n" + 
							"			    </div>");
				} else {
					p.print("<div id=\"invite\">\r\n" + 
							"			        <div class=\"animate\">\r\n" + 
							"			            <span class=\"animate-snake\"><i class=\"icon icon-spin icon-spinner-snake icon-5x\"></i></span>\r\n" + 
							"			            <span class=\"animate-phone\"><i class=\"icon icon-phone icon-3x\"></i></span>\r\n" + 
							"			        </div>\r\n" + 
							"			        <div class=\"msg\">\r\n" + 
							"				            <div>您被预约的&nbsp;<span class=\"stress\">在线视频咨询</span>&nbsp;即将开始</div>\r\n" + 
							"			        	\r\n" + 
							"			            <div>客户&nbsp;<span class=\"stress\">" + other.getUserRealName() + "</span>&nbsp;向你发出了邀请</div>\r\n" + 
							"			            <div class=\"tag\">请尽快进入咨询室</div>\r\n" + 
							"			            <button class=\"btn btn-block\" type=\"button\">立即进入咨询室&nbsp;<i class=\"icon icon-hand-right\"></i></button>\r\n" + 
							"			        </div>\r\n" + 
							"			    </div>");
				}
			}
		}

		if (listenRecords != null) {
			logger.info("listenRecords != null");
			ListenRecord lr = OrderTimeCheckServiceImpl.checkListenOrder(listenRecords);
			if (lr != null) {
				logger.info("lr != null");
				// 放入audioChatAddress
				String audioChatAddress = lr.getRandomNum() + lr.getListenrecordId();
				logger.info("放入audioChatAddress.." + audioChatAddress);
				session.setAttribute("audioChatAddress", audioChatAddress);

				// 放入 listenRecordId  
				int listenRecordId = lr.getListenrecordId();
				session.setAttribute("listenRecordId", listenRecordId);
				session.setAttribute("roomType", "listen");

				User other = userServiceImpl.getOtherUser(user, lr);
				session.setAttribute("other", other);
				logger.info("other:" + other);
				if(identity == 1) {
					p.print("<div id=\"invite\">\r\n" + 
							"			        <div class=\"animate\">\r\n" + 
							"			            <span class=\"animate-snake\"><i class=\"icon icon-spin icon-spinner-snake icon-5x\"></i></span>\r\n" + 
							"			            <span class=\"animate-phone\"><i class=\"icon icon-phone icon-3x\"></i></span>\r\n" + 
							"			        </div>\r\n" + 
							"			        <div class=\"msg\">\r\n" + 
							"				            <div>您预约的&nbsp;<span class=\"stress\">在语音频咨询</span>&nbsp;即将开始</div>\r\n" + 
							"			        	\r\n" + 
							"			            <div>倾听师&nbsp;<span class=\"stress\">" + other.getUserRealName() + "</span>&nbsp;向你发出了邀请</div>\r\n" + 
							"			            <div class=\"tag\">请尽快进入咨询室</div>\r\n" + 
							"			            <button class=\"btn btn-block\" type=\"button\">立即进入咨询室&nbsp;<i class=\"icon icon-hand-right\"></i></button>\r\n" + 
							"			        </div>\r\n" + 
							"			    </div>");
				} else {
					p.print("<div id=\"invite\">\r\n" + 
							"			        <div class=\"animate\">\r\n" + 
							"			            <span class=\"animate-snake\"><i class=\"icon icon-spin icon-spinner-snake icon-5x\"></i></span>\r\n" + 
							"			            <span class=\"animate-phone\"><i class=\"icon icon-phone icon-3x\"></i></span>\r\n" + 
							"			        </div>\r\n" + 
							"			        <div class=\"msg\">\r\n" + 
							"				            <div>您被预约的&nbsp;<span class=\"stress\">在语音频咨询</span>&nbsp;即将开始</div>\r\n" + 
							"			        	\r\n" + 
							"			            <div>客户&nbsp;<span class=\"stress\">" + other.getUserRealName() + "</span>&nbsp;向你发出了邀请</div>\r\n" + 
							"			            <div class=\"tag\">请尽快进入咨询室</div>\r\n" + 
							"			            <button class=\"btn btn-block\" type=\"button\">立即进入咨询室&nbsp;<i class=\"icon icon-hand-right\"></i></button>\r\n" + 
							"			        </div>\r\n" + 
							"			    </div>");
				}
			}
		}

		
	}
}
