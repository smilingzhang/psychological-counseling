package com.listenning.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.ConsultationRecord;
import com.entity.ListenRecord;
import com.entity.Teacher;
import com.entity.User;
import com.indexing.service.ConsultationRecordServiceImpl;
import com.indexing.service.TeacherServiceImpl;
import com.listenning.service.ListenRecordServiceImpl;
import com.util.SubTime;

@Controller
public class RecordStateController {
	private Logger logger = Logger.getLogger(RecordStateController.class);

	@Resource
	private ConsultationRecordServiceImpl consultationRecordServiceImpl;

	@Resource
	private TeacherServiceImpl teacherServiceImpl;

	@Resource
	private ListenRecordServiceImpl listenRecordServiceImpl;

	/**
	 * @Desc: videoRoom 点击挂断, 改变咨询订单的咨询状态为已咨询,同时将session中的未咨询订单更新. @date
	 * 2018年12月10日:下午2:20:13 @author baozhangjun @throws
	 */
	@RequestMapping("/consultStateControl")
	public String consultStateControl(HttpSession session) {
		int consultationrecordId = (int) session.getAttribute("consultationrecordId");

		consultationRecordServiceImpl.changeConsultStateToDoneById(consultationrecordId);

		User user = (User) session.getAttribute("user");
		// 数据库中数据已经改变应更新 application、session 中的属性。

		int identity = user.getUserIdentity();
		// session 中放入该用户的所有未咨询的订单，以便后来通过日期筛选。
		List<ConsultationRecord> consultationRecords = consultationRecordServiceImpl
				.listUnusedConsultationRecordsById(user.getUserId(), identity);

		logger.info("found consultationRecords : " + consultationRecords);

		session.setAttribute("consultationRecords", consultationRecords);

		return "redirect:main.jsp";

	}

	/**
	 * @Desc: audioRoom 点击挂断,
	 * 改变倾听订单的咨询状态为已咨询,同时将session中的未倾听订单更新.同时将倾听师的canListen字段更新为0. 将ListenRecord 的
	 * startTime 改为当两个窗口均出现的时间，点击挂断按钮时，控制endTime 字段，不在 @date
	 * 2018年12月10日:下午2:20:13 @author baozhangjun @throws
	 */
	@RequestMapping("/listenStateControl")
	public String listenStateControl(HttpSession session) {
		int listenRecordId = (int) session.getAttribute("listenRecordId");

		listenRecordServiceImpl.changeListenStateToDoneById(listenRecordId);

		User user = (User) session.getAttribute("user");
		// 数据库中数据已经改变应更新 application、session 中的属性。

		int identity = user.getUserIdentity();
		// session 中放入该用户的所有未咨询的订单，以便后来通过日期筛选。
		List<ListenRecord> listenRecords;

		// 用户如果是普通用户则通过userId查询，如果是teacher则通过teacherId查询;
		listenRecords = listenRecordServiceImpl.listUnusedListenRecordsById(user.getUserId(), identity);
		// 如果是倾听师或咨询师,将canListen改为1
		if (identity != 1) {
			Teacher t = teacherServiceImpl.findTeacherById(user.getUserId());
			teacherServiceImpl.changeTeacherCanListen(t, 1);
		}

		logger.info("found listenRecords : " + listenRecords);

		session.setAttribute("listenRecords", listenRecords);
		return "redirect:main.jsp";

	}

	@RequestMapping("/listenStartTimeControl")
	public void listenStartTimeControl(HttpSession session) {
		logger.info("开始时间控制...");
		Date d = new Date();
		String min;
		if (d.getMinutes() < 10) {
			min = "0" + d.getMinutes();
		} else
			min = "" + d.getMinutes();

		String startTime = d.getHours() + ":" + min;
		String roomType = (String) session.getAttribute("roomType");
		int id;
		if ("consult".equals(roomType)) {
			id = (int) session.getAttribute("consultationrecordId");
		} else {
			id = (int) session.getAttribute("listenRecordId");
		}
		listenRecordServiceImpl.changeListenRecordStartTimeById(id, startTime);
	}

	/**
	 * 
	 * @desc:一句话描述
	 * @param session
	 * @return:void
	 * @throws ParseException
	 * @trhows
	 */
	@RequestMapping("/listenEndTimeControl")
	public void listenEndTimeControl(HttpSession session) throws ParseException {
		logger.info("结束时间控制...");
		Date d = new Date();
		String min;
		if (d.getMinutes() < 10) {
			min = "0" + d.getMinutes();
		} else
			min = "" + d.getMinutes();

		String endTime = d.getHours() + ":" + min;
		String roomType = (String) session.getAttribute("roomType");
		int id;
		if ("consult".equals(roomType)) {
			id = (int) session.getAttribute("consultationrecordId");
		} else {
			id = (int) session.getAttribute("listenRecordId");
		}

		logger.info("change lis the id:" + id);
		listenRecordServiceImpl.changeListenRecordEndTimeById(id, endTime);
		ListenRecord lr = listenRecordServiceImpl.searchListenRecordById(id);
		String st = lr.getListenrecordStartTime();
		String et = lr.getListenrecordEndTime();
		int dif = SubTime.subTimeMinutesDivTenUpstairs(st, et);
		int price = dif * 20;
		listenRecordServiceImpl.changeListenRecordPriceById(id, price);
		logger.info("success change price : " + price);
	}

}
