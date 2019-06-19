package com.teacher.coursetimemanager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.teacher.coursetimemanager.ConsulterTimeServiceImpl;
import com.entity.Teacher;
import com.entity.TeacherTime;


@Controller
public class ConsulterTimeController {
	@Resource
	private  ConsulterTimeServiceImpl consultertimesericeimpl ;
	
	
	@SuppressWarnings("null")
	@RequestMapping(value="/joinday",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String joinConsulterDate(@RequestParam(name="day")String day,HttpServletRequest request) {
		HttpSession session = request.getSession();
		TeacherTime teachertimes = new TeacherTime();
		TeacherTime teachertime = new TeacherTime();
		Teacher teacher = new Teacher();
		List<Integer> nums = new ArrayList();
		//int userId = (int)session.getAttribute("useId");
		int userId = 4;
		//String[] a =day.split(",");
		//System.out.println("截取"+a[0]);
		teachertimes = this.consultertimesericeimpl.findTeacherTime(userId,day);
//		System.out.println("获取日期为"+day);
//		System.out.println(teachertime);
		if(teachertimes == null) {
		      teachertime.setDate(day);
		      teachertime.setTeacher(this.consultertimesericeimpl.findTeacherById(userId));
		      teachertime.setTime10(-1);
		      teachertime.setTime11(-1);
		      teachertime.setTime12(-1);
		      teachertime.setTime13(-1);
		      teachertime.setTime14(-1);
		      teachertime.setTime15(-1);
		      teachertime.setTime16(-1);
		      teachertime.setTime17(-1);
		      teachertime.setTime18(-1);
		      teachertime.setTime19(-1);
		      teachertime.setTime8(-1);
		      teachertime.setTime9(-1);
		      for(int i=1;i<=12;i++) {
		    	  nums.add(-1);
		      }
		      this.consultertimesericeimpl.loginDate(teachertime);
		      teachertime.setTeacher(null);
		}else {
			nums.add(teachertimes.getTime8());
			nums.add(teachertimes.getTime9());
			nums.add(teachertimes.getTime10());
			nums.add(teachertimes.getTime11());
			nums.add(teachertimes.getTime12());
			nums.add(teachertimes.getTime13());
			nums.add(teachertimes.getTime14());
			nums.add(teachertimes.getTime15());
			nums.add(teachertimes.getTime16());
			nums.add(teachertimes.getTime17());
			nums.add(teachertimes.getTime18());
			nums.add(teachertimes.getTime19());
			teachertimes.setTeacher(null);
		}
		
		//session.setAttribute("nums", nums);
		//session.setAttribute("flag", "4");
//		for(Integer temp:nums) {
//			System.out.println(temp+"jjjjjjjjjjjjjjjjjjjjjjjj");
//		}
		//session.setAttribute("teachertime", teachertime);
		Gson gson = new Gson();
		String gsonnums = gson.toJson(nums);

		String times = gson.toJson(teachertimes);
        
		Map<String,String> map = new HashMap();
		map.put(times, gsonnums);
		String maps = gson.toJson(map);
		return maps;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/joinhour",produces = "application/json; charset=utf-8")
	@ResponseBody
	public String joinConsulterhour(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		//int userId = (int)session.getAttribute("useId");
		int userId = 4;
		Teacher teacher = new Teacher();
		teacher = this.consultertimesericeimpl.findTeacherById(userId);
		String day = null;
		List<Integer> times = new ArrayList();
		List<Integer> timess = new ArrayList();
		Object obj = request.getParameter("day");
		Gson gson = new Gson();
		if(obj == null) {
			response.getWriter().write("<script>alert('请您选择时间！'); </script>");
		}else {
			day = (String)obj;
		}
		Object objs = request.getParameter("name");
		//Object objss = request.getParameter("names");
		System.out.println((String)objs);
		//System.out.println((String)objss);
		//System.out.println(day);
		if(objs == null) {
			response.getWriter().write("<script>alert('请您选择时间！'); </script>");
		}else {
			times = gson.fromJson((String) objs,new TypeToken<List<Integer>>(){}.getType());
		}
//		if(objss !=null) {
//			timess = gson.fromJson((String) objss,new TypeToken<List<Integer>>(){}.getType());
//		}
//		for(Integer temp:times) {
//			System.out.println(temp);
//		}
//		for(Integer temp:timess) {
//			System.out.println(temp);
//		}
		TeacherTime teachertime = new TeacherTime();
		teachertime = this.consultertimesericeimpl.findTeacherTime(userId,day);
		this.consultertimesericeimpl.changeTecherTime(times, teacher, day);
		//response.getWriter().write("<script>alert('保存成功！'); </script>");
		//System.out.println(day);
		return null;
	}
}
