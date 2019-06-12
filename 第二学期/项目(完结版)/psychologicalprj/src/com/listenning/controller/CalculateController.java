package com.listenning.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.User;
import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

@Controller
public class CalculateController {

	public static void p(Object o) { System.out.println(o);}
	
	@RequestMapping("/calculate")
	public String deal(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		HttpSession session = req.getSession();
		User my = (User) session.getAttribute("user");
		System.out.println("my:" + my);
		int id = my.getUserId();
		double[] res = calculate(id);
		
		
		session.setAttribute("avgData", res);
		System.out.println("pieAvg.js...");
		return "pieAvg";
	}
	
	public double[] calculate(int id) throws IOException {

		
		List<Integer>[] dest = new ArrayList[6];
		for (int i = 1; i <= 5; ++i) dest[i] = new ArrayList<Integer>();
		
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
				dest[t[1]].add(t[2]); //加入到对应的位置
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
			DecimalFormat df = new DecimalFormat("#.00");
			res[i] = sum / cnt;
			res[i] = Double.parseDouble(df.format(res[i]));
		}
		double s = 0;
		for(int i = 1; i <= 5; ++i) s += res[i];
		p("Arrays.toString(res):" + Arrays.toString(res) + "s:" + s);
		
		
		double rtn[] = new double[6];
		for (int i = 1; i <= 5; ++i) rtn[i] = res[i] / s * 100;
		p("Arrays.toString(rtn):" + Arrays.toString(rtn));
		return rtn;
	}
}
