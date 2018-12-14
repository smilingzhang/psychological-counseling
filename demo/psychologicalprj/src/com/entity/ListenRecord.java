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
 *@desc:倾听记录�?
 *		字段：流水号，用户ID，预约时间，�?始时间，结束时间，价�? �?
 *			订单状�?�：已完�?/已支�?/已取消，倾听师ID，资源路�?
 *		映射关系：单向多对一  咨询师表，用户表
 *@author 段智�?
 *@date:2018�?11�?20日下�?4:25:53
 */

@Entity
@Table(name="listenrecord")

public class ListenRecord {
	private int listenrecordId;
	private String listenrecordOrderTime;
	private String listenrecordStartTime;
	private String listenrecordEndTime;
	private float listenrecordPrice;
	private int listenrecordState;
	private String listenrecordResourcePath;
	private Teacher teacher;
	private User user;
	private String randomNum;
	private String listenState;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getListenrecordId() {
		return listenrecordId;
	}
	public void setListenrecordId(int listenrecordId) {
		this.listenrecordId = listenrecordId;
	}
	public String getListenrecordOrderTime() {
		return listenrecordOrderTime;
	}
	public void setListenrecordOrderTime(String listenrecordOrderTime) {
		this.listenrecordOrderTime = listenrecordOrderTime;
	}
	public String getListenrecordStartTime() {
		return listenrecordStartTime;
	}
	public void setListenrecordStartTime(String listenrecordStartTime) {
		this.listenrecordStartTime = listenrecordStartTime;
	}
	public String getListenrecordEndTime() {
		return listenrecordEndTime;
	}
	public void setListenrecordEndTime(String listenrecordEndTime) {
		this.listenrecordEndTime = listenrecordEndTime;
	}
	public float getListenrecordPrice() {
		return listenrecordPrice;
	}
	public void setListenrecordPrice(float listenrecordPrice) {
		this.listenrecordPrice = listenrecordPrice;
	}
	public int getListenrecordState() {
		return listenrecordState;
	}
	public void setListenrecordState(int listenrecordState) {
		this.listenrecordState = listenrecordState;
	}
	public String getListenrecordResourcePath() {
		return listenrecordResourcePath;
	}
	public void setListenrecordResourcePath(String listenrecordResourcePath) {
		this.listenrecordResourcePath = listenrecordResourcePath;
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
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}
	@Override
	public String toString() {
		return "ListenRecord [listenrecordId=" + listenrecordId + ", listenrecordOrderTime=" + listenrecordOrderTime
				+ ", listenrecordStartTime=" + listenrecordStartTime + ", listenrecordEndTime=" + listenrecordEndTime
				+ ", listenrecordPrice=" + listenrecordPrice + "]";
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getRandomNum() {
		return randomNum;
	}
	public void setRandomNum(String randomNum) {
		this.randomNum = randomNum;
	}
	public String getListenState() {
		return listenState;
	}
	public void setListenState(String listenState) {
		this.listenState = listenState;
	}
	
	
	
	
}
