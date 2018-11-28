package com.psychologicalcounseling.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 *@desc:心里问答表
 *		字段：问题ID，问题标题，问题内容，用户ID，提问时间，浏览次数
 *		映射关系：单向多对一  用户表
 *				双向一对多  心理回答表
 *@author XX
 *@date:2018年11月20日下午4:45:26
 */
@Entity
@Table(name="ask")
public class Ask {
	private int askId;
	private String askTitle;
	private String askContent;
	private Date askTime;
	private int askLookNumber;
	private User user;
	private Set<Answer> answers = new HashSet<Answer>();
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getAskId() {
		return askId;
	}
	public void setAskId(int askId) {
		this.askId = askId;
	}
	public String getAskTitle() {
		return askTitle;
	}
	public void setAskTitle(String askTitle) {
		this.askTitle = askTitle;
	}
	
	public String getAskContent() {
		return askContent;
	}
	public void setAskContent(String askContent) {
		this.askContent = askContent;
	}
	public Date getAskTime() {
		return askTime;
	}
	public void setAskTime(Date askTime) {
		this.askTime = askTime;
	}
	public int getAskLookNumber() {
		return askLookNumber;
	}
	public void setAskLookNumber(int askLookNumber) {
		this.askLookNumber = askLookNumber;
	}
	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@OneToMany(mappedBy="ask",targetEntity=Answer.class,cascade=CascadeType.ALL)
	public Set<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(Set<Answer> answers) {
		this.answers = answers;
	}
	
	
	
	
	
}
