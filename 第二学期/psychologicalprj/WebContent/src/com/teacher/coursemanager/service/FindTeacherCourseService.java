package com.teacher.coursemanager.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.Course;
import com.entity.TeacherCourse;
import com.teacher.coursemanager.dao.SelectCourseByTeacherDaoImpl;
import com.teacher.coursemanager.dao.SelectCourseTimeNum;
import com.teacher.coursemanager.dao.SelectCourseType;
import com.teacher.coursemanager.dao.SelectLookNum;
import com.teacher.coursemanager.dao.SelectParentNum;

@Service
@Transactional(readOnly=true)
/**
 * 
 *@desc:通过调用dao中的方法构造数据结构TeacherCourse的链表，返回controller想要的结果
 *@author 段智兴
 *@date:2018年12月24日下午3:12:25
 */
public class FindTeacherCourseService {
	@Resource
	private SelectCourseByTeacherDaoImpl selectCourseByTeacherDaoImpl;
	@Resource
	private SelectCourseTimeNum selectCourseTimeNum;
	@Resource
	private SelectCourseType selectCourseType;
	@Resource
	private SelectLookNum selectLookNum;
	@Resource
	private SelectParentNum selectParentNum;
	
	public List<TeacherCourse> findTeacherCourse(int teacherId,int pageNo){
		List<Course> list = selectCourseByTeacherDaoImpl.selectCourseByTeacher(teacherId, pageNo);
		List<TeacherCourse> tclist = new ArrayList<>();
		//遍历四个课程，将他们封装成TeacherCourse对象的链表
		for(Course course :list) {
			TeacherCourse tc = new TeacherCourse();
			tc.setCourse(course);
			tc.setCourseType(selectCourseType.SelectCourseType(course.getCourseId()).get(0));
			tc.setLookNum(selectLookNum.selectLookNum(course.getCourseId()));
			int pi = selectParentNum.SelectParentNum(course.getCourseId());
			int ai = selectCourseTimeNum.SelectCourseTimeNum(course.getCourseId());
			tc.setParentNum(pi);
			tc.setCourseTimeNum(ai-pi);
			tclist.add(tc);
		}
		return tclist;
	}

}
