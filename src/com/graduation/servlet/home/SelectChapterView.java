package com.graduation.servlet.home;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.graduation.entity.BOOK;
import com.graduation.entity.CHAPTER;
import com.graduation.entity.SORT;
import com.graduation.entity.USER;
import com.graduation.service.BOOKDao;
import com.graduation.service.CHAPTERDao;
import com.graduation.service.SORTDao;

/**
 * Servlet implementation class SelectChapterView
 */
@WebServlet("/selectchapterview")
public class SelectChapterView extends HttpServlet {
	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String cid = request.getParameter("cid");
		CHAPTER ch = CHAPTERDao.selectByID(cid);
	
		
		request.setAttribute("ch",ch);
		
		String id = request.getParameter("bid");
        BOOK p = null;
		if(id !=null) {
			p = BOOKDao.selectById(Integer.parseInt(id));
			request.setAttribute("p", p);	
			
		}
		
		
		request.getRequestDispatcher("chapterview.jsp").forward(request, response);
		
	}
}
