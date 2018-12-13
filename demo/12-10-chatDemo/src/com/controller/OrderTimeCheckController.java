package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.ConsultationRecord;
import com.entity.ListenRecord;
import com.entity.Teacher;
import com.entity.User;
import com.service.ConsultationRecordServiceImpl;
import com.service.ListenRecordServiceImpl;
import com.service.OrderTimeCheckServiceImpl;
import com.service.TeacherServiceImpl;
import com.service.UserServiceImpl;

@Controller
public class OrderTimeCheckController {

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
		
		ServletContext application = session.getServletContext();
		PrintWriter pw = res.getWriter();
		System.out.println("OrderTimeCheck...");
		List<ConsultationRecord> consultationRecords = (List<ConsultationRecord>) session
				.getAttribute("consultationRecords");

		List<ListenRecord> listenRecords = (List<ListenRecord>) session.getAttribute("listenRecords");
		User my = (User) session.getAttribute("user");
		if(my == null) return ;
		if (consultationRecords != null) {
			System.out.println("consultationRecords != null");
			ConsultationRecord cr = OrderTimeCheckServiceImpl.checkConsultationOrder(consultationRecords);
			if (cr != null) {
				System.out.println("cr != null");
				// 放入videoChatAddress
				System.out.println("放入videoChatAddress..");
				String videoChatAddress = cr.getRandomNum() + cr.getConsultationrecordId();
				System.out.println("videoChatAddress:" + videoChatAddress);
				session.setAttribute("videoChatAddress", videoChatAddress);

				// 放入 consultationrecordId
				int consultationrecordId = cr.getConsultationrecordId();
				session.setAttribute("consultationrecordId", consultationrecordId);
				session.setAttribute("type", "consult");

				
				User other = userServiceImpl.getOtherUser(my, cr);
				session.setAttribute("other", other);
			}
		}

		if (listenRecords != null) {
			System.out.println("listenRecords != null");
			ListenRecord lr = OrderTimeCheckServiceImpl.checkListenOrder(listenRecords);
			if (lr != null) {
				System.out.println("lr != null");
				// 放入audioChatAddress
				String audioChatAddress = lr.getRandomNum() + lr.getListenrecordId();
				System.out.println("放入audioChatAddress.." + audioChatAddress);
				session.setAttribute("audioChatAddress", audioChatAddress);

				// 放入 listenRecordId
				int listenRecordId = lr.getListenrecordId();
				session.setAttribute("listenRecordId", listenRecordId);
				session.setAttribute("type", "listen");

				User other = userServiceImpl.getOtherUser(my, lr);
				session.setAttribute("other", other);
				System.out.println("other:" + other);
			}
		}
		
		
		// 原来登录时做的操作
		
		User user = (User) session.getAttribute("user");
		
		int identity = user.getUserIdentity();
		// session 中放入该用户的所有未咨询的订单，以便后来通过日期筛选。
//		List<ConsultationRecord> consultationRecords;
		
		// 用户如果是普通用户则通过userId查询，如果是teacher则通过teacherId查询;
		if(identity == 1) {
			System.out.println("I am a common user...");
			consultationRecords = consultationRecordServiceImpl  
					.listUnusedConsultationRecordsByUserId(user.getUserId());
		} else {
			System.out.println("I am a common teacher...");
			consultationRecords = consultationRecordServiceImpl 
					.listUnusedConsultationRecordsByTeacherId(user.getUserId());
		}
		
		// 将所有的未咨询订单放入application
		if (application.getAttribute("allUnusedConsultationRecords") == null) {
			List<ConsultationRecord> allUnusedConsultationRecords = consultationRecordServiceImpl
					.listAllUnusedConsultationRecords();
			application.setAttribute("allUnusedConsultationRecords", allUnusedConsultationRecords);
		}

		System.out.println("found consultationRecords : " + consultationRecords);
		
		session.setAttribute("consultationRecords", consultationRecords);
		
		
		// session 中放入该用户的所有未倾听的订单，以便后来通过日期筛选。
		//		List<ListenRecord> listenRecords;
			
		// 用户如果是普通用户则通过userId查询，如果是teacher则通过teacherId查询;
		if(identity == 1) {
			System.out.println("I am a common user...");
			listenRecords = listenRecordServiceImpl  
					.listUnusedListenRecordsByUserId(user.getUserId());
		} else {
			System.out.println("I am a common teacher...");
			listenRecords = listenRecordServiceImpl 
					.listUnusedListenRecordsByTeacherId(user.getUserId());
			if(identity == 3) {
				// 如果是倾听师，将其teacher表中的 canListen 改为 1
				Teacher t = teacherServiceImpl.findTeacherById(user.getUserId());
				teacherServiceImpl.changeTeacherCanListen(t, 1);
				System.out.println("I'm a listener, change database...");
			}
		}
		
		// 将所有的未咨询订单放入application
		if (application.getAttribute("allUnusedListenRecords") == null) {
			List<ListenRecord> allUnusedListenRecords = listenRecordServiceImpl
					.listAllUnusedListenRecords();
			application.setAttribute("allUnusedListenRecords", allUnusedListenRecords);
		}

		System.out.println("found listenRecords : " + listenRecords);
		
		session.setAttribute("listenRecords", listenRecords);
		
		pw.print(session.getAttribute("audioChatAddress"));
	}
}
