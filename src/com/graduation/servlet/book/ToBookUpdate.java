package com.graduation.servlet.book;

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
 * Servlet implementation class ToBookUpdate
 */
@WebServlet("/manage/admin_tobookupdate")
public class ToBookUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		//通过ID到数据里查找
		BOOK p = BOOKDao.selectByID(id);
        
		request.setAttribute("p", p);
		
		ArrayList<SORT> flist =  SORTDao.selectSort("father");
		request.setAttribute("flist", flist);
		
		ArrayList<SORT> clist =  SORTDao.selectSort("child");
		request.setAttribute("clist", clist);
		request.getRequestDispatcher("admin_bookmodify.jsp").forward(request, response);;	
	}


}
