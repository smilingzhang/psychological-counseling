package com.video.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.video.entity.Course;
import com.video.entity.CourseCatalog;

@Repository
public class CourseDao {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 根据被点击的课程id获取课程的具体信息
	 * @param courseId
	 * @return
	 */
	public List<CourseCatalog> list(int courseId){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from CourseCatalog where courseId = ?");
		q.setInteger(0, courseId);
		return q.list();
	}
//	public List<Course> list1(int courseId){
//		Session session = this.sessionFactory.getCurrentSession();
//		Query q = session.createQuery("from Course where courseId = ?");
//		q.setInteger(0, courseId);
//		return q.list();
//	}
	public void insertCourseCatalog(CourseCatalog courseCatalog) {    //将课程的CourseCatalog表的信息插入数据库
		Session session = this.sessionFactory.getCurrentSession();
		session.save(courseCatalog);
		
	}
	
	public void insertCourse(Course course) {
		Session session = this.sessionFactory.getCurrentSession();    //将课程Course表的信息 插入数据库
		session.save(course);
		
	}
}
