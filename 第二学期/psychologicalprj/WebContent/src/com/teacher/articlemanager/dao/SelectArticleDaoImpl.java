package com.teacher.articlemanager.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.Article;
import com.entity.BusinessType;
import com.entity.TypeTable;


@Repository
public class SelectArticleDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	/**
	 * 查询出咨询师发表文章的数量
	 * @param teacherId
	 * @return
	 */
	public int selectArticleCount(int teacherId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select a.articleId from Article a where a.teacher = ?");
		q.setInteger(0, teacherId);
		int count = q.list().size();
		return count;
	}
	
	
	/**
	 * 分页查询咨询师发表的文章
	 */
	public List<Article> selectArticleByPage(int pageNum,int pageSize,int teacherId){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Article where teacher = ? order by articlePublishTime desc");
		q.setInteger(0, teacherId);
		q.setMaxResults(pageSize);
		q.setFirstResult((pageNum-1)*pageSize);
		List<Article> list = q.list();
		return list;
	}
	
	/**
	 * 根据文章Id查询文章类别
	 * @param articleId
	 * @return
	 */
	public List<TypeTable> selectTypeTableById(int articleId){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select typeTable from BusinessType where businesstypeWorkId = ? and businesstypeWorkType = 5");
		q.setInteger(0, articleId);
		List<TypeTable> list = q.list();
		return list;
	}
	
//	public TypeTable selectTypeTable(TypeTable typeTable) {
//		Session session = this.sessionFactory.getCurrentSession();
//		Query q = session.createQuery("from TypeTable")
//	}
	
	/**
	 * 根据文章Id查询出评论的数量
	 * @param articleId
	 * @return
	 */
	public int selectEvaluateCountById(int articleId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Evaluate where evaluateWorkId = ?");
		q.setInteger(0, articleId);
		int count = q.list().size();
		return count;
	}
	
	public Article selectArticleById(int articleId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Article where articleId = ?");
		q.setInteger(0, articleId);
		Article article = new Article();
		article =(Article) q.uniqueResult();
		return article;
	}
}
