package com.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ConsultationRecordDaoImpl;
import com.entity.ConsultationRecord;

@Service
public class ConsultationRecordServiceImpl {

	@Resource
	private ConsultationRecordDaoImpl consultationRecordDaoImpl;

	public List<ConsultationRecord> listUnusedConsultationRecordsByUserId(int id) {

		return consultationRecordDaoImpl.findUnusedConsultationRecordsByUserId(id);

	}

	public List<ConsultationRecord> listAllUnusedConsultationRecords() {
		return consultationRecordDaoImpl.findAllUnusedConsultationRecords();
	}

	public List<ConsultationRecord> listUnusedConsultationRecordsByTeacherId(int id) {
		return consultationRecordDaoImpl.findUnusedConsultationRecordsByTeacherId(id);
	}
	
	// 通过咨询订单Id 将其状态改为已咨询。
	public void changeConsultStateToDoneById(int consultationrecordId) {
		consultationRecordDaoImpl.updateConsultationrecordById(consultationrecordId);
	}
	
}
