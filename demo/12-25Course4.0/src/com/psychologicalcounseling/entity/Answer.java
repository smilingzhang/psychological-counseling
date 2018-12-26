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
 *@desc:心理回答表
 *		字段：回答ID，问题ID，咨询师ID，回复内容，回复时间，点赞次数
 *		映射关系： 单向多对一   咨询师表
 *				双向一对多   心理问答表
 *@author 段智兴
 *@date:2018年11月19日下午9:19:36
 */
@Entity
@Table(name="answer")
public class Answer {
	private int answerId;
	private String answerContent;
	private Date answerAnswerTime;
	private int answerGoodCount;
	private Teacher teacher;
	private Ask ask;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}

	
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public Date getAnswerAnswerTime() {
		return answerAnswerTime;
	}
	public void setAnswerAnswerTime(Date answerAnswerTime) {
		this.answerAnswerTime = answerAnswerTime;
	}
	public int getAnswerGoodCount() {
		return answerGoodCount;
	}
	public void setAnswerGoodCount(int answerGoodCount) {
		this.answerGoodCount = answerGoodCount;
	}
	@ManyToOne
	@JoinColumn(name="teacherId")
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	@ManyToOne
	@JoinColumn(name="askId")
	public Ask getAsk() {
		return ask;
	}
	public void setAsk(Ask ask) {
		this.ask = ask;
	}
	
	
	
}
