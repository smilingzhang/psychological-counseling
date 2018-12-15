package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ListenRecordDaoImpl;
import com.entity.ListenRecord;

@Service
public class ListenRecordServiceImpl {

	@Resource
	private ListenRecordDaoImpl listenRecordDaoImpl;

	public List<ListenRecord> listUnusedListenRecordsByUserId(int id) {
		return listenRecordDaoImpl.findUnusedConsultationRecordsByUserId(id);
	}

	public List<ListenRecord> listAllUnusedListenRecords() {
		return listenRecordDaoImpl.findAllUnusedConsultationRecords();
	}

	public List<ListenRecord> listUnusedListenRecordsByTeacherId(int id) {
		return listenRecordDaoImpl.findUnusedConsultationRecordsByTeacherId(id);
	}
	
	// 通过咨询订单Id 将其状态改为已咨询。
	public void changeListenStateToDoneById(int listenrecordId) {
		listenRecordDaoImpl.updateListenRecordById(listenrecordId);
	}

	public ListenRecord searchListenRecordById(int id) {
		return listenRecordDaoImpl.get(ListenRecord.class, id);
	}

}
