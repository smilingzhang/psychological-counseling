package com.psychologicalcounseling.passage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.psychologicalcounseling.entity.Article;
import com.psychologicalcounseling.entity.Evaluate;
import com.psychologicalcounseling.entity.User;
import com.psychologicalcounseling.passage.dao.PassageDaoImpl;
	
@Service
public class PassageServiceImpl {
	@Resource
	private PassageDaoImpl passageDaoImpl;
	
	public Article findArticle(int articleId) {
		return this.passageDaoImpl.findById(articleId);
	}
	
	public void updateLookNumber(int articleLookNumber,int articleId) {
		this.passageDaoImpl.updateLookNumber(articleLookNumber, articleId);
	}
	
	public List<Evaluate> findEvaluateAll(int articleId){
		return this.passageDaoImpl.list(articleId);
	}
	
	public User findUserByUserId(int userId) {
		return this.passageDaoImpl.selectUser(userId);
	}
	
	public String findUserHeadPathById(int userId) {
		return this.passageDaoImpl.selectUserHeadPath(userId);
	}
	
	public String findUserRealNameById(int userId) {
		return this.passageDaoImpl.selectUserRealName(userId);
	}
	
	public void insertEvaluate(Evaluate evaluate) {
		this.passageDaoImpl.insert(evaluate);
	}
	
	public int findCount(int articleId) {
		return this.passageDaoImpl.count(articleId);
	}
	
	public List<Evaluate> findEvaluateByPage(int pageNum,int pageSize,int articleId){
		return this.passageDaoImpl.findByPage(pageNum, pageSize, articleId);
	}
	
}
