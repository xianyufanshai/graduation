package com.graduation.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.USER;
import com.graduation.service.USERDao;

/** * 
 */
@WebServlet("/manage/admin_douseradd")
public class DoUserAdd extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//设置字符集
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("userName");
		String name = request.getParameter("name");
		String pwd = request.getParameter("passWord");
		String sex = request.getParameter("sex");
		String email = request.getParameter("email");
		//创建用户实体
	    USER u = new USER(username, name, pwd, sex,  email,0);
		
		//加入到数据库的用户表中
		int count = USERDao.insert(u);
		

		//成功或失败重定向到哪里
		
		if(count >0 ) {
			
			response.sendRedirect("admin_douserselect");
		} else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户添加失败')");
			out.write("location.href='manage/admin_useradd.jsp'");
			out.write("</script>");
			
		}
		
	}

}
