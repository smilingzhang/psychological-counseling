package com.service;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.TeacherDaoImpl;
import com.entity.Teacher;

/**
 * 
 *@desc:一句话被描述
 *@author baozhangjun
 *@date:2018年12月11日下午4:17:36
 */
@Service
public class TeacherServiceImpl {

	@Resource
	private TeacherDaoImpl teacherDaoImpl;

	/**
	 * 
	 *@desc:通过传过来的参数来选择筛选的方法,当前可以倾听的倾听师
	 *@param pageNo
	 *@param pageSize
	 *@param gender
	 *@param age
	 *@return
	 *@return:List<Teacher>
	 *@trhows
	 */
	public List<Teacher> listListeners(int pageNo, int pageSize, String gender, String age) {
		List<Teacher> teachers;
		if (gender.equals("default") && age.equals("default")) {
			teachers = teacherDaoImpl.findCanListenersByPage(pageNo, pageSize);
		} else if (gender.equals("default") && !age.equals("default")) {
			teachers = teacherDaoImpl.findCanListenersByAgeAndPage(pageNo, pageSize, age); 
		} else if (!gender.equals("default") && age.equals("default")) {
			teachers = teacherDaoImpl.findCanListenersBySexAndPage(pageNo, pageSize, gender);
		} else {
			teachers = teacherDaoImpl.findCanListenersBySexAndAgeAndPage(pageNo, pageSize, gender, age);
		}
		return teachers;
	}
	
	public long countListeners(String gender, String age) throws Exception {
		long cnt;
		if (gender.equals("default") && age.equals("default")) {
			cnt = teacherDaoImpl.findCountCanListeners();
		} else if (gender.equals("default") && !age.equals("default")) {
			cnt = teacherDaoImpl.findCountCanListenersByAge(age);
		} else if (!gender.equals("default") && age.equals("default")) {
			cnt = teacherDaoImpl.findCountCanListenersBySex(gender);
		} else {
			cnt = teacherDaoImpl.findCountCanListenersBySexAndAge(gender, age);
		}
		return cnt;
	}

	public Teacher findTeacherById(Serializable id) {
		return teacherDaoImpl.get(Teacher.class, id);
	}

	@Transactional
	public void changeTeacherCanListen(Teacher t, int canListen) {
		t.setCanListen(canListen);
		teacherDaoImpl.update(t);
	}

	@Transactional
	/**
	 * 
	 * @Desc: listenTime (min) @date 2018年12月10日:上午10:43:31 @author
	 * baozhangjun @throws
	 */
	public void changeTeacherListenTime(Teacher t, int listenTime) {
		t.setTeacherListenTime(t.getTeacherListenTime() + listenTime);
		teacherDaoImpl.update(t);
	}

}
