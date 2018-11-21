package com.psychologicalcounseling.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * 
 *@desc:课程目录表
 *		字段：目录id，课程ID，父id，目录名，资源路径
 *		映射关系：双向一对多  自连接
 *@author 段智兴
 *@date:2018年11月20日下午4:29:22
 */
@Entity
@Table(name="coursecatalog")
public class CourseCatalog {
	private int coursecatalogId;
	private int courseId;
	private String coursecatalogName;
	private String coursecatalogResourcePath;
	private CourseCatalog parentCourseCatalog;
	private Set<CourseCatalog> courseCatalogs = new HashSet<CourseCatalog>();
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getCoursecatalogId() {
		return coursecatalogId;
	}
	public void setCoursecatalogId(int coursecatalogId) {
		this.coursecatalogId = coursecatalogId;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCoursecatalogName() {
		return coursecatalogName;
	}
	public void setCoursecatalogName(String coursecatalogName) {
		this.coursecatalogName = coursecatalogName;
	}
	public String getCoursecatalogResourcePath() {
		return coursecatalogResourcePath;
	}
	public void setCoursecatalogResourcePath(String coursecatalogResourcePath) {
		this.coursecatalogResourcePath = coursecatalogResourcePath;
	}
	

	
	@OneToMany(mappedBy="parentCourseCatalog",targetEntity=CourseCatalog.class,cascade=CascadeType.ALL)
	public Set<CourseCatalog> getCourseCatalogs() {
		return courseCatalogs;
	}
	public void setCourseCatalogs(Set<CourseCatalog> courseCatalogs) {
		this.courseCatalogs = courseCatalogs;
	}
	@ManyToOne
	@JoinColumn(name="coursecatalogParentId")
	public CourseCatalog getParentCourseCatalog() {
		return parentCourseCatalog;
	}
	public void setParentCourseCatalog(CourseCatalog parentCourseCatalog) {
		this.parentCourseCatalog = parentCourseCatalog;
	}
	
	
	
}
