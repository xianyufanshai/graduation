package com.graduation.servlet.creation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.graduation.entity.SORT;
import com.graduation.entity.USER;
import com.graduation.service.SORTDao;

/**
 * Servlet implementation class Creation
 */
@WebServlet("/creation")
public class Creation extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<SORT> flist =  SORTDao.selectSort("father");
		request.setAttribute("flist", flist);
		
		ArrayList<SORT> clist =  SORTDao.selectSort("child");
		request.setAttribute("clist", clist);
		
		 HttpSession session =  request.getSession();
			
	    String isLogin = (String)session.getAttribute("isLogin");
	    USER user=(USER)session.getAttribute("name");
		if(Integer.parseInt(isLogin)==1) {
			request.setAttribute("user",user);
			}
		request.getRequestDispatcher("bookcreation.jsp").forward(request, response);
	}

	

}
