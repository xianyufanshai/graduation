package com.graduation.servlet.creation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.BOOK;
import com.graduation.entity.SORT;
import com.graduation.service.BOOKDao;
import com.graduation.service.SORTDao;

/**
 * Servlet implementation class CBookUpdate
 */
@WebServlet("/cbookupdate")
public class CBookUpdate extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
int bid = Integer.parseInt(request.getParameter("bid"));
		
		//通过ID到数据里查找
		BOOK p = BOOKDao.selectByID(bid);
        
		request.setAttribute("p", p);
		
		ArrayList<SORT> flist =  SORTDao.selectSort("father");
		request.setAttribute("flist", flist);
		
		ArrayList<SORT> clist =  SORTDao.selectSort("child");
		request.setAttribute("clist", clist);
		request.getRequestDispatcher("cbookupdate.jsp").forward(request, response);;	
	}

	
}
