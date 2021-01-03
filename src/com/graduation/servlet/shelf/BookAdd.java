package com.graduation.servlet.shelf;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.graduation.entity.BOOK;
import com.graduation.entity.SHELF;
import com.graduation.entity.USER;
import com.graduation.service.BOOKDao;
import com.graduation.service.SHELFDao;

/**
 * Servlet implementation class BookAdd
 */
@WebServlet("/bookadd")
public class BookAdd extends HttpServlet {
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		BOOK p = null;
		
		String pid = request.getParameter("id");
		
		HttpSession session =  request.getSession();
		
		String isLogin = (String)session.getAttribute("isLogin");
		
		USER user=(USER)session.getAttribute("name");
		
       if(user!=null && isLogin.equals("1")) {
			
			String uid = (String)user.getUSER_ID();
			
			
			//通过用户ID和购物车中的商品ID 查看有没有这条记录
			
			SHELF srcsp = SHELFDao.getShelfBook(uid, pid);
			
			if(srcsp != null) {
			
				PrintWriter out = response.getWriter();
				
				out.write("<script>");
				out.write("alert('书架已存在该书籍')");
				out.write("location.href='selectbookview?bid="+pid+"'");
				out.write("</script>");
				
			}else{
					p  = BOOKDao.selectById(Integer.parseInt(pid));
		
				
				SHELF shelf = new SHELF(
							0,
							p.getBOOK_FILENAME(),
							p.getBOOK_WRITER(),
							p.getBOOK_NAME(),
							p.getBOOK_ID(),
							uid
						
						);
				
				SHELFDao.insert(shelf);
				
			
			}
			
		}
		
		
       request.getRequestDispatcher("selectbookview?bid="+pid+"").forward(request, response);
	}

	

}
