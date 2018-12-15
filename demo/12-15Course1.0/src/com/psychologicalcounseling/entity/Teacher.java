package com.psychologicalcounseling.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * 
 *@desc:咨询师信息表
 *	字段： 咨询师ID（不自增，引用），从业年限，好评率， 咨询价格，详细介绍，倾听时长
 *	映射关系：单向一对多：认证咨询表，擅长方向表，咨询对象表
 *			双向一对多：可预约时间表
 *			单向一对一：用户表
 *@author 段智兴
 *@date:2018年11月20日下午3:45:55
 */

@Entity
@Table(name="teacher")
public class Teacher {
	private int teacherId;
	private int teacherWorkTime;
	private float teacherPraiseRate;
	private float teacherPrice;
	private String teacherIntroduction;
	private int teacherListenTime;
	private Set<Authentication> authentications = new HashSet<Authentication>();
	private Set<GoodAt> goodats = new HashSet<GoodAt>();
	private Set<ConsultObject> consultobjects = new HashSet<ConsultObject>();
	private Set<TeacherTime>teacherTimes = new HashSet<TeacherTime>();
	private User user;
	
	
	@Id
	@GenericGenerator(name="myassigned",strategy="assigned")
	@GeneratedValue(generator="myassigned")
	public int getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	public int getTeacherWorkTime() {
		return teacherWorkTime;
	}
	public void setTeacherWorkTime(int teacherWorkTime) {
		this.teacherWorkTime = teacherWorkTime;
	}
	public float getTeacherPraiseRate() {
		return teacherPraiseRate;
	}
	public void setTeacherPraiseRate(float teacherPraiseRate) {
		this.teacherPraiseRate = teacherPraiseRate;
	}
	public float getTeacherPrice() {
		return teacherPrice;
	}
	public void setTeacherPrice(float teacherPrice) {
		this.teacherPrice = teacherPrice;
	}
	
	public String getTeacherIntroduction() {
		return teacherIntroduction;
	}
	public void setTeacherIntroduction(String teacherIntroduction) {
		this.teacherIntroduction = teacherIntroduction;
	}
	public int getTeacherListenTime() {
		return teacherListenTime;
	}
	public void setTeacherListenTime(int teacherListenTime) {
		this.teacherListenTime = teacherListenTime;
	}
	@OneToMany(targetEntity=Authentication.class,cascade=CascadeType.ALL)
	@JoinColumn(name="teacherId")
	public Set<Authentication> getAuthentications() {
		return authentications;
	}
	public void setAuthentications(Set<Authentication> authentications) {
		this.authentications = authentications;
	}
	@OneToMany(targetEntity=GoodAt.class,cascade=CascadeType.ALL)
	@JoinColumn(name="teacherId")
	public Set<GoodAt> getGoodats() {
		return goodats;
	}
	public void setGoodats(Set<GoodAt> goodats) {
		this.goodats = goodats;
	}
	@OneToMany(targetEntity=ConsultObject.class,cascade=CascadeType.ALL)
	@JoinColumn(name="teacherId")
	public Set<ConsultObject> getConsultobjects() {
		return consultobjects;
	}
	public void setConsultobjects(Set<ConsultObject> consultobjects) {
		this.consultobjects = consultobjects;
	}
	@OneToMany(mappedBy="teacher",targetEntity=TeacherTime.class,cascade=CascadeType.ALL)
	public Set<TeacherTime> getTeacherTimes() {
		return teacherTimes;
	}
	public void setTeacherTimes(Set<TeacherTime> teacherTimes) {
		this.teacherTimes = teacherTimes;
	}
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="teacherId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	
}
