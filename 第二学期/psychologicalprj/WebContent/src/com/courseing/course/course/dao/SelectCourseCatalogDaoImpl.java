package com.courseing.course.course.dao;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.CourseCatalog;

@Repository
public class SelectCourseCatalogDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	private Logger logger = Logger.getLogger(SelectCourseCatalogDaoImpl.class);

	public List<CourseCatalog> selectCourseCatalog(int courseId) {
		logger.info("courseId: " + courseId);
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("from CourseCatalog cou where cou.parentCourseCatalog = null and cou.courseId= ?");
		query.setInteger(0, courseId);
		List<CourseCatalog> list = query.list();
		logger.info("list size: " + list.size());
		return list;
	}

}
