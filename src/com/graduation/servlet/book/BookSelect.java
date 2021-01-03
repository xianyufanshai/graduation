package com.graduation.servlet.book;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.BOOK;
import com.graduation.service.BOOKDao;
import com.graduation.service.USERDao;

/**
 * Servlet implementation class BookSelect
 */
@WebServlet("/manage/admin_bookselect")
public class BookSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			int cpage = 1; //当前页
			int count = 8; //每页显示条数
			
			String cp = request.getParameter("cp");
			
			//接收用户搜索的关键字
			String keyword = request.getParameter("keywords");
			
			if(cp!=null)
			{
				cpage = Integer.parseInt(cp);
			}
			
			int arr[] = BOOKDao.totalPage(count, keyword);
			
			
			
			ArrayList<BOOK>  plist = BOOKDao.selectAll(cpage, count, keyword);
			
			request.setAttribute("plist", plist);
			request.setAttribute("tsum", arr[0]);
			request.setAttribute("tpage", arr[1]);
			request.setAttribute("cpage", cpage);
			
			if(keyword != null) {
				request.setAttribute("searchParams", "&keywords="+keyword);
			}
			request.getRequestDispatcher("admin_book.jsp").forward(request, response);
	
	}
	

	

}

