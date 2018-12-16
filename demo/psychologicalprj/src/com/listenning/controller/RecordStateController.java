package com.listenning.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.ConsultationRecord;
import com.entity.ListenRecord;
import com.entity.Teacher;
import com.entity.User;
import com.listenning.service.ConsultationRecordServiceImpl;
import com.listenning.service.ListenRecordServiceImpl;
import com.listenning.service.TeacherServiceImpl;

@Controller
public class RecordStateController {

	@Resource
	private ConsultationRecordServiceImpl consultationRecordServiceImpl;
	
	@Resource
	private TeacherServiceImpl teacherServiceImpl;
	
	@Resource
	private ListenRecordServiceImpl listenRecordServiceImpl;
	/**
	* @Desc: videoRoom 点击挂断, 改变咨询订单的咨询状态为已咨询,同时将session中的未咨询订单更新.
	* @date 2018年12月10日:下午2:20:13
	* @author baozhangjun
	* @throws
	 */
	@RequestMapping("/consultStateControl")
	public String consultStateControl(HttpSession session) {
		int consultationrecordId = (int) session.getAttribute("consultationrecordId");
		
		consultationRecordServiceImpl.changeConsultStateToDoneById(consultationrecordId);
		
		User user = (User) session.getAttribute("user");
		ServletContext application = session.getServletContext();
		// 数据库中数据已经改变应更新 application、session 中的属性。
		
		int identity = user.getUserIdentity();
		// session 中放入该用户的所有未咨询的订单，以便后来通过日期筛选。
		List<ConsultationRecord> consultationRecords;
		
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
		
		return "redirect:head.jsp";
		
	}
	
	
	/**
	* @Desc: audioRoom 点击挂断, 改变倾听订单的咨询状态为已咨询,同时将session中的未倾听订单更新.同时将倾听师的canListen字段更新为0.
	* @date 2018年12月10日:下午2:20:13
	* @author baozhangjun
	* @throws
	 */
	@RequestMapping("/listenStateControl")
	public String listenStateControl(HttpSession session) {
		int listenRecordId = (int) session.getAttribute("listenRecordId");
		
		listenRecordServiceImpl.changeListenStateToDoneById(listenRecordId);
		
		User user = (User) session.getAttribute("user");
		ServletContext application = session.getServletContext();
		// 数据库中数据已经改变应更新 application、session 中的属性。
		
		int identity = user.getUserIdentity();
		// session 中放入该用户的所有未咨询的订单，以便后来通过日期筛选。
		List<ListenRecord> listenRecords;
		
		// 用户如果是普通用户则通过userId查询，如果是teacher则通过teacherId查询;
		if(identity == 1) {
			System.out.println("I am a common user...");
			listenRecords = listenRecordServiceImpl
					.listUnusedListenRecordsByUserId(user.getUserId());
		} else {
			System.out.println("I am a common teacher...");
			listenRecords = listenRecordServiceImpl
					.listUnusedListenRecordsByTeacherId(user.getUserId());
			
			// 如果是倾听师,将canListen改为1
			if(identity == 3) {
				Teacher t = teacherServiceImpl.findTeacherById(user.getUserId());
				teacherServiceImpl.changeTeacherCanListen(t, 1);
			}
			
		}
		
		// 将所有的未咨询订单放入application
		if (application.getAttribute("allUnusedlistenRecords") == null) {
			List<ListenRecord> allUnusedlistenRecords = listenRecordServiceImpl
					.listAllUnusedListenRecords();
			application.setAttribute("allUnusedlistenRecords", allUnusedlistenRecords);
		}

		System.out.println("found listenRecords : " + listenRecords);
		
		session.setAttribute("listenRecords", listenRecords);
		
		
		return "redirect:head.jsp";
		
	}
}
