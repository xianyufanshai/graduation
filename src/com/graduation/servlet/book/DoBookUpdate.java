package com.graduation.servlet.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.BOOK;
import com.graduation.entity.SORT;
import com.graduation.service.BOOKDao;
import com.graduation.service.SORTDao;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class DoBookUpdate
 */
@WebServlet("/manage/admin_dobookupdate")
public class DoBookUpdate extends HttpServlet {
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		SmartUpload su= new SmartUpload();
		
		//初使化
		su.initialize(this.getServletConfig(), request, response);
		
		//上传过程
		try {
			su.upload();
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//获取上传的文件对象
		Files fs= su.getFiles();
		File f = fs.getFile(0);
		//获取上传的文件名称
		String fname = f.getFileName();
	        
		
		try {
			su.save("images/book");
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        Request req1 = su.getRequest();
       
       
        String bid = req1.getParameter("id");
		String bname = req1.getParameter("name");
		String id = req1.getParameter("parentId");
		String bwriter = req1.getParameter("writer");
		String desc = req1.getParameter("decs");
		String check = req1.getParameter("check");
		
		BOOK p = new BOOK(
				        Integer.parseInt(bid),
						bname,
						desc,
						Integer.parseInt(id.split("-")[0]),
						Integer.parseInt(id.split("-")[1]),
						fname,
					    bwriter,
						Integer.parseInt(check)
						
						
				);
		
           int count = BOOKDao.update(p);
		
		//成功或失败重定向到哪里
		
				if(count >0 ) {
					
					response.sendRedirect("admin_bookselect");
				} else {
					PrintWriter out = response.getWriter();
					
					out.write("<script>");
					out.write("alert('图书添加失败')");
					out.write("location.href='manage/admin_tobookupdate'");
					out.write("</script>");
					
				}
		
		
	}

}
