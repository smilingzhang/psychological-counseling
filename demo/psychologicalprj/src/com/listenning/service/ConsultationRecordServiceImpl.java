package com.listenning.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.entity.ConsultationRecord;
import com.listenning.dao.ConsultationRecordDaoImpl;

@Service
@Transactional
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
	
	public List<ConsultationRecord> listUnusedConsultationRecordsById(int id, int identity) {
		
		List<ConsultationRecord> consultationRecords;
		if(identity == 1) {
			System.out.println("I am a common user...");
			consultationRecords = consultationRecordDaoImpl  
					.findUnusedConsultationRecordsByUserId(id);
		} else {
			System.out.println("I am a common teacher...");
			consultationRecords = consultationRecordDaoImpl 
					.findUnusedConsultationRecordsByTeacherId(id);
		}
		return consultationRecords;
	}
	
	
	
	// 通过咨询订单Id 将其状态改为已咨询。
	public void changeConsultStateToDoneById(int consultationrecordId) {
		consultationRecordDaoImpl.updateConsultationrecordById(consultationrecordId);
	}
	
}
