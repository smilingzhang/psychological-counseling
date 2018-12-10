package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dao.ConsultationRecordDaoImpl;
import com.entity.ConsultationRecord;
import com.entity.User;

@Controller
public class OrderTimeCheckController {

	@Resource
	private ConsultationRecordDaoImpl consultationRecordDaoImpl;
	/**
	 * 
	 * @Desc: 5s 循环监测当前时间是否在订单的时间内，如果在则提示框，并clearInterval();
	 * @date 2018年12月3日:下午8:08:57
	 * @author baozhangjun
	 */
	@RequestMapping("/OrderTimeCheck")
	public void check(HttpServletResponse res, HttpSession session) throws IOException, ParseException {
		
		
		
		// 日期格式化
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		PrintWriter pw = res.getWriter();
		List<ConsultationRecord> consultationRecords = (List<ConsultationRecord>) session
				.getAttribute("consultationRecords");
		
		if (consultationRecords == null)
			return ;

		System.out.println("consultationRecords:" + consultationRecords);
		for (ConsultationRecord r : consultationRecords) {
			String startTime = r.getConsultationrecordOrderTime() + " " + r.getConsultationrecordStartTime();
			String endTime = r.getConsultationrecordOrderTime() + " " + r.getConsultationrecordEndTime();
			Date start = sdf.parse(startTime);
			Date end = sdf.parse(endTime);
			Date now = new Date();

			if (now.after(start) && now.before(end)) {
				pw.print(r);
				// session 放入对方的 User, randomAddress
				User my = (User) session.getAttribute("user");
				
				if(my.getUserId() == r.getUser().getUserId()) {
					session.setAttribute("other", r.getTeacher().getUser());
				} else {
					session.setAttribute("other", r.getUser());
				}
				
				// 放入videoChatAddress
				String videoChatAddress = r.getRandomNum() + r.getConsultationrecordId();
				System.out.println("videoChatAddress:" + videoChatAddress);
				session.setAttribute("videoChatAddress", videoChatAddress);
				
			}
		}
	}
}
