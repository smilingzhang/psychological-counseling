package com.entity;

import java.io.Serializable;

public class ConsulterIndexSearch implements Serializable{
	/**
	 *@desc:防止异常
	 *@Fields:serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private String teacherId;
	private String teacherName;
	private String teacherIntroduction;
	private String teacherApitude;
	private String goodats;
	private String teacherHeaderUrl;
	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public String getTeacherIntroduction() {
		return teacherIntroduction;
	}
	public void setTeacherIntroduction(String teacherIntroduction) {
		this.teacherIntroduction = teacherIntroduction;
	}
	public String getTeacherApitude() {
		return teacherApitude;
	}
	public void setTeacherApitude(String teacherApitude) {
		this.teacherApitude = teacherApitude;
	}
	public String getGoodats() {
		return goodats;
	}
	public void setGoodats(String goodats) {
		this.goodats = goodats;
	}
	public String getTeacherHeaderUrl() {
		return teacherHeaderUrl;
	}
	public void setTeacherHeaderUrl(String teacherHeaderUrl) {
		this.teacherHeaderUrl = teacherHeaderUrl;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
