package com.graduation.servlet.comment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.service.BOOKDao;
import com.graduation.service.COMMENTDao;

/**
 * Servlet implementation class DoCommentDel
 */
@WebServlet("/manage/admin_docommentdel")
public class DoCommentDel extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int comid = Integer.parseInt(request.getParameter("comid"));
		COMMENTDao.del(comid);
		response.sendRedirect("admin_selectcomment");
	}

}
