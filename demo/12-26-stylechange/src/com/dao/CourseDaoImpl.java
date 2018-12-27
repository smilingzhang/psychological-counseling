package com.dao;

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
	
	
	public List<Course> findCoursesByPage() {	
		String hql = "from Course c";
		return super.findByPage(hql, 1, 6);
	}
	
	public List<Course> findCoursesByTypeAndPage(String conditicon) {	
		String hql = "select c from Course c, TypeTable tt, BusinessType bt"
				+ " where tt.typetableName = ? and tt.typetableId = bt.typeTable.typetableId "
				+ "and bt.businesstypeWorkId = c.courseId "
				+ "and bt.businesstypeWorkType = 3";
		return super.findByPage(hql, 1, 6, conditicon);
	}
	
	
	
	
	
	
}
