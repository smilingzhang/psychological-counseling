package com.psychologicalcounseling.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="collection")
public class Collection {
	private int CollectionId;
	private int uesrId;
	private Course course;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCollectionId() {
		return CollectionId;
	}
	public void setCollectionId(int collectionId) {
		CollectionId = collectionId;
	}
	public int getUesrId() {
		return uesrId;
	}
	public void setUesrId(int uesrId) {
		this.uesrId = uesrId;
	}
	@ManyToOne
	@JoinColumn(name="courseId")
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
	
	
}
