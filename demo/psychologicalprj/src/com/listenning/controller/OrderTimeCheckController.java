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

		PrintWriter pw = res.getWriter();
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return;
		}
		int identity = user.getUserIdentity();
		int id = user.getUserId();
		// 如果未登录终止.
		logger.info("OrderTimeCheck...");

		List<ConsultationRecord> consultationRecords = consultationRecordServiceImpl
				.listUnusedConsultationRecordsById(id, identity);

		List<ListenRecord> listenRecords = listenRecordServiceImpl.listUnusedListenRecordsById(id, identity);

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
				pw.print(cr);
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
				pw.print(lr);
			}
		}

	}
}
