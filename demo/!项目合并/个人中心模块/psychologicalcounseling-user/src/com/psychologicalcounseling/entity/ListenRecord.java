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
 *@desc:倾听记录表
 *		字段：流水号，用户ID，预约时间，开始时间，结束时间，价格 ，
 *			订单状态：已完成/已支付/已取消，倾听师ID，资源路径
 *		映射关系：单向多对一  咨询师表，用户表
 *@author 段智兴
 *@date:2018年11月20日下午4:25:53
 */

@Entity
@Table(name="listenrecord")

public class ListenRecord {
	private int listenrecordId;
	private Date listenrecordOrderTime;
	private Date listenrecordStartTime;
	private Date listenrecordEndTime;
	private float listenrecordPrice;
	private int listenrecordState;
	private String listenrecordResourcePath;
	private Teacher teacher;
	private User user;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getListenrecordId() {
		return listenrecordId;
	}
	public void setListenrecordId(int listenrecordId) {
		this.listenrecordId = listenrecordId;
	}
	public Date getListenrecordOrderTime() {
		return listenrecordOrderTime;
	}
	public void setListenrecordOrderTime(Date listenrecordOrderTime) {
		this.listenrecordOrderTime = listenrecordOrderTime;
	}
	public Date getListenrecordStartTime() {
		return listenrecordStartTime;
	}
	public void setListenrecordStartTime(Date listenrecordStartTime) {
		this.listenrecordStartTime = listenrecordStartTime;
	}
	public Date getListenrecordEndTime() {
		return listenrecordEndTime;
	}
	public void setListenrecordEndTime(Date listenrecordEndTime) {
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
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
