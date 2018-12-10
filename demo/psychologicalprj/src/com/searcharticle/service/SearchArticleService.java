package com.searcharticle.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Article;
import com.entity.Page;
import com.searcharticle.dao.SearchArticleDao;
import com.util.SetPageUtil;

@Service
public class SearchArticleService extends SetPageUtil<Article>{

	@Resource
	private SearchArticleDao searchArticleDao;
	/**
	 * 
	 *@desc:分页显示所有文章
	 *@param pageNum
	 *@param pageSize
	 *@return
	 *@return:Page<Course>
	 *@trhows
	 */
	public Page<Article> showAllArticles(String pageNum,int pageSize){
		int num=0;
		if(pageNum==null||pageNum.equals("")) {
			num=1;
		}
		else {
			num=Integer.parseInt(pageNum);
		}
		List<Article> list=searchArticleDao.searchAllArticles();
		List<Article> searchArticles = new ArrayList<>();
		for (int i = (num - 1) * pageSize; i < pageSize * num && i < list.size(); i++) {
			searchArticles.add(list.get(i));
		}
		Page<Article> pageArticles=setPage(num, pageSize, list.size(), searchArticles);
		return pageArticles;
	}
	/**
	 * 
	 *@desc:查询所有文章的数量
	 *@return
	 *@return:int
	 *@trhows
	 */
	public int countArticles() {
		List<Article> list=searchArticleDao.searchAllArticles();
		return list.size();
	}

}
