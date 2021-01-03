package com.graduation.servlet.sort;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.service.SORTDao;

/**
 * Servlet implementation class DoSortDel
 */
@WebServlet("/manage/admin_dosortdel")
public class DoSortDel extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		SORTDao.del(id);
		response.sendRedirect("admin_sortselect");
	}

	

}