package com.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usercount")
public class UserCount {
	//date为当天日期    count为当天点击总量
	
	private String date;
	private Integer count;
	
	public UserCount() {
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public String getDate() {
		return date;
	}
	public void setDate(String date)  {
		
		 this.date = date;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}

	
	
}
