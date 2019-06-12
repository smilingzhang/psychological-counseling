package com.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 
 *@desc:动�?�表
 *		字段：动态ID，发表时间，标题，正文，图片路径，视频资源路径，活动报名链接
 *@author 段智�?
 *@date:2018�?11�?20日下�?4:37:50
 */
@Entity
@Table(name="dynamic")
public class Dynamic {
	private int dynamicId;
	private Date dynamicPublishTime;
	private String dynamicTitle;
	private String dynamicContent;
	private String dynamicImgPath;
	private String dynamicResourcePath;
	private String dynamicLink;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getDynamicId() {
		return dynamicId;
	}
	public void setDynamicId(int dynamicId) {
		this.dynamicId = dynamicId;
	}
	public Date getDynamicPublishTime() {
		return dynamicPublishTime;
	}
	public void setDynamicPublishTime(Date dynamicPublishTime) {
		this.dynamicPublishTime = dynamicPublishTime;
	}
	public String getDynamicTitle() {
		return dynamicTitle;
	}
	public void setDynamicTitle(String dynamicTitle) {
		this.dynamicTitle = dynamicTitle;
	}
	
	public String getDynamicContent() {
		return dynamicContent;
	}
	public void setDynamicContent(String dynamicContent) {
		this.dynamicContent = dynamicContent;
	}
	public String getDynamicImgPath() {
		return dynamicImgPath;
	}
	public void setDynamicImgPath(String dynamicImgPath) {
		this.dynamicImgPath = dynamicImgPath;
	}
	public String getDynamicResourcePath() {
		return dynamicResourcePath;
	}
	public void setDynamicResourcePath(String dynamicResourcePath) {
		this.dynamicResourcePath = dynamicResourcePath;
	}
	public String getDynamicLink() {
		return dynamicLink;
	}
	public void setDynamicLink(String dynamicLink) {
		this.dynamicLink = dynamicLink;
	}
	
	
}
