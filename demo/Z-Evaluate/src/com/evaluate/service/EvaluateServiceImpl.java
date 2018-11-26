package com.evaluate.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.evaluate.dao.EvaluateDaoImpl;
import com.evaluate.entity.Evaluate;



@Service
public class EvaluateServiceImpl {
	@Resource
	private EvaluateDaoImpl evaluateDaoImpl;
	
	public List<Evaluate> list(){
		return this.evaluateDaoImpl.findAll();
	}
	public void insert(Evaluate e) {
		this.evaluateDaoImpl.save(e);
	}
}
