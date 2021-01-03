package com.graduation.servlet.shelf;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.service.SHELFDao;

/**
 * Servlet implementation class BookDel
 */
@WebServlet("/bookdel")
public class BookDel extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
                  String sid = request.getParameter("sid");
		
		SHELFDao.getbookdel(Integer.parseInt(sid));
		response.sendRedirect("bookshelf");
		
		
		
	}


}
