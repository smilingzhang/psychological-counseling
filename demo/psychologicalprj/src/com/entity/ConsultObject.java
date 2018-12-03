package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 *@desc:咨询对象�?
 *		字段：流水号，咨询师ID，咨询对�?
 *@author 段智�?
 *@date:2018�?11�?20日下�?4:03:36
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
