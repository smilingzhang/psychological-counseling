package com.psychologicalcounseling.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * 
 *@desc:业务类别表
 *		字段：流水号，业务类型：1.咨询2.课程3.测评4.动态5.文章，业务ID，类别ID
 *		映射关系：单向多对一  类别表
 *@author 段智兴
 *@date:2018年11月20日下午4:34:57
 */
@Entity
@Table(name="businesstype")
public class BusinessType {
	private int businesstypeId;
	private int businesstypeWorkType;
	private int businesstypeWorkId;
	private TypeTable typeTable;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getBusinesstypeId() {
		return businesstypeId;
	}
	public void setBusinesstypeId(int businesstypeId) {
		this.businesstypeId = businesstypeId;
	}
	public int getBusinesstypeWorkType() {
		return businesstypeWorkType;
	}
	public void setBusinesstypeWorkType(int businesstypeWorkType) {
		this.businesstypeWorkType = businesstypeWorkType;
	}
	public int getBusinesstypeWorkId() {
		return businesstypeWorkId;
	}
	public void setBusinesstypeWorkId(int businesstypeWorkId) {
		this.businesstypeWorkId = businesstypeWorkId;
	}
	@ManyToOne
	@JoinColumn(name="typetableId")
	public TypeTable getTypeTable() {
		return typeTable;
	}
	public void setTypeTable(TypeTable typeTable) {
		this.typeTable = typeTable;
	}
	
	
	
	
}
