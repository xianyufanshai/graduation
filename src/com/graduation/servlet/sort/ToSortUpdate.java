package com.graduation.servlet.sort;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.SORT;
import com.graduation.service.SORTDao;

/**
 * Servlet implementation class ToSortUpdate
 */
@WebServlet("/manage/admin_tosortupdate")
public class ToSortUpdate extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));	
		
		SORT sort =  SORTDao.selectById(id);
		
		
		ArrayList<SORT> sortlist = SORTDao.selectAll();
		
		request.setAttribute("sortlist", sortlist);
		request.setAttribute("sort1", sort);
		
		ArrayList<SORT> flist =  SORTDao.selectSort("father");
		request.setAttribute("flist", flist);
		
		ArrayList<SORT> clist =  SORTDao.selectSort("child");
		request.setAttribute("clist", clist);
		
		request.getRequestDispatcher("admin_sortmodify.jsp").forward(request, response);
	}



}

