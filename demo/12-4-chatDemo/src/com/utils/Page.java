package com.utils;

import java.util.List;

import com.entity.Teacher;

/**
 * 封装成Page类
 *
 */
public class Page {

	private List<Teacher> list;
	private long PageNum;
	private long pageSize;
	private long prePageNum;
	private long nextPageNum;
	private long totalPageNum;
	private long totalCount;
	
	public Page(){}
	
	
	public Page(List<Teacher> list, int pageNum, int pageSize) {
		this.list = list;
		PageNum = pageNum;
		this.pageSize = pageSize;
	}


	public List<Teacher> getList() {
		return list;
	}
	
	public void setList(List<Teacher> list) {
		this.list = list;
	}
	public long getPageNum() {
		return PageNum;
	}


	public void setPageNum(long pageNum) {
		PageNum = pageNum;
	}


	public long getPrePageNum() {
		return prePageNum;
	}


	public void setPrePageNum(long prePageNum) {
		this.prePageNum = prePageNum;
	}


	public long getNextPageNum() {
		return nextPageNum;
	}


	public void setNextPageNum(long nextPageNum) {
		this.nextPageNum = nextPageNum;
	}


	public long getTotalPageNum() {
		return totalPageNum;
	}


	public void setTotalPageNum(long totalPageNum) {
		this.totalPageNum = totalPageNum;
	}


	public long getTotalCount() {
		return totalCount;
	}


	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
		if(totalCount%pageSize==0)
			totalPageNum=totalCount/pageSize;
		else
			totalPageNum=totalCount/pageSize+1;
		
		if(PageNum>1)
			prePageNum=PageNum-1;
		else
			prePageNum=1;
		
		if(PageNum<totalPageNum)
			nextPageNum=PageNum+1;
		else
			nextPageNum=totalPageNum;
	}
	public long getPageSize() {
		return pageSize;
	}
	public void setPageSize(long pageSize) {
		this.pageSize = pageSize;
	}


	@Override
	public String toString() {
		return "Page [list=" + list + ", PageNum=" + PageNum + ", pageSize=" + pageSize + ", prePageNum=" + prePageNum
				+ ", nextPageNum=" + nextPageNum + ", totalPageNum=" + totalPageNum + ", totalCount=" + totalCount
				+ "]";
	}
	
}
