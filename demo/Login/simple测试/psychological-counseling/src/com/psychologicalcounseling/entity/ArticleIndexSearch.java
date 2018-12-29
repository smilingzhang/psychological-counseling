package com.psychologicalcounseling.entity;

import java.io.Serializable;
/**
 * 
 *@desc:文章的索引结果集
 *@author chunhui
 *@date:Dec 12, 2018 8:20:57 PM
 */
public class ArticleIndexSearch implements Serializable{

	/**
	 *@desc:防止异常
	 *@Fields:serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private String articleId;
	private String articleTitle;
	private String articleIntroduction;
	private String articleContent;
	private String teacherName;
	private String publicationTime;
	public String getArticleId() {
		return articleId;
	}
	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	public String getArticleTitle() {
		return articleTitle;
	}
	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}
	public String getArticleIntroduction() {
		return articleIntroduction;
	}
	public void setArticleIntroduction(String articleIntroduction) {
		this.articleIntroduction = articleIntroduction;
	}
	public String getArticleContent() {
		return articleContent;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getPublicationTime() {
		return publicationTime;
	}
	public void setPublicationTime(String publicationTime) {
		this.publicationTime = publicationTime;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	

}
