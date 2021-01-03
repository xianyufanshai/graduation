package com.graduation.servlet.book;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.service.BOOKDao;
import com.graduation.service.SORTDao;

/**
 * Servlet implementation class DoBookDel
 */
@WebServlet("/manage/admin_dobookdel")
public class DoBookDel extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		BOOKDao.del(id);
		response.sendRedirect("admin_bookselect");
	}
}
