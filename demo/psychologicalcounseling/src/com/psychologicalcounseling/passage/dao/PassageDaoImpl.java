package com.psychologicalcounseling.passage.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.Article;
import com.psychologicalcounseling.entity.Evaluate;
import com.psychologicalcounseling.entity.User;

@Repository
public class PassageDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 通过文章的Id找到相应的文章
	 * @param articleId
	 * @return
	 */
	public Article findById(int articleId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Article where articleId = ?");
		q.setInteger(0, articleId);
		Article article = (Article)q.uniqueResult();
		return article;
	}
	/**
	 * 更新文章的阅读量
	 * @param articleLookNumber
	 * @param articleId
	 */
	public void updateLookNumber(int articleLookNumber,int articleId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("update Article set articleLookNumber = ? where articleId = ?");
		q.setInteger(0, articleLookNumber);
		q.setInteger(1, articleId);
		q.executeUpdate();		
	}
	/**
	 * 查询文章的评论（未分页）
	 * @param articleId
	 * @return
	 */
	public List<Evaluate> list(int articleId){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Evaluate where evaluateWorkId = ?");
		q.setInteger(0, articleId);
		return q.list();
	}
	/**
	 * 查询用户
	 * @param userId
	 * @return
	 */
	public User selectUser(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from User where userId = ?");
		q.setInteger(0, userId);
		User user = (User)q.uniqueResult();
		return user;
	}
	/**
	 * 查询用户的头像路径
	 * @param userId
	 * @return
	 */
	public String selectUserHeadPath(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("select userHeadPath from User where userId = ?");
		q.setInteger(0, userId);
		String userHeadPath = (String)q.uniqueResult();
		return userHeadPath;
	}
	/**
	 * 查询用户的名字
	 * @param userId
	 * @return
	 */
	public String selectUserRealName(int userId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("select userRealName from User where userId = ?");
		query.setInteger(0, userId);
		String userRealName = (String)query.uniqueResult();
		return userRealName;
	}
	
	/**
	 * 向数据库插入评论
	 * @param evaluate
	 */
	public void insert(Evaluate evaluate) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(evaluate);
	}
	/**
	 * 查询评论的总共的条数
	 * @param articleId
	 * @return
	 */
	public int count(int articleId) {
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Evaluate where evaluateWorkId = ?");
		q.setInteger(0, articleId);	
		int count = q.list().size();
		return count;
	}
	/**
	 * 分页查询评论
	 * @param pageNum
	 * @param pageSize
	 * @param articleId
	 * @return
	 */
	public List<Evaluate> findByPage(int pageNum,int pageSize,int articleId){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Evaluate where evaluateWorkId = ? order by evaluateTime desc");
		q.setInteger(0, articleId);
		q.setFirstResult((pageNum-1)*pageSize);
		q.setMaxResults(pageSize);		
		return q.list();
	}
}
