package com.graduation.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.service.USERDao;

/**
 * Servlet implementation class UsernameCheck
 */
@WebServlet("/namecheck")
public class NameCheck extends HttpServlet {
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//设置字符集
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=utf-8");
			
			String username = request.getParameter("username");
			
			int count = USERDao.selectByName(username);
		
			
			PrintWriter out = response.getWriter();
			if(count >0 ){
				out.print("false");
			}else{
				out.print("true");
			}
			
		
			
			out.close();
		}

		




}
