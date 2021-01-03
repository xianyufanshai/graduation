package com.graduation.servlet.comment;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.BOOK;
import com.graduation.entity.COMMENT;
import com.graduation.entity.USER;
import com.graduation.service.BOOKDao;
import com.graduation.service.COMMENTDao;
import com.graduation.service.USERDao;

/**
 * Servlet implementation class SelectComment
 */
@WebServlet("/manage/admin_selectcomment")
public class SelectComment extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<BOOK>	blist= BOOKDao.selectAll();
		
		//放到请求对象域里
		request.setAttribute("blist", blist);
		
		
		
		
		ArrayList<USER>	list= USERDao.selectAll();
		
		//放到请求对象域里
		request.setAttribute("userlist", list);
		
		
		ArrayList<COMMENT> comlist = COMMENTDao.SelectAll();
		request.setAttribute("comlist", comlist);
		request.getRequestDispatcher("admin_comment.jsp").forward(request, response);
		
	}

	

}
