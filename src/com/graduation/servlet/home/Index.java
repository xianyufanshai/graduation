package com.graduation.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.graduation.entity.BOOK;
import com.graduation.entity.COMMENT;
import com.graduation.entity.INFORM;
import com.graduation.entity.USER;
import com.graduation.service.BOOKDao;
import com.graduation.service.COMMENTDao;
import com.graduation.service.INFORMDao;
import com.graduation.service.USERDao;

/**
 * Servlet implementation class Index
 */
@WebServlet("/index")
public class Index extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<COMMENT> comlist = COMMENTDao.SelectAll();
		request.setAttribute("comlist", comlist);
		
		ArrayList<USER> userlist = USERDao.selectAll();
		request.setAttribute("userlist", userlist);
		
		ArrayList<BOOK> blist = BOOKDao.selectAll();
		request.setAttribute("blist", blist);
		
		ArrayList<INFORM> inlist = INFORMDao.selectAll();
		request.setAttribute("inlist", inlist);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	
}
