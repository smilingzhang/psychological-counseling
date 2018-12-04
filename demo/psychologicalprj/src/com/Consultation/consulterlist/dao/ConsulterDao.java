package com.Consultation.consulterlist.dao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.entity.Course;
import com.entity.Teacher;
import com.entity.TeacherTime;
/**
 * 
 *@desc:预约功能咨询索引页对应的dao
 *@author chunhui
 *@date:Nov 28, 20181:19:11 PM
 */
@Repository
public class ConsulterDao {
	@Resource
	private SessionFactory sessionFactory;
	/**
	 * 
	 *@desc:检索符合条件的咨询师
	 *@param pageNum 当前页码
	 *@param pageSize 页面大小
	 *@param type 筛选的类型
	 *@param date 筛选的时间
	 *@return
	 *@return:List<Teacher>
	 *@trhows
	 */
	public List<Teacher> selectByScreen(int pageNum,int pageSize,int type,String date){
		List<Teacher> teachers=new ArrayList<>();
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("select bt.businesstypeWorkId from BusinessType bt where bt.typeTable.typetableId=?");
		query.setParameter(0, type);
		List<Integer> list =query.list();
		for(int i=0;i<list.size();i++) {
			Query query2=session.createQuery("from Teacher t where t.teacherId=?");
			query2.setParameter(0, list.get(i));
			List<Teacher> list2=query2.list();
			for(int j=0;j<list2.size();j++) { 
				List<TeacherTime> teacherTimes=list2.get(j).getTeacherTimes();
				for(int m=0;m<teacherTimes.size();m++) {
					String a=teacherTimes.get(m).getDate().toString().substring(0, 10);
					if(date.equals(a)) {
						teachers.add(list2.get(j));
					}
					
				}
			}	
		}
		return teachers;
		
	}
	/**
	 * 
	 *@desc:检索好评率前8的咨询师作为热门专家展示
	 *@return
	 *@return:List<Teacher>
	 *@trhows
	 */
	public List<Teacher> selectByRate() {
		Session session =sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Teacher t order by t.teacherPraiseRate desc");
		query.setFirstResult(0);
		query.setMaxResults(8);
		return query.list();
		
	}
	/**
	 * 
	 *@desc:检索所有的咨询师，一页展示6个
	 *@return
	 *@return:List<Teacher>
	 *@trhows
	 */
	public List<Teacher> selectDefault(){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Teacher t");
		/*query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);*/
		return query.list();
	}
	/**
	 * 
	 *@desc:通过id查询咨询师信息
	 *@param id
	 *@return
	 *@return:Teacher
	 *@trhows
	 */
	public Teacher selectById(int id) {
		Session session =sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Teacher t where t.teacherId=?");
		query.setParameter(0, id);
		return (Teacher) query.list().get(0);
	}
	/**
	 * 
	 *@desc:查询咨询的课程，展示8个
	 *@param teacherId
	 *@return
	 *@return:List<Course>
	 *@trhows
	 */
	public List<Course> selectCourseByTeacherId(int teacherId){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from Course c where c.teacher.teacherId=?");
		query.setParameter(0, teacherId);
		query.setFirstResult(0);
		query.setMaxResults(8);
		return query.list();
	}
}
