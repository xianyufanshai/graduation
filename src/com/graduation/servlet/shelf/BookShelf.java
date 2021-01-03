package com.graduation.servlet.shelf;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 * Servlet implementation class BookShelf
 */
@WebServlet("/bookshelf")
public class BookShelf extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
        HttpSession session =  request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		
		USER user=(USER)session.getAttribute("name");
		
       if(user!=null && isLogin.equals("1")) {
    		String uid = (String)user.getUSER_ID();
			ArrayList<SHELF> list= SHELFDao.getShelf(uid);
			
			request.setAttribute("shelflist", list);
			
			
			request.getRequestDispatcher("bookshelf.jsp").forward(request, response);
    	   
	}else {
		
		PrintWriter out = response.getWriter();
		
		out.write("<script>");
		out.write("alert('请登录')");
		out.write("location.href='login.jsp'");
		out.write("</script>");
		out.close();
	
	}


}
}