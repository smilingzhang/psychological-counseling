package com.psychologicalcounseling.test.dao;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.psychologicalcounseling.entity.GoodAt;
import com.psychologicalcounseling.entity.Teacher;

@Repository
public class TestDao {
		@Resource
		private SessionFactory sessionFactory;
		
		public Teacher insertTeacher() {
			Session session =this.sessionFactory.getCurrentSession();
			Teacher t = new Teacher();
			GoodAt g = new GoodAt(); 
			g.setGoodAt("亲子");
			t.setTeacherWorkTime(100);
			t.setTeacherId(19);
			Set<GoodAt> sets =new HashSet<>();
			sets.add(g);
			t.setGoodats(sets);
			session.save(t);
			System.out.println("ok");
			return t;
		}
}
