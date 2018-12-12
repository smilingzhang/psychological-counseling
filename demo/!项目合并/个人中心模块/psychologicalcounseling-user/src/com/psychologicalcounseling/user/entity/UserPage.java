/**
 * 
 */
package com.psychologicalcounseling.user.entity;

import java.util.List;

import com.psychologicalcounseling.entity.Page;

/**
 *@desc:分页类，只要调用setPage(int,int,long)一个方法初始化即可
 *@author 邓旸
 *@date:2018年12月10日上午8:44:03
 */
public class UserPage{
	private int prePageNum;// 上一页
	private int nextPageNum;// 下一页
	private int pageNum;// 当前页
	private long totalCount;// 数据总条数
	private int pageSize;// 每页有多少数据页面大小
	private int totalPageCount;// 总页数
	
	/**
	 */
	public UserPage() {
	}
	
	public UserPage(int pageNum, int pageSize) {
		this.setPageNum(pageNum);
		this.setPageSize(pageSize);
	}
	
	/**
	 * 
	 *@desc:设置分页
	 *@param pageNum
	 *@param pageSize
	 *@return:void
	 *@trhows
	 */
	public void setPage(int pageNum, int pageSize, long totalCount) {
		this.setPageNum(pageNum);
		this.setPageSize(pageSize);
		this.setPrePageNum(pageNum-1);
		this.setNextPageNum(pageNum+1);
		this.setTotalCount(totalCount);
		this.setTotalPageCount();
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

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
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

	private void setTotalPageCount() {
		if (totalCount % pageSize == 0) {
			this.totalPageCount = (int) (totalCount / pageSize);
		} else {
			this.totalPageCount = (int) ((totalCount / pageSize) + 1);
		}
	}
	
	/**
	 * 
	 *@desc: 获取某一页的第一个元素编号
	 *@return:int
	 *@trhows
	 */
	public int getStartIndex() {
		return pageSize*(pageNum-1)+1;
	}
	
	/**
	 * 
	 *@desc: 获取某一页的第一个元素编号（指定页码）
	 *@param pageNum
	 *@return
	 *@return:int
	 *@trhows
	 */
	public int getStartIndex(int pageNum) {
		return pageSize*(pageNum-1);
	}
	
	/**
	 * 
	 *@desc:获取某一页的最后一个元素编号
	 *@return
	 *@return:int
	 *@trhows
	 */
	public int getEndIndex() {
		return pageSize*pageNum-1;
	}
	/**
	 * 
	 *@desc: 获取某一页的最后一个元素编号（指定页码）
	 *@param pageNum
	 *@return
	 *@return:int
	 *@trhows
	 */
	public int getEndIndex(int pageNum) {
		return pageSize*pageNum-1;
	}
}
