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
 *@desc:课程表
 *		字段：课程ID，课程名称，咨询师ID，价格 ，折扣，介绍 ，banner图路径，学习人数，简介
 *		映射关系：单向多对一  咨询师表
 *@author XX
 *@date:2018年11月20日下午4:27:21
 */
@Entity
@Table(name="course")
public class Course {
	private int courseId;
	private String courseName;
	private float coursePrice;
	private float courseRebate;
	private String courseIntroduction;
	private String courseImgPath;
	private int courseStudentNumber;
	private String courseSynopsis;
	private Teacher teacher;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	
	public float getCoursePrice() {
		return coursePrice;
	}
	public void setCoursePrice(float coursePrice) {
		this.coursePrice = coursePrice;
	}
	public float getCourseRebate() {
		return courseRebate;
	}
	public void setCourseRebate(float courseRebate) {
		this.courseRebate = courseRebate;
	}
	
	public String getCourseIntroduction() {
		return courseIntroduction;
	}
	public void setCourseIntroduction(String courseIntroduction) {
		this.courseIntroduction = courseIntroduction;
	}
	public String getCourseImgPath() {
		return courseImgPath;
	}
	public void setCourseImgPath(String courseImgPath) {
		this.courseImgPath = courseImgPath;
	}
	public int getCourseStudentNumber() {
		return courseStudentNumber;
	}
	public void setCourseStudentNumber(int courseStudentNumber) {
		this.courseStudentNumber = courseStudentNumber;
	}
	public String getCourseSynopsis() {
		return courseSynopsis;
	}
	public void setCourseSynopsis(String courseSynopsis) {
		this.courseSynopsis = courseSynopsis;
	}
	@ManyToOne
	@JoinColumn(name="teacherId")
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
