package com.entity;

import java.io.Serializable;

/**
 * 
 *@desc:课程的索引结果集
 *@author chunhui
 *@date:Dec 12, 2018 8:21:44 PM
 */
public class CourseIndexSearcher implements Serializable{

	/**
	 *@desc:防止异常
	 *@Fields:serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	private String courseId;
	private String courseTitle;
	private String courseSynopsis;
	private String courseIntroduction;
	private String teacherName;
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getCourseSynopsis() {
		return courseSynopsis;
	}
	public void setCourseSynopsis(String courseSynopsis) {
		this.courseSynopsis = courseSynopsis;
	}
	public String getCourseIntroduction() {
		return courseIntroduction;
	}
	public void setCourseIntroduction(String courseIntroduction) {
		this.courseIntroduction = courseIntroduction;
	}
	public String getTeacherName() {
		return teacherName;
	}
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
