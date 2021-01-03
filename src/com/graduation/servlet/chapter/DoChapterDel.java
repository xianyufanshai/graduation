package com.graduation.servlet.chapter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.service.CHAPTERDao;


/**
 * Servlet implementation class DoChapterDel
 */
@WebServlet("/manage/admin_dochapterdel")
public class DoChapterDel extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid = Integer.parseInt(request.getParameter("cid"));
		int bid = Integer.parseInt(request.getParameter("bid"));
		int count =CHAPTERDao.del(cid);;
		

		//成功或失败重定向到哪里
		
		if(count >0 ) {
			
			response.sendRedirect("admin_chapterselect?bid="+bid+"");
		} else {
			PrintWriter out = response.getWriter();
			
			out.write("<script>");
			out.write("alert('用户删除失败')");
			out.write("location.href='manage/admin_douserselect?cp="+request.getParameter("cpage")+"'");
			out.write("</script>");
			
		}
		

	}


}
