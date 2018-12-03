package com.Consultation.consulterlist.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Consultation.consulterlist.dao.ConsulterDao;
import com.entity.Course;
import com.entity.Teacher;
/**
 * 
 *@desc:预约功能咨询索引页对应的service
 *@author chunhui
 *@date:Nov 28, 20181:19:33 PM
 */
@Service
@Transactional(readOnly=true)
public class ConsulterService {
	@Resource
	private ConsulterDao consulterDao;

	public List<Teacher> findByScreen(int pageNum,int pageSize,int type,String date){
		return consulterDao.selectByScreen(pageNum, pageSize, type, date);
	}
	public List<Teacher> findByRate(){
		return this.consulterDao.selectByRate();
	}
	public List<Teacher> findDefault(){
		return this.consulterDao.selectDefault();
	}
	public Teacher findById(int id) {
		return this.consulterDao.selectById(id);
	}
	public List<Course> findCourseByTeacherId(int teacherId){
		return this.consulterDao.selectCourseByTeacherId(teacherId);
	}

}
