package com.psychologicalcounseling.course.course.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.psychologicalcounseling.entity.CourseCatalog;

@Controller
public class Mysrc {
	@RequestMapping("/mysrc")
	public void jumpsrc(HttpServletResponse response,HttpServletRequest request) {
		CourseCatalog courseCatalog = (CourseCatalog) request.getSession().getAttribute("courseCatalog");
		String url = courseCatalog.getCoursecatalogResourcePath();	
		try {
				response.sendRedirect(url);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
	}
	
}
