package com.graduation.servlet.home;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.graduation.entity.BOOK;
import com.graduation.entity.COMMENT;
import com.graduation.entity.USER;
import com.graduation.service.BOOKDao;
import com.graduation.service.COMMENTDao;
import com.graduation.service.USERDao;


/**
 * Servlet implementation class MyComment
 */
@WebServlet("/mycomment")
public class MyComment extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
        ArrayList<BOOK>	blist= BOOKDao.selectAll();
		
		//放到请求对象域里
		request.setAttribute("blist", blist);

		
		ArrayList<USER>	list= USERDao.selectAll();
		
		//放到请求对象域里
		request.setAttribute("userlist", list);
		

		 HttpSession session =  request.getSession();
		USER user=(USER)session.getAttribute("name");
		String uid = (String)user.getUSER_ID();
		
		ArrayList<COMMENT> comlist = COMMENTDao.getMyComment(uid);
		request.setAttribute("comlist", comlist);
		request.getRequestDispatcher("comment.jsp").forward(request, response);
		
	}
}



