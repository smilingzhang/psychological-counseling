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
 *@desc:课程学习记录�?
 *		字段：流水号，用户ID，课程ID，是否看完：1.�?2.否，�?始看的时间，看到的位�?
 *		映射关系：单向多对一  用户表和课程�?
 *@author 段智�?
 *@date:2018�?11�?20日下�?4:32:00
 */
@Entity
@Table(name="courserecord")
public class CourseRecord {
	private int courserecordId;
	private int courserecordIsFinish;
	private Date courserecordStartTime;
	private String courserecordStopPosition;
	private User user;
	private Course course;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCourserecordId() {
		return courserecordId;
	}
	public void setCourserecordId(int courserecordId) {
		this.courserecordId = courserecordId;
	}

	public int getCourserecordIsFinish() {
		return courserecordIsFinish;
	}
	public void setCourserecordIsFinish(int courserecordIsFinish) {
		this.courserecordIsFinish = courserecordIsFinish;
	}
	public Date getCourserecordStartTime() {
		return courserecordStartTime;
	}
	public void setCourserecordStartTime(Date courserecordStartTime) {
		this.courserecordStartTime = courserecordStartTime;
	}
	public String getCourserecordStopPosition() {
		return courserecordStopPosition;
	}
	public void setCourserecordStopPosition(String courserecordStopPosition) {
		this.courserecordStopPosition = courserecordStopPosition;
	}
	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@ManyToOne
	@JoinColumn(name="courseId")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
}
