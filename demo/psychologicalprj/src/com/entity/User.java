package com.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 
 *@desc:用户�?
 *	字段:用户ID,头像路径,昵称,性别,真实姓名,身份证号,个�?�签�?,手机号（作为账号�?,密码,注册时间,
		身份�?1.客户2.咨询�?3.倾听�?,城市,邮箱
	映射关系：双向一对多  用户标签和咨询记�?
 *@author 段智�?
 *@date:2018�?11�?20日下�?3:32:27
 */
@Entity
@Table(name="user")
public class User {
	public static final int IDENTITY_USER = 1;
	public static final int IDENTITY_CONSULTER = 2;
	public static final int IDENTITY_LISTENER=3;
	private String userProvince;
	private String alipayUserId;
	private String weiboUid;
	private Integer userId;
	private String userHeadPath;
	private String userNickName;
	private String userSex;
	private String userRealName;
	private String userIdNumber;
	private String userAutograph;
	private String userPhone;
	private String userPassword;
	private Date userRegistTime;
	private Integer userIdentity;
	private String userCity;
	private String userEmail;
	private Set<UserLabel> userLabels= new HashSet<UserLabel>();
	private Set<ConsultationRecord> consultationRecords = new HashSet<ConsultationRecord>();
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserHeadPath() {
		return userHeadPath;
	}
	public void setUserHeadPath(String userHeadPath) {
		this.userHeadPath = userHeadPath;
	}
	public String getUserNickName() {
		return userNickName;
	}
	public void setUserNickName(String userNickName) {
		this.userNickName = userNickName;
	}
	public String getUserSex() {
		return userSex;
	}
	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}
	public String getUserRealName() {
		return userRealName;
	}
	public void setUserRealName(String userRealName) {
		this.userRealName = userRealName;
	}
	public String getUserIdNumber() {
		return userIdNumber;
	}
	public void setUserIdNumber(String userIdNumber) {
		this.userIdNumber = userIdNumber;
	}
	public String getUserAutograph() {
		return userAutograph;
	}
	public void setUserAutograph(String userAutograph) {
		this.userAutograph = userAutograph;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Date getUserRegistTime() {
		return userRegistTime;
	}
	public void setUserRegistTime(Date userRegistTime) {
		this.userRegistTime = userRegistTime;
	}
	public Integer getUserIdentity() {
		return userIdentity;
	}
	public void setUserIdentity(int userIdentity) {
		this.userIdentity = userIdentity;
	}
	public String getUserCity() {
		return userCity;
	}
	public void setUserCity(String userCity) {
		this.userCity = userCity;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	@OneToMany(mappedBy="user",targetEntity=UserLabel.class,cascade=CascadeType.ALL)
	public Set<UserLabel> getUserLabels() {
		return userLabels;
	}
	public void setUserLabels(Set<UserLabel> userLabels) {
		this.userLabels = userLabels;
	}
	@OneToMany(mappedBy="user",targetEntity=ConsultationRecord.class,cascade=CascadeType.ALL)
	public Set<ConsultationRecord> getConsultationRecords() {
		return consultationRecords;
	}
	public void setConsultationRecords(Set<ConsultationRecord> consultationRecords) {
		this.consultationRecords = consultationRecords;
	}
	public String getUserProvince() {
		return userProvince;
	}
	public void setUserProvince(String userProvince) {
		this.userProvince = userProvince;
	}
	public String getAlipayUserId() {
		return alipayUserId;
	}
	public void setAlipayUserId(String alipayUserId) {
		this.alipayUserId = alipayUserId;
	}
	public String getWeiboUid() {
		return weiboUid;
	}
	public void setWeiboUid(String weiboUid) {
		this.weiboUid = weiboUid;
	}
	public static int getIdentityUser() {
		return IDENTITY_USER;
	}
	public static int getIdentityConsulter() {
		return IDENTITY_CONSULTER;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public void setUserIdentity(Integer userIdentity) {
		this.userIdentity = userIdentity;
	}
	
	public String toString() {
		return "uaserName is"+userRealName;
	}
	
}
