package com.psychologicalcounseling.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 *@desc:类别表
 *		字段：类别ID，类别名称
 *@author 段智兴
 *@date:2018年11月20日下午4:34:19
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
	public void setTypetableId(int typetableId) {
		this.typetableId = typetableId;
	}
	public String getTypetableName() {
		return typetableName;
	}
	public void setTypetableName(String typetableName) {
		this.typetableName = typetableName;
	}
	
	
}
