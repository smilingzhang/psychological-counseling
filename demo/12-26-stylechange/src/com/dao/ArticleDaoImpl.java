package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.entity.Article;
import com.util.BaseDao;

@Repository
public class ArticleDaoImpl extends BaseDao<Article>{

	public List<Article> selectArticlesLimited() {
		
		String hql = "from Article";
		return super.findByPage(hql, 1, 4);
	}
}
