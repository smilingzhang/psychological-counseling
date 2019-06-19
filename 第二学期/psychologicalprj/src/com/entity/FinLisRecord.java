package com.entity;

public class FinLisRecord {
	private ListenRecord listenRecord;
	private Long listenTime;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ListenRecord getListenRecord() {
		return listenRecord;
	}
	public void setListenRecord(ListenRecord listenRecord) {
		this.listenRecord = listenRecord;
	}
	public Long getListenTime() {
		return listenTime;
	}
	public void setListenTime(Long listenTime) {
		this.listenTime = listenTime;
	}
	
	
}
