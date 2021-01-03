package com.graduation.servlet.creation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.service.BOOKDao;

/**
 * Servlet implementation class CBookDel
 */
@WebServlet("/cbookdel")
public class CBookDel extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid = Integer.parseInt(request.getParameter("bid"));
		BOOKDao.del(bid);
		response.sendRedirect("mycreation");
	}

	

}
