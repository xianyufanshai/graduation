package com.graduation.servlet.chapter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.BOOK;
import com.graduation.entity.CHAPTER;
import com.graduation.service.BOOKDao;
import com.graduation.service.CHAPTERDao;



/**
 * Servlet implementation class ChapterSelect
 */
@WebServlet("/manage/admin_chapterselect")
public class ChapterSelect extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cpage = 1; //当前页
		int count = 5; //每页显示条数
		
		//获取用户指定的页面
		String cp = request.getParameter("cp");
		String bid = request.getParameter("bid");
		BOOK p = BOOKDao.selectByID(Integer.parseInt(bid));
		
		
		//接收用户搜索的关键字
		String keyword = request.getParameter("keywords");
		
		if(cp!=null)
		{
			cpage = Integer.parseInt(cp);
		}
		int bid1 = Integer.parseInt(bid);
		
		int arr[] = CHAPTERDao.totalPage(count,keyword,bid1);
		
		
		//获取所有用户记录
		ArrayList<CHAPTER>	list= CHAPTERDao.selectBookAll(cpage, count, bid,keyword);
	
		//放到请求对象域里
		request.setAttribute("chlist", list);
		request.setAttribute("tsum", arr[0]);
		request.setAttribute("tpage", arr[1]);
		request.setAttribute("cpage", cpage);
		request.setAttribute("p", p);
      
		
		if(keyword != null) {
			request.setAttribute("searchParams", "&keywords="+keyword);
		}
		
		request.getRequestDispatcher("admin_chapter.jsp").forward(request, response);


	}

}
