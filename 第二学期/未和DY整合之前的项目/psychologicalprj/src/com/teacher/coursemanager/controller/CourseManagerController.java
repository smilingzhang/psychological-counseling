package com.teacher.coursemanager.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.entity.TeacherCourse;
import com.entity.User;
import com.teacher.coursemanager.service.FindTeacherCourseService;

@Controller
public class CourseManagerController {

	// 通过userId查出该咨询师所有的课程，一页显示4个
	// 查询内容包括：课程分类，课程名，价格，图片，简介，浏览人数，收藏/购买人数，章节数，课时数
	@Resource
	private FindTeacherCourseService findTeacherCourseService;

	@RequestMapping("/background")
	public String findTeacherCourse(@RequestParam(name = "teacherId") int teacherId,
			@RequestParam(name = "page") int pageNo, HttpServletRequest request) throws IOException {

		// bzj 将数据放入session中
		HttpSession session = request.getSession();
		User my = (User) session.getAttribute("user");
		System.out.println("my:" + my);
		int id = my.getUserId();
		double[] res = calculate(id);
		session.setAttribute("avgData", res);
		//bzj
		
		List<TeacherCourse> list = findTeacherCourseService.findTeacherCourse(teacherId, pageNo);
		request.setAttribute("TeacherCourse", list);
		request.setAttribute("teacherId", teacherId);
		request.setAttribute("pageNo", pageNo);
		return "background";
	}

	
	//bzj
	public static void p(Object o) {
		System.out.println(o);
	}
	public double[] calculate(int id) throws IOException {

		List<Integer>[] dest = new ArrayList[6];
		for (int i = 1; i <= 5; ++i)
			dest[i] = new ArrayList<Integer>();

		File f = new File("D:/consulterComment");
		FileReader fr = new FileReader("D:/consulterComment");
		BufferedReader br = new BufferedReader(fr);
		String line = "";
		while ((line = br.readLine()) != null) {
			String[] a = line.split(" ");
			int t[] = new int[3];
			if (Integer.parseInt(a[0]) == id) {
				// 如果是目标咨询师
				t[1] = Integer.parseInt(a[1]);
				t[2] = Integer.parseInt(a[2]);
				dest[t[1]].add(t[2]); // 加入到对应的位置
			}
		}
		// 计算平均分
		double[] res = new double[6];
		for (int i = 1; i <= 5; ++i) {
			// 每个List算出即可
			double sum = 0;
			int cnt = 0;
			for (Integer j : dest[i]) {
				sum += j;
				cnt++;
			}

			// 保留两位小数
//			DecimalFormat df = new DecimalFormat("#.00");
//			res[i] = sum / cnt;
//			res[i] = Double.parseDouble(df.format(res[i]));

			res[i] = sum / cnt;
		}
		double s = 0;
		for (int i = 1; i <= 5; ++i)
			s += res[i];
		p("Arrays.toString(res):" + Arrays.toString(res) + "s:" + s);

		double rtn[] = new double[6];
		for (int i = 1; i <= 5; ++i)
			rtn[i] = res[i] / s * 100;
		p("Arrays.toString(rtn):" + Arrays.toString(rtn));
		return rtn;
	}
	//bzj
}
