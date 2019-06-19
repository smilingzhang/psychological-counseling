package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 *@desc:类别�?
 *		字段：类别ID，类别名�?
 *@author 段智�?
 *@date:2018�?11�?20日下�?4:34:19
 */
@Entity
@Table(name="typetable")
public class TypeTable {
	private int typetableId;
	private String typetableName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getTypetableId() {
		return typetableId;
	}
	public String getTypetableName() {
		return typetableName;
	}
	public void setTypetableId(int typetableId) {
		this.typetableId = typetableId;
	}
	public void setTypetableName(String typetableName) {
		this.typetableName = typetableName;
	}
	
	
}
