package com.teacher.articlemanager.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class OperateArticleDaoImpl {
	
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 根据文章Id删除文章
	 * @param articleId
	 * @return
	 */
	public void deleteArticle(int articleId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete from Article where articleId = ?");
		q.setInteger(0, articleId);
		q.executeUpdate();
	}
	
	/**
	 * 根据文章Id删除BusinessType记录
	 * @param articleId
	 */
	public void deleteBusinessType(int articleId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("delete from BusinessType Where businesstypeWorkId = ? and businesstypeWorkType = 5");
		q.setInteger(0, articleId);
		q.executeUpdate();
	}
}
