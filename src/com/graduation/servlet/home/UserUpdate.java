package com.graduation.servlet.home;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.graduation.entity.USER;
import com.graduation.service.USERDao;

/**
 * Servlet implementation class UserUpdate
 */
@WebServlet("/userupdate")
public class UserUpdate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		 HttpSession session =  request.getSession();
			
			String isLogin = (String)session.getAttribute("isLogin");
			
			USER u=(USER)session.getAttribute("name");
		
		
		String username = request.getParameter("userName");
		String name = request.getParameter("name");
		String pwd = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		String userStatus = request.getParameter("userStatus");
		
		int status = 1;
		
		if(userStatus != null) {
			status = Integer.parseInt(userStatus);
		}
		
		u.setUSER_ID(username);
		u.setUSER_NAME(name);
		u.setPWD(pwd);
		u.setSEX(sex);
		u.setEMAIL(email);
		u.setSTATUS(status);
		
        USER user = new USER(username, name, pwd, sex,  email,status);
		
		//加入到数据库的用户表中
		int count = USERDao.update(user);
		
		
		
		request.setAttribute("u", u);
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}

}
