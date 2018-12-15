package com.util;

import java.util.List;



public class SetPageUtil<T> {

	public Page<T> setPage(int pageNum,int pageSize,int total,List<T> entity) {
		Page<T> page = new Page<T>(pageNum, pageSize);
		page.setList(entity);
		page.setPageNum(pageNum);
		page.setPrePageNum(pageNum - 1);
		page.setNextPageNum(pageNum + 1);
		page.setTotalCount(total);
		page.setTotalCount(total);
		return page;
	}

}
