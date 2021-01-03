package com.graduation.servlet.home;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.service.COMMENTDao;

/**
 * Servlet implementation class MyComDel
 */
@WebServlet("/mycomdel")
public class MyComDel extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int comid = Integer.parseInt(request.getParameter("comid"));
		COMMENTDao.del(comid);
		response.sendRedirect("mycomment");
	}


}
