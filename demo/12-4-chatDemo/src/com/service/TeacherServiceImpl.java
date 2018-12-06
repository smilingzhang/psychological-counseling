package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.TeacherDaoImpl;
import com.entity.Teacher;

@Service
public class TeacherServiceImpl {

	@Resource
	private TeacherDaoImpl teacherDaoImpl;
	public List<Teacher> listTeachers(){
		
		return teacherDaoImpl.findTeachers();
	}
	
	public List<Teacher> listTeachersBySexAndAge(String gender, String age){
		return teacherDaoImpl.findTeachersBySexAndAge(gender, age);
	}
	
	public List<Teacher> listTeachersBySex(String gender){
		return teacherDaoImpl.findTeachersBySex(gender);
	}
	
//	public List<Teacher> listTeachersByAge(String age){
//		
//	}
	
	public Teacher listTeacherById(int id) {
		return teacherDaoImpl.findTeacherById(id);
	}
}
