package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.ListenRecordDaoImpl;
import com.entity.ListenRecord;

@Service
@Transactional
public class ListenRecordServiceImpl {

	@Resource
	private ListenRecordDaoImpl listenRecordDaoImpl;

	public List<ListenRecord> listAllUnusedListenRecords() {
		return listenRecordDaoImpl.findAllUnusedListenRecords();
	}

	public List<ListenRecord> listUnusedListenRecordsById(int id, int identity) {
		List<ListenRecord> listenRecords;
		if (identity == 1) {
			System.out.println("I am a common user...");
			listenRecords = listenRecordDaoImpl.findUnusedListenRecordsByUserId(id);
		} else {
			System.out.println("I am a common teacher...");
			listenRecords = listenRecordDaoImpl.findUnusedListenRecordsByTeacherId(id);
		}
		return listenRecords;
	}

	public List<ListenRecord> listUnusedListenRecordsByTeacherId(int id) {
		return listenRecordDaoImpl.findUnusedListenRecordsByTeacherId(id);
	}

	public List<ListenRecord> listUnusedListenRecordsByUserId(int id) {
		return listenRecordDaoImpl.findUnusedListenRecordsByUserId(id);
	}

	// 通过咨询订单Id 将其状态改为已咨询。
	public void changeListenStateToDoneById(int listenrecordId) {
		listenRecordDaoImpl.updateListenRecordById(listenrecordId);
	}

	public ListenRecord searchListenRecordById(int id) {
		return listenRecordDaoImpl.get(ListenRecord.class, id);
	}

	public void changeListenRecordStartTimeById(int id, String startTime) {
		listenRecordDaoImpl.updateListenRecordStartTimeById(id, startTime);
	}
	
	public void changeListenRecordEndTimeById(int id, String endTime) {
		listenRecordDaoImpl.updateListenRecordEndTimeById(id, endTime);
	}
	
	public void changeListenRecordPriceById(int id, int price) {
		listenRecordDaoImpl.updateListenRecordPriceById(id, price);
	}
}
