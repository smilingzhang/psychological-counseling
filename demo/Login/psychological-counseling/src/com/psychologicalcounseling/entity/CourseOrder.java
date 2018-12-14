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
 *@desc:课程订单表
 *		字段：流水号，课程ID，用户ID，购买时间，成交价格
 *		映射关系：单向多对一  用户表和课程表
 *@author 段智兴
 *@date:2018年11月20日下午4:30:41
 */
@Entity
@Table(name="courseorder")
public class CourseOrder {
	private int courseorderId;
	private Date courseorderBuyTime;
	private float courseorderPrice;
	private String orderId4Alipay;
	private User user;
	private Course course;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCourseorderId() {
		return courseorderId;
	}
	public void setCourseorderId(int courseorderId) {
		this.courseorderId = courseorderId;
	}
	public Date getCourseorderBuyTime() {
		return courseorderBuyTime;
	}
	public void setCourseorderBuyTime(Date courseorderBuyTime) {
		this.courseorderBuyTime = courseorderBuyTime;
	}
	public float getCourseorderPrice() {
		return courseorderPrice;
	}
	public void setCourseorderPrice(float courseorderPrice) {
		this.courseorderPrice = courseorderPrice;
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
