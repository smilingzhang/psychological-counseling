package com.util;

import java.util.List;

/**
 * 封装成Page类
 *
 */
public class Page<T> {
	public static final int PageSize = 8;
	private List<T> list;
	private long PageNum; // 当前页
	private long pageSize; // 每页大小
	private long prePageNum; // 前一页
	private long nextPageNum; // 后一页
	private long totalPageNum; // 总页数
	private long totalCount; // 总记录条数

	public Page() {}

	public Page(List<T> list, int pageNum, int pageSize) {
		this.list = list;
		PageNum = pageNum;
		this.pageSize = pageSize;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
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
		if (totalCount % pageSize == 0)
			totalPageNum = totalCount / pageSize;
		else
			totalPageNum = totalCount / pageSize + 1;
		if (PageNum > 1)
			prePageNum = PageNum - 1;
		else
			prePageNum = 1;

		if (PageNum < totalPageNum)
			nextPageNum = PageNum + 1;
		else
			nextPageNum = 1; // 循环列表页
		
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
