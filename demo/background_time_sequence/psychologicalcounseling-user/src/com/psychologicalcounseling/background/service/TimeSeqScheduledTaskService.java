/**
 * 
 */
package com.psychologicalcounseling.background.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.psychologicalcounseling.background.dao.TimeSeqScheduledTaskDao;
import com.psychologicalcounseling.entity.ListenRecord;

/**
 *@desc:一句话被描述
 *@author 邓旸
 *@date:2019年6月6日上午10:35:03
 */

@Service
@Transactional(readOnly=true)
public class TimeSeqScheduledTaskService {
	@Resource
	private TimeSeqScheduledTaskDao timeSeqScheduledTaskDao;
	
	public List<ListenRecord> getTodayListenRecord() throws Exception{
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sf.format(new Date());
		System.out.println(date);
		return timeSeqScheduledTaskDao.getListenRecord(date);
	}
}
