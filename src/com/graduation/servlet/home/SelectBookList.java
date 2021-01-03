package com.graduation.servlet.home;

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
 * Servlet implementation class SelectBookList
 */
@WebServlet("/selectbooklist")
public class SelectBookList extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<SORT> flist =  SORTDao.selectSort("father");
		request.setAttribute("flist", flist);
		
		ArrayList<SORT> clist =  SORTDao.selectSort("child");
		request.setAttribute("clist", clist);
		
		String fid = request.getParameter("fid");
		String cid = request.getParameter("cid");
		
		int id=0;
		ArrayList<BOOK> list = null;
		if(fid!=null) {
			id=Integer.parseInt(fid);
			
		 list = BOOKDao.selectAllByFid(id);
		}
		
		if(cid!=null) {
			id=Integer.parseInt(cid);
			list = BOOKDao.selectAllByCid(id);
		}
		
		request.setAttribute("title", SORTDao.selectById(id).getSORT_NAME());
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("booklist.jsp").forward(request, response);
	}
}
