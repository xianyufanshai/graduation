package com.graduation.servlet.inform;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.graduation.entity.USER;

/**
 * Servlet implementation class ToInformAdd
 */
@WebServlet("/manage/admin_toinformadd")
public class ToInformAdd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 HttpSession session =  request.getSession();
			
	     String isLogin = (String)session.getAttribute("isLogin");
			
		USER user=(USER)session.getAttribute("name");
		if(user!=null && isLogin.equals("1")) {
			request.setAttribute("user", user);
			
		}
		request.getRequestDispatcher("admin_informadd.jsp").forward(request, response);;
	}

}
