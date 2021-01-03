package com.graduation.servlet.creation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.BOOK;
import com.graduation.service.BOOKDao;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class CreationAdd
 */
@WebServlet("/creationadd")
public class CreationAdd extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//创建SmartUpload对象
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
		
		String bname = req1.getParameter("bookName");
		String id = req1.getParameter("parentId");
		String bwriter = req1.getParameter("writerName");
		String desc = req1.getParameter("bookDecs");
		
		
		BOOK p = new BOOK(
						0,
						bname,
						desc,
						Integer.parseInt(id.split("-")[0]),
						Integer.parseInt(id.split("-")[1]),
						fname,
					    bwriter,
						0
						
						
				);
		
           int count = BOOKDao.insert(p);
		
		//成功或失败重定向到哪里
		
				if(count >0 ) {
					
					response.sendRedirect("mycreation");
				} else {
					PrintWriter out = response.getWriter();
					
					out.write("<script>");
					out.write("alert('图书添加失败')");
					out.write("location.href='creation'");
					out.write("</script>");
					
				}
		
		
		
		
	}
}
