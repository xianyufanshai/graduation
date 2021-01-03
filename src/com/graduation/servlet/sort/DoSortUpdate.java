package com.graduation.servlet.sort;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.SORT;
import com.graduation.service.SORTDao;

/**
 * Servlet implementation class DoAddSort
 */
@WebServlet("/manage/admin_dosortupdate")
public class DoSortUpdate extends HttpServlet {
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		int id = Integer.parseInt(request.getParameter("id"));
		int fid = Integer.parseInt(request.getParameter("parentId"));
		String name = request.getParameter("className");
		
		SORT sort= new SORT(id, name, fid);
		SORTDao.update(sort);
		
		response.sendRedirect("admin_sortselect");
	}

	
	
}
