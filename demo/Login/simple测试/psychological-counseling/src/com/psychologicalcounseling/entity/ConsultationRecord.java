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
 *@desc:咨询记录表
 *		字段：流水号，用户ID，预约时间，开始时间，结束时间， 价格 ，订单状态：已完成/已支付/已取消
			咨询师ID，咨询方法：面对面/视频/语音，资源路径
		映射关系：单向多对一   咨询师表
				双向一对多  用户表
 *@author 段智兴
 *@date:2018年11月20日下午4:19:57
 */
@Entity
@Table(name="consultationrecord")
public class ConsultationRecord {
	private int consultationrecordId;
	private Date consultationrecordOrderTime;
	private Date consultationrecordStartTime;
	private Date consultationrecordEndTime;
	private float consultationrecordPrice;
	private int consultationrecordState;
	private int consultationrecordMethod;
	private String consultationrecordResourcePath;
	private Teacher teacher;
	private User user;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getConsultationrecordId() {
		return consultationrecordId;
	}
	public void setConsultationrecordId(int consultationrecordId) {
		this.consultationrecordId = consultationrecordId;
	}
	public Date getConsultationrecordOrderTime() {
		return consultationrecordOrderTime;
	}
	public void setConsultationrecordOrderTime(Date consultationrecordOrderTime) {
		this.consultationrecordOrderTime = consultationrecordOrderTime;
	}
	public Date getConsultationrecordStartTime() {
		return consultationrecordStartTime;
	}
	public void setConsultationrecordStartTime(Date consultationrecordStartTime) {
		this.consultationrecordStartTime = consultationrecordStartTime;
	}
	public Date getConsultationrecordEndTime() {
		return consultationrecordEndTime;
	}
	public void setConsultationrecordEndTime(Date consultationrecordEndTime) {
		this.consultationrecordEndTime = consultationrecordEndTime;
	}

	public int getConsultationrecordState() {
		return consultationrecordState;
	}
	public void setConsultationrecordState(int consultationrecordState) {
		this.consultationrecordState = consultationrecordState;
	}
	public int getConsultationrecordMethod() {
		return consultationrecordMethod;
	}
	public void setConsultationrecordMethod(int consultationrecordMethod) {
		this.consultationrecordMethod = consultationrecordMethod;
	}
	public String getConsultationrecordResourcePath() {
		return consultationrecordResourcePath;
	}
	public void setConsultationrecordResourcePath(String consultationrecordResourcePath) {
		this.consultationrecordResourcePath = consultationrecordResourcePath;
	}
	public float getConsultationrecordPrice() {
		return consultationrecordPrice;
	}
	public void setConsultationrecordPrice(float consultationrecordPrice) {
		this.consultationrecordPrice = consultationrecordPrice;
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
