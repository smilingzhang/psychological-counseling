package com.entity;

import java.util.Date;
import java.util.List;

public class Artshow<T> {
	private List<T> typetableList;  
	private int articleId;
	private String articleName;
	private String articleIntroduction;
	private int articleLookNumber;
	private int evaluateCount;
	private Date articlePublishTime;
	public List<T> getTypetableList() {
		return typetableList;
	}
	public void setTypetableList(List<T> typetableList) {
		this.typetableList = typetableList;
	}
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public String getArticleIntroduction() {
		return articleIntroduction;
	}
	public void setArticleIntroduction(String articleIntroduction) {
		this.articleIntroduction = articleIntroduction;
	}
	public int getArticleLookNumber() {
		return articleLookNumber;
	}
	public void setArticleLookNumber(int articleLookNumber) {
		this.articleLookNumber = articleLookNumber;
	}
	public int getEvaluateCount() {
		return evaluateCount;
	}
	public void setEvaluateCount(int evaluateCount) {
		this.evaluateCount = evaluateCount;
	}
	public Date getArticlePublishTime() {
		return articlePublishTime;
	}
	public void setArticlePublishTime(Date articlePublishTime) {
		this.articlePublishTime = articlePublishTime;
	}
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	
	
}
