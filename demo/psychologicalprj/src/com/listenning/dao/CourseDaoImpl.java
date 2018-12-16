package com.listenning.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.entity.Course;
import com.util.BaseDao;

@Repository
public class CourseDaoImpl extends BaseDao<Course>{
	
	
	public List<Course> findCoursesByTeacherId(int id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "from Course c where c.teacher.teacherId=?";
		Query q = session.createQuery(hql);
		q.setInteger(0, id);
		return q.list();
	}
	
}
