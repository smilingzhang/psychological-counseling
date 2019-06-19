package com.courseing.course.course_record.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.courseing.course.course_record.service.CourseRecordService;

@Controller
@ResponseBody
/**
 * 
 *@desc:获取到通过ajax同步传回来的内容更新课程记录表的数据，并将结果以json字符串返回
 *@author 段智兴
 *@date:2018年12月10日上午11:15:38
 */
public class UpdateCourseRecordController {
	@Resource
	private CourseRecordService courseRecordService;
	@RequestMapping("/setCourseRecord")
	public void updateCourseRecord(@RequestParam(value="crid")String crid,@RequestParam(value="time") String time,@RequestParam(value="totaltime")String totaltime,HttpSession session) {
		//将三个参数转为int类型
		int crId= Integer.parseInt(crid);
		int ts= Integer.parseInt(time);
		int tts= Integer.parseInt(totaltime);
		//调用service方法更新数据
		courseRecordService.setCourseRecord(ts, tts, crId);
		//清除session中的记录id，避免误修改
		session.removeAttribute("CourseRecordId");
		
	}
}
