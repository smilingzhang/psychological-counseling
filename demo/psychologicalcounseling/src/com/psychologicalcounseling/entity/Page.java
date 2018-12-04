package com.psychologicalcounseling.entity;

import java.util.List;

public class Page<T> {
	private List<T> list;
	private int prePageNum;
	private int nextPageNum;
	private int totalCount;     
	private int totalPageNum;   
	private int pageSize;     
	private int pageNum;        
	
	public Page() {};

	public Page(int pageNum,int pageSize) {
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
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
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		if(totalCount%pageSize==0) {
			totalPageNum = totalCount/pageSize;
		}else {
			totalPageNum = totalCount/pageSize+1;
		}
		if(pageNum>1) {
			prePageNum = pageNum-1;
		}else {
			prePageNum = 1;
		}
		if(pageNum<totalPageNum) {
			nextPageNum = pageNum+1;
		}else {
			nextPageNum = totalPageNum;
		}
	}
	public int getTotalPageNum() {
		return totalPageNum;
	}
	public void setTotalPageNum(int totalPagenum) {
		this.totalPageNum = totalPagenum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pagenum) {
		this.pageNum = pagenum;
	}
}
