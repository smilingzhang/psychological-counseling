package com.teacher.coursetimemanager;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.Teacher;
import com.entity.TeacherTime;

@Repository
public class ConsulterTimeDaoImpl {
	@Resource
	private SessionFactory sessionFactory;
	
	
	public boolean updateDate(TeacherTime teacherTime) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(teacherTime);
		return true;
	}
	
	public Teacher selectTeacherById(int teacherId) {
		Session session = this.sessionFactory.getCurrentSession();
		Teacher teacher = new Teacher();
		Query query = session.createQuery("from Teacher cou where cou.teacherId = ?");
		query.setInteger(0, teacherId);
		teacher = (Teacher) query.uniqueResult();

		return teacher;
	}
	
	public TeacherTime selectTeacherTime(int userId,String day) {
		Session session = this.sessionFactory.getCurrentSession();
		TeacherTime time = new TeacherTime();
		Query query = session.createQuery("from TeacherTime cou where cou.teacher.teacherId = ?and cou.date=?");
		query.setParameter(0, userId);
		query.setParameter(1, day);
		time = (TeacherTime)query.uniqueResult();
		return time;
	}
	
	public void updateTeacherTime(TeacherTime teachertime) {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from TeacherTime cou where cou.teacher.teacherId = ?and cou.date=?");
		System.out.println("咨询师"+teachertime.getTeacher().getTeacherId());
		query.setParameter(0, teachertime.getTeacher().getTeacherId());
		query.setParameter(1, teachertime.getDate());
		TeacherTime temp = (TeacherTime) query.uniqueResult();
		System.out.println("temp"+temp);
		if(!temp.equals(teachertime)) {
		   session.delete(temp);
		   session.flush();
		   session.save(teachertime);
		}
	}
}
