package com.psychologicalcounseling.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
/**
 * 
 *@desc:咨询师信息表
 *	字段�? 咨询师ID（不自增，引用），从业年限，好评率， 咨询价格，详细介绍，倾听时长
 *	映射关系：
 *			双向�?对多：可预约时间�?
 *			单向�?对一：用户表
 *@author 段智�?
 *@date:2018�?11�?20日下�?3:45:55
 */

@Entity
@Table(name="teacher")
public class Teacher {
	private int teacherId;
	private int teacherWorkTime;
	private float teacherPraiseRate;
	private float teacherPrice;
	private String teacherIntroduction;
	//单位为分钟
	private int teacherListenTime;
	private String authenticationAptitudeName ;
	private String goodats;
	private List<TeacherTime> teacherTimes = new ArrayList<>();
	private User user;
	private int age;
	private int canListen;
	
	
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
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="teacherId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@OneToMany(mappedBy="teacher",targetEntity=TeacherTime.class,cascade=CascadeType.ALL)
	public List<TeacherTime> getTeacherTimes() {
		return teacherTimes;
	}
	public void setTeacherTimes(List<TeacherTime> teacherTimes) {
		this.teacherTimes = teacherTimes;
	}
	public String getAuthenticationAptitudeName() {
		return authenticationAptitudeName;
	}
	public void setAuthenticationAptitudeName(String authenticationAptitudeName) {
		this.authenticationAptitudeName = authenticationAptitudeName;
	}
	public String getGoodats() {
		return goodats;
	}
	public void setGoodats(String goodats) {
		this.goodats = goodats;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCanListen() {
		return canListen;
	}
	public void setCanListen(int canListen) {
		this.canListen = canListen;
	}
	
	
}
