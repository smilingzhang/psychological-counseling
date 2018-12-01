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
 *@desc:日记�?
 *		字段：日记号，用户ID，记日记的时间，日记内容，天�?
 *		映射关系�? 单向多对�?   用户�?
 *@author 段智�?
 *@date:2018�?11�?20日下�?4:49:03
 */

@Entity
@Table(name="diary")
public class Diary {
	private int diaryId;
	private Date diaryRecordTime;
	private String diaryContent;
	private String diaryWeather;
	private User user;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getDiaryId() {
		return diaryId;
	}
	public void setDiaryId(int diaryId) {
		this.diaryId = diaryId;
	}
	public Date getDiaryRecordTime() {
		return diaryRecordTime;
	}
	public void setDiaryRecordTime(Date diaryRecordTime) {
		this.diaryRecordTime = diaryRecordTime;
	}
	
	public String getDiaryContent() {
		return diaryContent;
	}
	public void setDiaryContent(String diaryContent) {
		this.diaryContent = diaryContent;
	}
	public String getDiaryWeather() {
		return diaryWeather;
	}
	public void setDiaryWeather(String diaryWeather) {
		this.diaryWeather = diaryWeather;
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
