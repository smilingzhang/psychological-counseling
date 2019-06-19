package com.teacher.articlemanager.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.teacher.articlemanager.dao.DeleteArticleDaoImpl;

@Service
public class DeleteArticleServiceImpl {
	@Resource
	private DeleteArticleDaoImpl DeleteArticleDaoImpl;
	
	
	public boolean deleteArticle(int articleId) {
		return this.DeleteArticleDaoImpl.updateArticle(articleId);
	}
}
