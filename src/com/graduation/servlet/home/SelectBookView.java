package com.graduation.servlet.home;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.graduation.entity.BOOK;
import com.graduation.entity.CHAPTER;
import com.graduation.entity.COMMENT;
import com.graduation.entity.SORT;
import com.graduation.entity.USER;
import com.graduation.service.BOOKDao;
import com.graduation.service.CHAPTERDao;
import com.graduation.service.COMMENTDao;
import com.graduation.service.SORTDao;
import com.graduation.service.USERDao;

/**
 * Servlet implementation class SelectBookView
 */
@WebServlet("/selectbookview")
public class SelectBookView extends HttpServlet {
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
		ArrayList<SORT> flist =  SORTDao.selectSort("father");
		request.setAttribute("flist", flist);
		
		ArrayList<SORT> clist =  SORTDao.selectSort("child");
		request.setAttribute("clist", clist);
		
		String id = request.getParameter("bid");
           BOOK p = null;
		   
		if(id !=null) {
			p = BOOKDao.selectById(Integer.parseInt(id));
			request.setAttribute("p", p);	
			
		}
		
		
		if(p!=null) {
			int cid = p.getBOOK_CID();
			ArrayList<BOOK> classlist = BOOKDao.selectAllByCid(cid);
			request.setAttribute("classlist", classlist);
			
			SORT sort = SORTDao.selectById(cid);
			
			request.setAttribute("sort", sort);
			
			int fid = p.getBOOK_FID();
			ArrayList<BOOK> bflist = BOOKDao.selectAllByFid(fid);
			request.setAttribute("bflist", bflist);
			
			SORT sort1 = SORTDao.selectById(fid);
			
			request.setAttribute("sort1", sort1);
			

			
			int bid = p.getBOOK_ID();
		
			ArrayList<CHAPTER> chlist = CHAPTERDao.selectAllByBid(bid);
			request.setAttribute("chlist", chlist);
			
			
			ArrayList<COMMENT> comlist = COMMENTDao.getComByBid(bid);
			request.setAttribute("comlist", comlist);
			
			 HttpSession session =  request.getSession();
			USER user=(USER)session.getAttribute("name");
			request.setAttribute("user", user);
			
			ArrayList<USER>	list= USERDao.selectAll();
			
			//放到请求对象域里
			request.setAttribute("userlist", list);
			
		}
		
		
		request.getRequestDispatcher("bookview.jsp").forward(request, response);
		
	}

}
