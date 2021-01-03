package com.graduation.servlet.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.BOOK;
import com.graduation.service.BOOKDao;

/**
 * Servlet implementation class SelectBook
 */
@WebServlet("/selectbook")
public class SelectBook extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String keywords = request.getParameter("keywords");
		BOOK p = BOOKDao.selectBook(keywords);
		if(p!=null) {
			int bid = p.getBOOK_ID();
			
			request.getRequestDispatcher("selectbookview?bid="+bid+"").forward(request, response);
		}
	}

}
