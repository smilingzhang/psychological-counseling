package com.listenning.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.ListenRecord;
import com.entity.Teacher;
import com.entity.User;
import com.listenning.service.ListenRecordServiceImpl;
import com.listenning.service.TeacherServiceImpl;

@Controller
public class TeacherListenTimeController {
	
	@Resource
	private ListenRecordServiceImpl listenRecordServiceImpl;

	@Resource
	private TeacherServiceImpl teacherServiceImpl;

	@RequestMapping("/listenTimeControl")
	public void ListenTimeControl(HttpSession session) {

		int id = (int) session.getAttribute("listenRecordId");
		ListenRecord rd = listenRecordServiceImpl.searchListenRecordById(id);
		User user = (User) session.getAttribute("user");
		int identity = user.getUserIdentity();
		// 如果是普通用户,则不必修改listenTime
		if (identity == 1)
			return;
		Teacher t = teacherServiceImpl.findTeacherById(user.getUserId());

		teacherServiceImpl.changeTeacherListenTime(t, 2);
	}
}
