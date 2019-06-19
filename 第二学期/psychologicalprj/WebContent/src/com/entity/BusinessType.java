package com.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
/**
 * 
 *@desc:业务类别�?
 *		字段：流水号，业务类型：1.咨询2.课程3.测评4.动�??5.文章，业务ID，类别ID
 *		映射关系：单向多对一  类别�?
 *@author 段智�?
 *@date:2018�?11�?20日下�?4:34:57
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
	@NotFound(action=NotFoundAction.IGNORE) 
	public TypeTable getTypeTable() {
		return typeTable;
	}
	public void setTypeTable(TypeTable typeTable) {
		this.typeTable = typeTable;
	}
	
	
	
	
}
