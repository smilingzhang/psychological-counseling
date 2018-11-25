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
 *@desc:可预约时间表
 *		字段：流水号，咨询师ID，日期，以及从8.30--21.30 13个时间段
		映射关系： 双向多对一  咨询师表
 *@author 段智兴
 *@date:2018年11月20日下午4:04:27
 */
@Entity
@Table(name="teachertime")
public class TeacherTime {
	private int teachertimeId;
	private Teacher teacher;
	private Date date;
	private int time8;
	private int time9;
	private int time10;
	private int time11;
	private int time12;
	private int time13;
	private int time14;
	private int time15;
	private int time16;
	private int time17;
	private int time18;
	private int time19;
	private int time20;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getTeachertimeId() {
		return teachertimeId;
	}
	public void setTeachertimeId(int teachertimeId) {
		this.teachertimeId = teachertimeId;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getTime8() {
		return time8;
	}
	public void setTime8(int time8) {
		this.time8 = time8;
	}
	public int getTime9() {
		return time9;
	}
	public void setTime9(int time9) {
		this.time9 = time9;
	}
	public int getTime10() {
		return time10;
	}
	public void setTime10(int time10) {
		this.time10 = time10;
	}
	public int getTime11() {
		return time11;
	}
	public void setTime11(int time11) {
		this.time11 = time11;
	}
	public int getTime12() {
		return time12;
	}
	public void setTime12(int time12) {
		this.time12 = time12;
	}
	public int getTime13() {
		return time13;
	}
	public void setTime13(int time13) {
		this.time13 = time13;
	}
	public int getTime14() {
		return time14;
	}
	public void setTime14(int time14) {
		this.time14 = time14;
	}
	public int getTime15() {
		return time15;
	}
	public void setTime15(int time15) {
		this.time15 = time15;
	}
	public int getTime16() {
		return time16;
	}
	public void setTime16(int time16) {
		this.time16 = time16;
	}
	public int getTime17() {
		return time17;
	}
	public void setTime17(int time17) {
		this.time17 = time17;
	}
	public int getTime18() {
		return time18;
	}
	public void setTime18(int time18) {
		this.time18 = time18;
	}
	public int getTime19() {
		return time19;
	}
	public void setTime19(int time19) {
		this.time19 = time19;
	}
	public int getTime20() {
		return time20;
	}
	public void setTime20(int time20) {
		this.time20 = time20;
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
