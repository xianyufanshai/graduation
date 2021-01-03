package com.graduation.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.BOOK;
import com.graduation.entity.SORT;
import com.graduation.service.BOOKDao;
import com.graduation.service.SORTDao;

/**
 * Servlet implementation class StackSelect
 */
@WebServlet("/stackselect")
public class StackSelect extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<SORT> flist =  SORTDao.selectSort("father");
		request.setAttribute("flist", flist);
		
		ArrayList<SORT> clist =  SORTDao.selectSort("child");
		request.setAttribute("clist", clist);
		
		ArrayList<BOOK> blist =  BOOKDao.selectAll();
		request.setAttribute("blist", blist);
		
		request.getRequestDispatcher("stack.jsp").forward(request, response);
	}


}
