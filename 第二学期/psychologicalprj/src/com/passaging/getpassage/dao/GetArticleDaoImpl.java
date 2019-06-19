package com.passaging.getpassage.dao;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.Article;
import com.entity.BusinessType;
import com.entity.Teacher;
import com.entity.TypeTable;
import com.entity.User;

@Repository
public class GetArticleDaoImpl {
	@Resource
	private SessionFactory sessionfactory;

	/**
	 * 将文章插入数据库
	 * 
	 * @param article
	 */
	public void insertpassage(Article article) {
		Session session = this.sessionfactory.getCurrentSession();
		session.save(article);
	}

	/**
	 * 将文章类别插入类别数据库
	 * 
	 * @param businesstype
	 */
	public void insertBusinessType(BusinessType businesstype) {
		Session session = this.sessionfactory.getCurrentSession();
		session.save(businesstype);
	}

	/**
	 * 根据用户名查询用户
	 * 
	 * @param userName
	 * @return
	 */
	public User selectUser(String userName) {
		Session session = this.sessionfactory.getCurrentSession();
		Query q = session.createQuery("from User u where userRealName = ?");
		q.setString(0, userName);
		User user = (User) q.uniqueResult();
		return user;
	}

	/**
	 * 根据用户Id查询出咨询师
	 * 
	 * @param userId
	 * @return
	 */
	public Teacher selectTeacher(int userId) {
		Session session = this.sessionfactory.getCurrentSession();
		Query q = session.createQuery("from Teacher where teacherId = ?");
		q.setInteger(0, userId);
		Teacher teacher = (Teacher) q.uniqueResult();
		return teacher;
	}

	/**
	 * 查出文章的Id值
	 * 
	 * @param articleName
	 * @param teacher
	 * @return
	 */
	public int selectArticleId(String articleName, Teacher teacher) {
		Session session = this.sessionfactory.getCurrentSession();
		Query q = session.createQuery("select articleId from Article where articleName = ? and teacher = ?");
		q.setString(0, articleName);
		q.setEntity(1, teacher);
		int articleId = (int) q.uniqueResult();
		return articleId;
	}

	/**
	 * 查询文章类别
	 * 
	 * @param typetableId
	 * @return
	 */
	public TypeTable selectTypeTable(int typetableId) {
		Session session = this.sessionfactory.getCurrentSession();
		Query q = session.createQuery("from TypeTable where typetableId = ?");
		q.setInteger(0, typetableId);
		TypeTable typeTable = (TypeTable) q.uniqueResult();
		return typeTable;
	}
}
