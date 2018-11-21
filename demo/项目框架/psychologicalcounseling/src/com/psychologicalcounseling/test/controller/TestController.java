package com.psychologicalcounseling.test.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.psychologicalcounseling.entity.Teacher;
import com.psychologicalcounseling.test.dao.TestDao;

@Controller

public class TestController {
	@Resource
	private TestDao testDao;
	@RequestMapping(value="index")
	public void test() {
		Teacher t =this.testDao.insertTeacher();
		System.out.println(t.getTeacherWorkTime());
	}
}
