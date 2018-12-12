package com.psychologicalcounseling.entity;

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
 *@String:2018年11月20日下午4:19:57
 */
@Entity
@Table(name="consultationrecord")
public class ConsultationRecord {
	//增加------------------
	public static final int TODO = 0;
	public static final int FINISHED = 1;
	public static final int CANCELED = 2;

	private int consultationrecordId;
	private String consultationrecordOrderTime;
	private String consultationrecordStartTime;
	private String consultationrecordEndTime;
	private float consultationrecordPrice;
	private int consultationrecordState;
	private int consultationrecordMethod;
	private String consultationrecordResourcePath;
	//增加----------------
	//咨询地点
	private String consultationrecordLoc;
	//咨询状态：0未咨询，1已完成，2已取消
	private int consultState;
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
	public int getConsultState() {
		return consultState;
	}
	public void setConsultState(int consultState) {
		this.consultState = consultState;
	}
	public String getConsultationrecordLoc() {
		return consultationrecordLoc;
	}
	public void setConsultationrecordLoc(String consultationrecordLoc) {
		this.consultationrecordLoc = consultationrecordLoc;
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
	@Override
	public String toString() {
		return "[startTime="+consultationrecordStartTime+"]";
	}
	
}
