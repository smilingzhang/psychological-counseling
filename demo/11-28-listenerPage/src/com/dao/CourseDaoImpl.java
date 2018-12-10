package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.Course;

@Repository
public class CourseDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	public List<Course> findCoursesByTeacherId(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Course c where c.teacher.teacherId=?";
		Query q = session.createQuery(hql);
		q.setInteger(0, id);
		
		return q.list();
	}
	
}
