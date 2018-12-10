package com.Consultation.consulterlist.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Consultation.consulterlist.dao.ConsultCourseDao;
import com.Consultation.consulterlist.dao.ConsulterDao;
import com.entity.Course;
import com.entity.Page;
import com.entity.Teacher;
import com.util.SetPageUtil;

/**
 * 
 * @desc:预约功能咨询索引页对应的service
 * @author chunhui
 * @date:Nov 28, 20181:19:33 PM
 */
@Service
@Transactional(readOnly = true)
public class ConsulterService extends SetPageUtil<Teacher> {
	@Resource
	private ConsulterDao consulterDao;
	@Resource
	private ConsultCourseDao consultCourseDao;

	/**
	 * 
	 * @desc:得到索引页默认展示的所有的咨询师并且分页
	 * @param num
	 * @return
	 * @return:Page
	 * @trhows
	 */
	public Page<Teacher> showDefault(int num, int pageSize) {
		if (num == 0) {
			num = 1;
		}
		// 左侧默认展示的咨询师
		List<Teacher> defaultTeachers = this.consulterDao.selectDefault();
		// 把左侧所有咨询师分页展示
		List<Teacher> showTeachers = new ArrayList<>();
		for (int i = (num - 1) * pageSize; i < pageSize * num && i < defaultTeachers.size(); i++) {
			showTeachers.add(defaultTeachers.get(i));
		}
		Page<Teacher> page = setPage(num, pageSize, defaultTeachers.size(), showTeachers);
		return page;
	}

	/**
	 * 
	 * @desc:得到咨询索引页右端热门专家
	 * @return
	 * @return:List<Teacher>
	 * @trhows
	 */
	public List<Teacher> showPopularConsulter() {
		// 右侧热门专家
		List<Teacher> listTeachers = this.consulterDao.selectByRate();
		return listTeachers;
	}

	/**
	 * 
	 * @desc:得到符合筛选条件的咨询师
	 * @param type
	 * @param date
	 * @param pageNum
	 * @return
	 * @return:String
	 * @trhows
	 */
	public Page<Teacher> showByConditions(int type, String date, String pageNum, int pageSize) {
		int num = 0;
		if (pageNum == null || pageNum.equals("")) {
			num = 1;
		} else {
			num = Integer.parseInt(pageNum);
		}
		if (date == null || date.equals("")) {
			date = new Date().toString();
		}
		if (type == 0) {
			type = 1;
		}
		List<Teacher> teachers = this.consulterDao.selectByScreen(num, 2, type, date);
		// 分页显示
		List<Teacher> reTeachers = new ArrayList<>();
		for (int n = ((num - 1) * 2); n < num * 2 && n < teachers.size(); n++) {
			reTeachers.add(teachers.get(n));
		}
		Page<Teacher> page = setPage(num, pageSize, teachers.size(), reTeachers);
		return page;
	}

	/**
	 * 
	 * @desc:得到某个咨询师的详细信息
	 * @param teacherId
	 * @return
	 * @return:Teacher
	 * @trhows
	 */
	public Teacher showConsultDetail(int teacherId) {
		return this.consulterDao.selectById(teacherId);
	}

	/**
	 * 
	 * @desc:得到某个咨询师的精品课程
	 * @param teacherId
	 * @return
	 * @return:List<Course>
	 * @trhows
	 */
	public List<Course> showTeacherCourse(int teacherId) {
		return this.consultCourseDao.selectCourseByTeacherId(teacherId);
	}

}
