package com.teacher.articlemanager.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Article;
import com.entity.BusinessType;
import com.entity.Teacher;
import com.entity.TypeTable;
import com.entity.User;
import com.teacher.articlemanager.dao.PublishArticleDaoImpl;

@Service
public class PublishArticleServiceImpl {

	@Resource
	private PublishArticleDaoImpl publishArticleDaoImpl;
	
	public void AddpassageToArticle(Article article) {
		this.publishArticleDaoImpl.insertpassage(article);
	}
	
	public void AddpassageToBusinessType(BusinessType businessType) {
		this.publishArticleDaoImpl.insertBusinessType(businessType);
	}
	
	public User findUserByUserName(String userName) {
		return this.publishArticleDaoImpl.selectUser(userName);
	}
	
	public Teacher findTeacherByUserId(int userId) {
		return this.publishArticleDaoImpl.selectTeacher(userId);
	}
	
	public int findArticleIdByArticleNameAndTeacher(String articleName,Teacher teacher) {
		return this.publishArticleDaoImpl.selectArticleId(articleName, teacher);
	}
	
	public TypeTable findTypeTableByTypeTableId(int typeTableId) {
		return this.publishArticleDaoImpl.selectTypeTable(typeTableId);
	}
}
