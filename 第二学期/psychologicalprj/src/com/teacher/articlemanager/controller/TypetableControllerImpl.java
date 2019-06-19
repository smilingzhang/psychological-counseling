package com.teacher.articlemanager.controller;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.TypeTable;
import com.teacher.articlemanager.service.TypetableServiceImpl;

@Controller
public class TypetableControllerImpl {
	@Resource
	private TypetableServiceImpl typetableServiceImpl;
	
	@RequestMapping("Typetable")
	public void showTypetable(HttpServletRequest request,HttpSession session,HttpServletResponse response) {
		List<TypeTable> typetableList = this.typetableServiceImpl.findtypeTable(5);
		
		session.setAttribute("typetableList", typetableList);
		try {
			request.getRequestDispatcher("/background?teacherId=4&page=1").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
