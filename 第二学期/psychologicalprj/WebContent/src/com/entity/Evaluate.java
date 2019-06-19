package com.entity;

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
 *@desc:通用评价�?
 *		字段：流水号，业务类型：1.咨询2.倾听3.课程4.测评，业务ID，评论内容，评价时间，星级，评价人ID
 *		映射关系：单向多对一  用户�?
 *@author 段智�?
 *@date:2018�?11�?20日下�?4:06:43
 */
@Entity
@Table(name="evaluate")
public class Evaluate {
	private int evaluateId;
	private int evaluateWorkType;
	private int evaluateWorkId;
	private String evaluateComment;
	private Date evaluateTime;
	private int evaluateStar;
	private User user;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getEvaluateId() {
		return evaluateId;
	}
	public void setEvaluateId(int evaluateId) {
		this.evaluateId = evaluateId;
	}
	public int getEvaluateWorkType() {
		return evaluateWorkType;
	}
	public void setEvaluateWorkType(int evaluateWorkType) {
		this.evaluateWorkType = evaluateWorkType;
	}
	public int getEvaluateWorkId() {
		return evaluateWorkId;
	}
	public void setEvaluateWorkId(int evaluateWorkId) {
		this.evaluateWorkId = evaluateWorkId;
	}
	public String getEvaluateComment() {
		return evaluateComment;
	}
	public void setEvaluateComment(String evaluateComment) {
		this.evaluateComment = evaluateComment;
	}
	public Date getEvaluateTime() {
		return evaluateTime;
	}
	public void setEvaluateTime(Date evaluateTime) {
		this.evaluateTime = evaluateTime;
	}
	public int getEvaluateStar() {
		return evaluateStar;
	}
	public void setEvaluateStar(int evaluateStar) {
		this.evaluateStar = evaluateStar;
	}
	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	
	
	
	
}
