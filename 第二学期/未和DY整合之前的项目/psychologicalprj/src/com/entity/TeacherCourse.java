package com.entity;

import java.util.List;

public class TeacherCourse {
	//课程类型
	private String courseType;
	//课程
	private Course course;
	//浏览人数
	private int lookNum;
	//章节数
	private int parentNum;
	//课时数
	private int courseTimeNum;
	
	
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	public int getLookNum() {
		return lookNum;
	}
	public void setLookNum(int lookNum) {
		this.lookNum = lookNum;
	}
	public int getParentNum() {
		return parentNum;
	}
	public void setParentNum(int parentNum) {
		this.parentNum = parentNum;
	}
	public int getCourseTimeNum() {
		return courseTimeNum;
	}
	public void setCourseTimeNum(int courseTimeNum) {
		this.courseTimeNum = courseTimeNum;
	}
	
}
