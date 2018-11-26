package com.evaluate.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.evaluate.entity.Evaluate;


@Repository
public class EvaluateDaoImpl{
	@Resource
	private SessionFactory sessionFactory;
	
	public List<Evaluate> findAll(){
		Session session = this.sessionFactory.getCurrentSession();
		Query q = session.createQuery("from Evaluate");
		q.setMaxResults(10);
		return q.list();
	}
	
	public void save(Evaluate e) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(e);
	}
}
