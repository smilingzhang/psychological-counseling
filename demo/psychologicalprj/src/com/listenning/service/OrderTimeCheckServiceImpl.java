package com.listenning.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.ConsultationRecord;
import com.entity.ListenRecord;

@Service
public class OrderTimeCheckServiceImpl {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	public ConsultationRecord checkConsultationOrder(List<ConsultationRecord> consultationRecords)
			throws ParseException {

		// 如果 sessoin 中的咨询订单不为空
		System.out.println("consultationRecords:" + consultationRecords);
		// 筛选 session 中的所有的自己的咨询订单
		for (ConsultationRecord r : consultationRecords) {
			String startTime = r.getConsultationrecordOrderTime() + " " + r.getConsultationrecordStartTime();
			String endTime = r.getConsultationrecordOrderTime() + " " + r.getConsultationrecordEndTime();
			Date start = sdf.parse(startTime);
			Date end = sdf.parse(endTime);
			Date now = new Date();

			// 如果当前时间在订单的咨询时间范围内
			if (now.after(start) && now.before(end)) {
				// session 放入对方的 User, randomAddress
				// User my = (User) session.getAttribute("user");
				//
				// if (my.getUserId() == r.getUser().getUserId()) {
				// session.setAttribute("other", r.getTeacher().getUser());
				// } else {
				// session.setAttribute("other", r.getUser());
				// }
				return r;

			}
		}
		return null;

	}

	public ListenRecord checkListenOrder(List<ListenRecord> listenRecords) throws ParseException {
		// 如果 sessoin 中的倾听订单不为空
		System.out.println("listenRecords:" + listenRecords);
		// 筛选 session 中的所有的自己的咨询订单
		for (ListenRecord r : listenRecords) {
			String startTime = r.getListenrecordOrderTime() + " " + r.getListenrecordStartTime();
			String endTime = r.getListenrecordOrderTime() + " " + r.getListenrecordEndTime();
			Date start = sdf.parse(startTime);
			Date end = sdf.parse(endTime);
			Date now = new Date();

			// 如果当前时间在订单的咨询时间范围内
			if (now.after(start) && now.before(end)) {
				// session 放入对方的 User, randomAddress
				// User my = (User) session.getAttribute("user");
				//
				// if (my.getUserId() == r.getUser().getUserId()) {
				// session.setAttribute("other", r.getTeacher().getUser());
				// } else {
				// session.setAttribute("other", r.getUser());
				// }

				return r;

			}
		}
		return null;
	}

}
