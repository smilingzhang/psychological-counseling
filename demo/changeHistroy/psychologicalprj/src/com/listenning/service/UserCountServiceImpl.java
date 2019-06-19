package com.listenning.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.ListenRecord;
import com.entity.UserCount;
import com.listenning.dao.ListenRecordDaoImpl;
import com.listenning.dao.UserCountDaoImpl;


@Service
@Transactional
public class UserCountServiceImpl {

	@Resource
	private UserCountDaoImpl userCountDaoImpl;
	private Logger logger = Logger.getLogger(ListenRecordServiceImpl.class);

	public void addCount() throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");  
		String date = simpleDateFormat.format(new Date());  
		
		
		userCountDaoImpl.updateUserCount(date);
	}
	public List<UserCount> selectUserCount() throws ParseException {
		return userCountDaoImpl.selectUserCount();
		
	}

}
