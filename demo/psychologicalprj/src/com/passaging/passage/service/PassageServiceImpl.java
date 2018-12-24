package com.passaging.passage.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Article;
import com.entity.Evaluate;
import com.entity.User;
import com.passaging.passage.dao.PassageDaoImpl;

@Service
public class PassageServiceImpl {
	@Resource
	private PassageDaoImpl passageDaoImpl;

	public Article findArticleByArticleId(int articleId) {
		return this.passageDaoImpl.selectArticle(articleId);
	}

	public void updateLookNumber(int articleLookNumber, int articleId) {
		this.passageDaoImpl.updateLookNumber(articleLookNumber, articleId);
	}

	public List<Evaluate> findEvaluateAllByArticleId(int articleId) {
		return this.passageDaoImpl.selectEvaluateList(articleId);
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
		this.passageDaoImpl.insertEvaluate(evaluate);
	}

	public int findArticleCount(int articleId) {
		return this.passageDaoImpl.count(articleId);
	}

	public List<Evaluate> findEvaluateByPage(int pageNum, int pageSize, int articleId) {
		return this.passageDaoImpl.selectEvaluateListByPage(pageNum, pageSize, articleId);
	}

}
