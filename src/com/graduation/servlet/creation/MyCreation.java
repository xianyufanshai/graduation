package com.graduation.servlet.creation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.graduation.entity.BOOK;
import com.graduation.entity.SORT;
import com.graduation.entity.USER;
import com.graduation.service.BOOKDao;
import com.graduation.service.SORTDao;


/**
 * Servlet implementation class MyCreation
 */
@WebServlet("/mycreation")
public class MyCreation extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 HttpSession session =  request.getSession();	
		
		    USER user=(USER)session.getAttribute("name");
				
				  if(user.getUSER_NAME()!=null) {
					  String uname = user.getUSER_NAME();
						ArrayList<BOOK> blist =  BOOKDao.BookByUnm(uname);
						request.setAttribute("blist", blist);
				};
				ArrayList<SORT> flist =  SORTDao.selectSort("father");
				request.setAttribute("flist", flist);
				
				ArrayList<SORT> clist =  SORTDao.selectSort("child");
				request.setAttribute("clist", clist);
				
				
			request.getRequestDispatcher("creation.jsp").forward(request, response);
	}

}
