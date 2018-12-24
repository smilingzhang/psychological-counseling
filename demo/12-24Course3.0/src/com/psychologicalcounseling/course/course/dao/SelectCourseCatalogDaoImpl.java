package com.psychologicalcounseling.course.course.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.CourseCatalog;

@Repository
public class SelectCourseCatalogDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	public List<CourseCatalog> selectCourseCatalog(int courseId) {
		System.out.println("courseId: "+courseId);
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from CourseCatalog cou where cou.parentCourseCatalog = null and cou.courseId= ?");
		query.setInteger(0, courseId);
		List<CourseCatalog> list = query.list();
		System.out.println("list size: "+list.size());
		return list;
	}

}
