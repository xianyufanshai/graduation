package com.graduation.servlet.chapter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.BOOK;

import com.graduation.service.BOOKDao;



/**
 * Servlet implementation class ToChapterAdd
 */
@WebServlet("/manage/admin_tochapteradd")

public class ToChapterAdd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		int bid=Integer.parseInt(request.getParameter("bid"));
       BOOK p = BOOKDao.selectByID((bid));
		
	    request.setAttribute("p", p);
		
		request.setAttribute("cpage", request.getParameter("cpage"));
		
		request.getRequestDispatcher("admin_chapteradd.jsp").forward(request, response);
	}

	

}
