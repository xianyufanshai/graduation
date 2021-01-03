package com.graduation.servlet.inform;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.BOOK;
import com.graduation.entity.COMMENT;
import com.graduation.entity.INFORM;
import com.graduation.entity.USER;
import com.graduation.service.BOOKDao;
import com.graduation.service.COMMENTDao;
import com.graduation.service.INFORMDao;
import com.graduation.service.USERDao;

/**
 * Servlet implementation class InformSelect
 */
@WebServlet("/manage/admin_informselect")
public class InformSelect extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			ArrayList<INFORM>	inlist= INFORMDao.selectAll();
			
			//放到请求对象域里
			request.setAttribute("inlist", inlist);
	
			ArrayList<USER>	list= USERDao.selectAll();
			
			//放到请求对象域里
			request.setAttribute("userlist", list);
	
			request.getRequestDispatcher("admin_inform.jsp").forward(request, response);
			
			
	}



}
