/**
 * 
 */
package com.psychologicalcounseling.background.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.psychologicalcounseling.entity.ConsultationRecord;
import com.psychologicalcounseling.util.DateUtil;

/**
 *@desc:一句话被描述
 *@author 邓旸
 *@date:2018年12月27日下午4:15:37
 */
@Service
public class BackgroundService {
	
	/**
	 * 
	 *@desc:判断时间是否在范围内
	 *@param time
	 *@return
	 *@return:boolean
	 *@trhows
	 */
	public boolean checkTime(String time) {
		if(DateUtil.compare(
				time, 
				DateUtil.addDate(DateUtil.getDate(), 10*60*1000))==2
			&& DateUtil.compare(DateUtil.getDate(),
					DateUtil.addDate(time, 60*60*1000))==2) {
			return true;
		}else return false;
	}

}
