package com.graduation.servlet.creation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.BOOK;
import com.graduation.entity.CHAPTER;
import com.graduation.service.BOOKDao;
import com.graduation.service.CHAPTERDao;

/**
 * Servlet implementation class CCreationSelect
 */
@WebServlet("/ccreationselect")
public class CCreationSelect extends HttpServlet {
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int bid=Integer.parseInt(request.getParameter("bid"));
	       BOOK p = BOOKDao.selectByID((bid));   
		    request.setAttribute("p", p);
		    
		    ArrayList<CHAPTER>	chlist= CHAPTERDao.selectAllByBid(bid);
		    request.setAttribute("chlist", chlist);
		    
		    
		    request.getRequestDispatcher("cchapterselect.jsp").forward(request, response);
	}
}
