package com.teacher.articlemanager.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.teacher.articlemanager.dao.OperateArticleDaoImpl;



@Service
public class OperateArticleServiceImpl {
	@Resource
	private OperateArticleDaoImpl operateArticleDaoImpl;
	/**
	 * 根据文章Id删除文章
	 * @param articleId
	 */
	public void deleteArticle(int articleId) {
		this.operateArticleDaoImpl.deleteArticle(articleId);
	}
	
	/**
	 * 根据文章Id删除BusinessType记录
	 * @param articleId
	 */
	public void deleteBusinessType(int articleId) {
		this.operateArticleDaoImpl.deleteBusinessType(articleId);
	}
}
