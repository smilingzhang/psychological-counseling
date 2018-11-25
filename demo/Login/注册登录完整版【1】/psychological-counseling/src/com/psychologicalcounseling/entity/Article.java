package com.psychologicalcounseling.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 *@desc:文章表
 *	字段：文章ID(article)，文章名称，咨询师ID，banner图路径，简介，正文，发表时间，浏览数量
 *	映射关系：单向多对一   咨询师表
 *@author 段智兴
 *@date:2018年11月20日下午4:35:40
 */
@Entity
@Table(name="article")
public class Article {
	private int articleId;
	private String articleName;
	private String articleImgPath;
	private String articleIntroduction;
	private String articleContent;
	private Date articlePublishTime;
	private int articleLookNumber;
	private Teacher teacher;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public String getArticleImgPath() {
		return articleImgPath;
	}
	public void setArticleImgPath(String articleImgPath) {
		this.articleImgPath = articleImgPath;
	}
	public String getArticleIntroduction() {
		return articleIntroduction;
	}
	public void setArticleIntroduction(String articleIntroduction) {
		this.articleIntroduction = articleIntroduction;
	}
	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
	
	public String getArticleContent() {
		return articleContent;
	}
	public Date getArticlePublishTime() {
		return articlePublishTime;
	}
	public void setArticlePublishTime(Date articlePublishTime) {
		this.articlePublishTime = articlePublishTime;
	}
	public int getArticleLookNumber() {
		return articleLookNumber;
	}
	public void setArticleLookNumber(int articleLookNumber) {
		this.articleLookNumber = articleLookNumber;
	}
	@ManyToOne
	@JoinColumn(name="teacherId")
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
	
	
	
	
}
