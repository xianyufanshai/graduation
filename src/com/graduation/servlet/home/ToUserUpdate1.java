package com.graduation.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.graduation.entity.SHELF;
import com.graduation.entity.USER;
import com.graduation.service.SHELFDao;
import com.graduation.service.USERDao;

/**
 * Servlet implementation class ToUserUpdate1
 */
@WebServlet("/touserupdate1")
public class ToUserUpdate1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=utf-8");
		 HttpSession session =  request.getSession();
			
			String isLogin = (String)session.getAttribute("isLogin");
			
			USER u=(USER)session.getAttribute("name");
		request.setAttribute("u", u);
		request.getRequestDispatcher("message.jsp").forward(request, response);
    	   
	}

	}


