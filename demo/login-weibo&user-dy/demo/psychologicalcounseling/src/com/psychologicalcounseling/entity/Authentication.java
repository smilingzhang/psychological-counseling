package com.psychologicalcounseling.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 *@desc:认证资质表
 *		字段：流水号，咨询师ID，资质名称
 *		
 *@author 段智兴
 *@date:2018年11月20日下午3:50:15
 */
@Entity
@Table(name="authentication")
public class Authentication {
	private int authenticationId;
	private String authenticationAptitudeName;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getAuthenticationId() {
		return authenticationId;
	}
	public void setAuthenticationId(int authenticationId) {
		this.authenticationId = authenticationId;
	}
	public String getAuthenticationAptitudeName() {
		return authenticationAptitudeName;
	}
	public void setAuthenticationAptitudeName(String authenticationAptitudeName) {
		this.authenticationAptitudeName = authenticationAptitudeName;
	}
	
	
	
	
	
	
}
