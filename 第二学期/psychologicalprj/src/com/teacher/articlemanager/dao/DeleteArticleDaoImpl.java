package com.teacher.articlemanager.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.Article;

@Repository
public class DeleteArticleDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	public boolean updateArticle(int articleId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Article cou where cou.articleId = ?");
		query.setInteger(0, articleId);
		Article article = new Article();
		article = (Article) query.uniqueResult();
		session.delete(article);
		session.flush();
		return true;
	}
}
