package com.psychologicalcounseling.entity;

import java.util.List;


public class Page<T> {
	private List<T> teacher;
	private int prePageNum;// 上一页
	private int nextPageNum;// 下一页
	private int pageNum;// 当前页
	private int totalCount;// 数据总条数
	private int pageSize;// 每页有多少数据页面大小
	private int totalPageCount;// 总页数

	public Page(int pageNum, int pageSize) {
		// TODO Auto-generated constructor stub
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}
	public Page(int pageNum, int pageSize, int totalCount, List<T> list) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.setTotalCount(totalCount);
		this.teacher = list;
	}


	public List<T> getTeacher() {
		return teacher;
	}
	public void setTeacher(List<T> teacher) {
		this.teacher = teacher;
	}
	public int getPrePageNum() {
		return prePageNum;
	}

	public void setPrePageNum(int prePageNum) {
		this.prePageNum = prePageNum;
	}

	public int getNextPageNum() {
		return nextPageNum;
	}

	public void setNextPageNum(int nextPageNum) {
		this.nextPageNum = nextPageNum;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalCount) {
		if (totalCount % pageSize == 0) {
			this.totalPageCount = totalCount / pageSize;
		} else {
			this.totalPageCount = (totalCount / pageSize) + 1;
		}
	}

}
