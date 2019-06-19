package com.search.searcharticle.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Article;
import com.util.BaseDao;
/**
 * 
 *@desc:搜索所有文章
 *@author chunhui
 *@date:Dec 10, 20183:52:55 PM
 */
@Repository
public class SearchArticleDao extends BaseDao<Article>{

	public List<Article> searchAllArticles(){
		return findAll(Article.class);
	}

}
