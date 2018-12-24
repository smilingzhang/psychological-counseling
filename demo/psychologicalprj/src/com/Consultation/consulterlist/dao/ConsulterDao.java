package com.Consultation.consulterlist.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.criteria.From;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.Teacher;
import com.entity.TeacherTime;
import com.util.BaseDao;

/**
 * 
 * @desc:预约功能咨询索引页对应的dao
 * @author chunhui
 * @date:Nov 28, 20181:19:11 PM
 */
@Repository
public class ConsulterDao extends BaseDao<Teacher> {
	/**
	 * 
	 * @desc:检索符合条件的咨询师
	 * @param pageNum
	 *            当前页码
	 * @param pageSize
	 *            页面大小
	 * @param type
	 *            筛选的类型
	 * @param date
	 *            筛选的时间
	 * @return
	 * @return:List<Teacher>
	 * @trhows
	 */
	public List<Teacher> selectByScreen(int pageNum, int pageSize, int type, String date) {
		List<Teacher> teachers = new ArrayList<>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("select bt.businesstypeWorkId from BusinessType bt where bt.typeTable.typetableId=?");
		query.setParameter(0, type);
		List<Integer> list = query.list();
		for (int i = 0; i < list.size(); i++) {
			Query query2 = session.createQuery("from Teacher t where t.teacherId=?");
			query2.setParameter(0, list.get(i));
			List<Teacher> list2 = query2.list();
			for (int j = 0; j < list2.size(); j++) {
				List<TeacherTime> teacherTimes = list2.get(j).getTeacherTimes();
				for (int m = 0; m < teacherTimes.size(); m++) {
					String a = teacherTimes.get(m).getDate();
					if (date.equals(a)) {
						teachers.add(list2.get(j));
					}

				}
			}
		}
		return teachers;

	}

	/**
	 * 
	 * @desc:检索好评率前8的咨询师作为热门专家展示
	 * @return
	 * @return:List<Teacher>
	 * @trhows
	 */
	public List<Teacher> selectByRate() {
		return findByPage("from Teacher t order by t.teacherPraiseRate desc", 0, 8);

	}

	/**
	 * 
	 * @desc:默认展示当天可以咨询的咨询师
	 * @return
	 * @return:List<Teacher>
	 * @trhows
	 */
	public List<Teacher> selectDefault() {
		DateFormat bf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = new Date();
	    String format = bf.format(date1);
		Session session=sessionFactory.getCurrentSession();
		SQLQuery query=session.createSQLQuery("select * from teacher where teacherId in(select teacherId from teachertime where date=?)");
		query.setParameter(0, format);
		query.addEntity(Teacher.class);
		return query.list();
	}

	/**
	 * 
	 * @desc:通过id查询咨询师信息
	 * @param id
	 * @return
	 * @return:Teacher
	 * @trhows
	 */
	public Teacher selectById(int id) {
		return get(Teacher.class, id);
	}

}
