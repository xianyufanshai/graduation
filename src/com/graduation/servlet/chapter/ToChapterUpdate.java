package com.graduation.servlet.chapter;

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
 * Servlet implementation class ToChapterUpdate
 */
@WebServlet("/manage/admin_tochapterupdate")
public class ToChapterUpdate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String cid = request.getParameter("cid");
	    
		//通过ID到数据里查找
		CHAPTER c = CHAPTERDao.selectByID(cid);
        
		   request.setAttribute("c", c);
		int bid=Integer.parseInt(request.getParameter("bid"));
	       BOOK p = BOOKDao.selectByID((bid));
			
		    request.setAttribute("p", p);
		
		request.getRequestDispatcher("admin_chaptermodify.jsp").forward(request, response);;	
	}

	

}
