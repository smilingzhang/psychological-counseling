package com.psychologicalcounseling.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 *@desc:咨询对象表
 *		字段：流水号，咨询师ID，咨询对象
 *@author 段智兴
 *@date:2018年11月20日下午4:03:36
 */
@Entity
@Table(name="consultobject")
public class ConsultObject {
	private int consultobjectId;
	private String consultObject;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getConsultobjectId() {
		return consultobjectId;
	}
	public void setConsultobjectId(int consultobjectId) {
		this.consultobjectId = consultobjectId;
	}
	public String getConsultObject() {
		return consultObject;
	}
	public void setConsultObject(String consultObject) {
		this.consultObject = consultObject;
	}
	
	
	
}
