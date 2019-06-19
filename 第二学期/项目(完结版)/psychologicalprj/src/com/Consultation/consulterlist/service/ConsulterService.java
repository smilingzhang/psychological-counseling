package com.Consultation.consulterlist.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Consultation.consulterlist.dao.ConsultCourseDao;
import com.Consultation.consulterlist.dao.ConsulterDao;
import com.entity.Course;
import com.entity.Teacher;
import com.util.Page;
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

	/**
	 * 调用用户被推荐的咨询师的集合，思想：拿到用户所有咨询记录中的咨询师，要到文件中去比对哪个咨询师和这个咨询师相似度高展示给用户，待完成
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@SuppressWarnings("unlikely-arg-type")
	public List<Teacher> showAllConsulationTeeachers(int id) throws InterruptedException, IOException {
		// list为所有该用户咨询过的咨询师
		List<Teacher> list = new ArrayList<>();
		list = this.consulterDao.selectConsulationRecord(id);
		Process proc = Runtime.getRuntime()
				.exec("python D:\\StuyWok\\study\\course\\BigData\\Python\\pythoncode\\consultant.py");
		BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String line = null;
		// list2为所有咨询师之间的相似度
		List<List<String>> list2 = new LinkedList<List<String>>();
		while ((line = in.readLine()) != null) {
			List<String> list1 = new ArrayList<>();
			String[] string = line.split(" ");
			for (int i = 0; i < string.length; i++) {
				list1.add(string[i]);
			}
			list2.add(list1);
		}
		// list3用于存放所有和用户咨询过的咨询师 相似的咨询师的id 以及相似度
		List<List<String>> list3 = new LinkedList<List<String>>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list2.size(); j++) {
				if (((Teacher) list.get(i)).getTeacherId() == Integer.parseInt(list2.get(j).get(0))) {
					List<String> list4 = new ArrayList<>();
					list4.add(list2.get(j).get(1));
					list4.add(list2.get(j).get(2));
					list3.add(list4);
				}
			}
		}
		// 向用户推荐相似度最高的前6个,先按照相似度排序然后推荐六个
			// 排序
		List<Teacher> commendTeachers = new ArrayList<>();
		for (int i = 0; i < list3.size() - 1; i++) {
			for (int j = 0; j < list3.size() - i - 1; j++) {
				if (Float.parseFloat(list3.get(j).get(1)) < Float.parseFloat(list3.get(j + 1).get(1))) {
					Collections.swap(list3, j, j + 1);
				}
			}
		}
			// 推荐结果
		for (int i = 0; i < list3.size(); i++) {
			Teacher teacher = this.consulterDao.selectById(Integer.parseInt(list3.get(i).get(0)));
			// 调用重写的equals方法
			if (commendTeachers.contains(teacher)) {
				continue;
			} else {
				commendTeachers.add(this.consulterDao.selectById(Integer.parseInt(list3.get(i).get(0))));
			}
			if (commendTeachers.size() > 5) {
				break;
			}
		}
		in.close();
		proc.waitFor();
		return commendTeachers;
	}
}
