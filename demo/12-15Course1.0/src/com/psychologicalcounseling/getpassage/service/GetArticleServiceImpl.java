package com.psychologicalcounseling.getpassage.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.psychologicalcounseling.entity.Article;
import com.psychologicalcounseling.entity.BusinessType;
import com.psychologicalcounseling.entity.Teacher;
import com.psychologicalcounseling.entity.TypeTable;
import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.getpassage.dao.GetArticleDaoImpl;

@Service
public class GetArticleServiceImpl {

	@Resource
	private GetArticleDaoImpl getArticleDaoImpl;
	
	public void AddpassageToArticle(Article article) {
		this.getArticleDaoImpl.insertpassage(article);
	}
	
	public void AddpassageToBusinessType(BusinessType businessType) {
		this.getArticleDaoImpl.insertBusinessType(businessType);
	}
	
	public User findUserByUserName(String userName) {
		return this.getArticleDaoImpl.selectUser(userName);
	}
	
	public Teacher findTeacherByUserId(int userId) {
		return this.getArticleDaoImpl.selectTeacher(userId);
	}
	
	public int findArticleIdByArticleNameAndTeacher(String articleName,Teacher teacher) {
		return this.getArticleDaoImpl.selectArticleId(articleName, teacher);
	}
	
	public TypeTable findTypeTableByTypeTableId(int typeTableId) {
		return this.getArticleDaoImpl.selectTypeTable(typeTableId);
	}
}
