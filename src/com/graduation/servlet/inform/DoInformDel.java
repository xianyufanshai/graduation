package com.graduation.servlet.inform;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.service.BOOKDao;
import com.graduation.service.INFORMDao;

/**
 * Servlet implementation class DoInformDel
 */
@WebServlet("/manage/admin_doinformdel")
public class DoInformDel extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int inid = Integer.parseInt(request.getParameter("inid"));
		INFORMDao.del(inid);
		response.sendRedirect("admin_informselect");
	}

}
