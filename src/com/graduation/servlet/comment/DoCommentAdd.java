package com.graduation.servlet.comment;

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


import com.graduation.entity.COMMENT;

import com.graduation.entity.USER;

import com.graduation.service.COMMENTDao;



/**
 * Servlet implementation class DoCommentAdd
 */
@WebServlet("/docommentadd")
public class DoCommentAdd extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		 HttpSession session =  request.getSession();
			
	     String isLogin = (String)session.getAttribute("isLogin");
			
		USER user=(USER)session.getAttribute("name");
		
		if(user!=null && isLogin.equals("1")) {
		String uid = (String)user.getUSER_ID();
		
		
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String cdate = df.format(d);
		String bid = request.getParameter("bid");
		String con = request.getParameter("content");
		
	
		COMMENT com = new COMMENT(
				  0,
				  con,
				  Integer.parseInt(bid),
				  uid,
				  cdate,
				  0
				);
		
		//加入到数据库的用户表中
		int count = COMMENTDao.insert(com);
		
			 
		//成功或失败重定向到哪里
		
		if(count >0 ) {
			response.sendRedirect("selectbookview?bid="+bid+"");
		} else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('发送成功')");
			out.write("location.href='bookview.jsp'");
			out.write("</script>");
			
		}
		
	}

	}	

}
