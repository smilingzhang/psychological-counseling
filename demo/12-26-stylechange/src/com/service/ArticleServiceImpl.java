package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ArticleDaoImpl;
import com.entity.Article;

@Service
public class ArticleServiceImpl {

	@Resource
	private ArticleDaoImpl articleDaoImpl;
	
	public List<Article> listArticleLimited(){
		return articleDaoImpl.selectArticlesLimited();
	}
}
