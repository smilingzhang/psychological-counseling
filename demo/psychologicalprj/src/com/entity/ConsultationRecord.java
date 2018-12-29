package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 *@desc:咨询记录�?
 *		字段：流水号，用户ID，预约时间，�?始时间，结束时间�? 支付金额 ，订单状态：已完�?/已支�?/已取�?
			咨询师ID，咨询方法：面对�?/视频/语音，资源路�?
		映射关系：单向多对一   咨询师表
				双向�?对多  用户�?
 *@author 段智�?
 *@date:2018�?11�?20日下�?4:19:57
 */
@Entity
@Table(name="consultationrecord")
public class ConsultationRecord {
	public static final String TODO = "未咨询";
	public static final String FINISHED = "已咨询";
	public static final String CANCELED = "已取消";
	@Override
	public String toString() {
		return "ConsultationRecord [consultationrecordId=" + consultationrecordId + ", randomNum=" + randomNum
				+ ", consultationrecordOrderTime=" + consultationrecordOrderTime + ", consultationrecordStartTime="
				+ consultationrecordStartTime + ", consultationrecordEndTime=" + consultationrecordEndTime + "]";
	}
	private int consultationrecordId;
	private String randomNum;
	private String consultationrecordOrderTime;
	private String consultationrecordStartTime;
	private String consultationrecordEndTime;
	private float consultationrecordPrice;
	private String consultationrecordState;
	private String consultationrecordMethod;
	private String consultationrecordResourcePath;
	private String consultState;
	private Teacher teacher;
	private User user;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getConsultationrecordId() {
		return consultationrecordId;
	}
	public void setConsultationrecordId(int consultationrecordId) {
		this.consultationrecordId=consultationrecordId;
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
	public String getConsultationrecordState() {
		return consultationrecordState;
	}
	public void setConsultationrecordState(String consultationrecordState) {
		this.consultationrecordState = consultationrecordState;
	}
	public String getConsultationrecordMethod() {
		return consultationrecordMethod;
	}
	public void setConsultationrecordMethod(String consultationrecordMethod) {
		this.consultationrecordMethod = consultationrecordMethod;
	}
	public String getConsultState() {
		return consultState;
	}
	public void setConsultState(String consultState) {
		this.consultState = consultState;
	}
	public String getConsultationrecordOrderTime() {
		return consultationrecordOrderTime;
	}
	public void setConsultationrecordOrderTime(String consultationrecordOrderTime) {
		this.consultationrecordOrderTime = consultationrecordOrderTime;
	}
	public String getConsultationrecordStartTime() {
		return consultationrecordStartTime;
	}
	public void setConsultationrecordStartTime(String consultationrecordStartTime) {
		this.consultationrecordStartTime = consultationrecordStartTime;
	}
	public String getConsultationrecordEndTime() {
		return consultationrecordEndTime;
	}
	public void setConsultationrecordEndTime(String consultationrecordEndTime) {
		this.consultationrecordEndTime = consultationrecordEndTime;
	}
	public String getRandomNum() {
		return randomNum;
	}
	public void setRandomNum(String randomNum) {
		this.randomNum = randomNum;
	}	
}
