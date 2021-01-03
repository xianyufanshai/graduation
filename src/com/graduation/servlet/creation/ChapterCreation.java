package com.graduation.servlet.creation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.BOOK;
import com.graduation.service.BOOKDao;

/**
 * Servlet implementation class ChapterCreation
 */
@WebServlet("/chaptercreation")
public class ChapterCreation extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			int bid=Integer.parseInt(request.getParameter("bid"));
		       BOOK p = BOOKDao.selectByID((bid));
				
			    request.setAttribute("p", p);
			    request.getRequestDispatcher("creationchapteradd.jsp").forward(request, response);
	}

	

}
