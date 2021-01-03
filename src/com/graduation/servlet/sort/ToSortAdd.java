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
 * Servlet implementation class ToSortAdd
 */
@WebServlet("/manage/admin_tosortadd")
public class ToSortAdd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<SORT> sortlist = SORTDao.selectAll();
		
		request.setAttribute("sortlist", sortlist);
		
		request.getRequestDispatcher("admin_sortadd.jsp").forward(request, response);
	}



}