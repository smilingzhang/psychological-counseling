package com.psychologicalcounseling.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 *@desc:擅长方向表
 *		字段：流水号，咨询师ID，擅长方向
 *@author 段智兴
 *@date:2018年11月20日下午4:02:11
 */
@Entity
@Table(name="goodat")
public class GoodAt {
	private int goodatId;
	private String goodAt;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getGoodatId() {
		return goodatId;
	}
	public void setGoodatId(int goodatId) {
		this.goodatId = goodatId;
	}
	public String getGoodAt() {
		return goodAt;
	}
	public void setGoodAt(String goodAt) {
		this.goodAt = goodAt;
	}
	
	
}
