package com.teacher.articlemanager.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.entity.Article;
import com.entity.TypeTable;
import com.teacher.articlemanager.dao.SelectArticleDaoImpl;

@Service
public class SelectArticleServiceImpl {

	@Resource
	private SelectArticleDaoImpl selectArticleDaoImpl;
	
	/**
	 * 查询出咨询师发表的文章数量
	 * @param teacherId
	 * @return
	 */
	public int findArticleCount(int teacherId) {
		return this.selectArticleDaoImpl.selectArticleCount(teacherId);
	}
	
	/**
	 * 分页查询咨询师发表的文章
	 * @param pageNum
	 * @param PageSize
	 * @param teacherId
	 * @return
	 */
	public List<Article> findArticleByPage(int pageNum,int pageSize,int teacherId){
		return this.selectArticleDaoImpl.selectArticleByPage(pageNum, pageSize, teacherId);
	}
	
	/**
	 * 根据文章的ID查询出业务类别
	 * @param articleId
	 * @return
	 */
	public List<TypeTable> findTypeTableById(int articleId){
		return this.selectArticleDaoImpl.selectTypeTableById(articleId);
	}
	
	/**
	 * 根据文章的Id查询出评论的数量
	 * @param articleId
	 * @return
	 */
	public int findEvaluateCountById(int articleId) {
		return this.selectArticleDaoImpl.selectEvaluateCountById(articleId);
	}
}
