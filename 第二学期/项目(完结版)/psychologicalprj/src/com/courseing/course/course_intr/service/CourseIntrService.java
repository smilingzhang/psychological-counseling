package com.courseing.course.course_intr.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.courseing.course.course_intr.dao.CourseConllectionDaoImpl;
import com.courseing.course.course_intr.dao.CourseIntrDaoImpl;
import com.courseing.course.course_intr.dao.CourseOrderDaoImpl;
import com.entity.Course;

@Service
@Transactional(readOnly=true)
public class CourseIntrService {
	@Resource
	private CourseIntrDaoImpl courseIntrDaoImpl;
	
	@Resource
	private CourseOrderDaoImpl courseOrderDaoImpl;
	
	@Resource
	private CourseConllectionDaoImpl courseConllectionDaoImpl;
	//通过课程id查课程
	public Course findCourse(int id) {
		return courseIntrDaoImpl.findById(id);
	}
	//查询该用户是否购买过该课程
	public Boolean ifBuyCourse(int courseId,int userId) {
		boolean b = courseOrderDaoImpl.findOrder(courseId,userId);
		return b;
	}
	//查询该用户是否收藏过该课程
	public Boolean ifCollectionCourse(int userId,int courseId) {
		int i = courseConllectionDaoImpl.findCollection(userId, courseId);
		if(i==0) return false;
		else return true;
	}
	//查询给用户推荐的课程
	public List<Course> getRecommendList(String[] list){
		List<Course> resultlist = new ArrayList<>();
		int i = 0;
		for(i=0;i<5;i++) {
			//遍历从python传回来的推荐序列，查询到相关课程，组成新的List<Course>列表
			Course course = courseIntrDaoImpl.findById(Integer.parseInt(list[i]));
			resultlist.add(i, course);
		}
		return resultlist;
	}
}
