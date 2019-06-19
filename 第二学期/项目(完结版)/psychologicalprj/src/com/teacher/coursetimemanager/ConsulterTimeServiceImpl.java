package com.teacher.coursetimemanager;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.teacher.coursetimemanager.ConsulterTimeDaoImpl;
import com.entity.Teacher;
import com.entity.TeacherTime;

@Service
public class ConsulterTimeServiceImpl {
	@Resource
	private ConsulterTimeDaoImpl consultertimedaoimpl;
	
	public boolean loginDate(TeacherTime teacherTime) {
		this.consultertimedaoimpl.updateDate(teacherTime);
		return true;
	}
	
	public Teacher findTeacherById(int teacherId) {
		return this.consultertimedaoimpl.selectTeacherById(teacherId);
	}
	
	public TeacherTime findTeacherTime(int userId,String day) {
		return this.consultertimedaoimpl.selectTeacherTime(userId,day);
	}
	
	public void changeTecherTime(List<Integer> list,Teacher teacher,String date) {
		  TeacherTime teachertime = new TeacherTime();
		  teachertime.setTeacher(teacher);
		  teachertime.setDate(date);
		  teachertime.setTime8(list.get(0));
	      teachertime.setTime9(list.get(1));
		  teachertime.setTime10(list.get(2));
	      teachertime.setTime11(list.get(3));
	      teachertime.setTime12(list.get(4));
	      teachertime.setTime13(list.get(5));
	      teachertime.setTime14(list.get(6));
	      teachertime.setTime15(list.get(7));
	      teachertime.setTime16(list.get(8));
	      teachertime.setTime17(list.get(9));
	      teachertime.setTime18(list.get(10));
	      teachertime.setTime19(list.get(11));
	      this.consultertimedaoimpl.updateTeacherTime(teachertime);
	}
}
