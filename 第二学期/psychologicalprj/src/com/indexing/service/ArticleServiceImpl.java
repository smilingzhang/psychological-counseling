package com.indexing.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Article;
import com.indexing.dao.ArticleDaoImpl;

@Service
public class ArticleServiceImpl {

	@Resource
	private ArticleDaoImpl articleDaoImpl;
	
	public List<Article> listArticleLimited(){
		return articleDaoImpl.selectArticlesLimited();
	}
}
