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
 *@desc:用户标签�?
 *		字段：流水号，业务类型：1.咨询2.倾听3.课程4.测评，业务ID，评论内容，评价时间，星级，评价人ID
		映射关系：双向一对多  用户�?
 *@author 段智�?
 *@date:2018�?11�?20日下�?4:18:02
 */
@Entity
@Table(name="userlabel")
public class UserLabel {
	private int labelId;
	private String userLabel;
	private int userLabelGrade;
	private User user;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getLabelId() {
		return labelId;
	}
	public void setLabelId(int labelId) {
		this.labelId = labelId;
	}
	public String getUserLabel() {
		return userLabel;
	}
	public void setUserLabel(String userLabel) {
		this.userLabel = userLabel;
	}
	public int getUserLabelGrade() {
		return userLabelGrade;
	}
	public void setUserLabelGrade(int userLabelGrade) {
		this.userLabelGrade = userLabelGrade;
	}
	@ManyToOne
	@JoinColumn(name="userId")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
