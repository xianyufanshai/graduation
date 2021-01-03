package com.graduation.servlet.inform;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.graduation.entity.COMMENT;
import com.graduation.entity.INFORM;
import com.graduation.entity.SORT;
import com.graduation.entity.USER;
import com.graduation.service.COMMENTDao;
import com.graduation.service.INFORMDao;
import com.graduation.service.SORTDao;

/**
 * Servlet implementation class DoInformAdd
 */
@WebServlet("/manage/admin_doinformadd")
public class DoInformAdd extends HttpServlet {

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		 HttpSession session =  request.getSession();
			
	     String isLogin = (String)session.getAttribute("isLogin");
			
		USER user=(USER)session.getAttribute("name");
		String uid = (String)user.getUSER_ID();
		
		
		Date d = new Date();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		String cdate = df.format(d);
		String iname = request.getParameter("Title");
		String con = request.getParameter("Content");
		
	
		INFORM in = new INFORM(
				  0,
				  iname,
				  con,
				  cdate,
				  uid
				);
		
		//加入到数据库的用户表中
		INFORMDao.insert(in);
		

		response.sendRedirect("admin_informselect");

	}

}
