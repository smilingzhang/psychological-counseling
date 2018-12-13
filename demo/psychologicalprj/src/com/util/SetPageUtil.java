package com.util;

import java.util.List;

import com.entity.Page;

public class SetPageUtil<T> {

	public Page<T> setPage(int pageNum,int pageSize,int total,List<T> entity) {
		Page<T> page = new Page<T>(pageNum, pageSize);
		page.setTeacher(entity);
		page.setPageNum(pageNum);
		page.setPrePageNum(pageNum - 1);
		page.setNextPageNum(pageNum + 1);
		page.setTotalCount(total);
		page.setTotalPageCount(total);
		return page;
	}

}
