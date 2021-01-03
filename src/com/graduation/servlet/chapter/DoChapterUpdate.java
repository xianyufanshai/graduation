package com.graduation.servlet.chapter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.graduation.entity.CHAPTER;
import com.graduation.service.CHAPTERDao;
import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

/**
 * Servlet implementation class DoChapterUpdate
 */
@WebServlet("/manage/admin_dochapterupdate")
public class DoChapterUpdate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
			su.save("images/chapter");
		} catch (SmartUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        Request req1 = su.getRequest();
        int cid = Integer.parseInt(req1.getParameter("cid"));
		String cname = req1.getParameter("Cname");
		String bname = req1.getParameter("Bname");
		int bid = Integer.parseInt(req1.getParameter("Bid"));
		
		CHAPTER c = new CHAPTER(
						cid,
						cname,
						fname,
						bname,
						bid
				);
		
           int count = CHAPTERDao.update(c);
		
		//成功或失败重定向到哪里
		
				if(count >0 ) {
					
					response.sendRedirect("admin_chapterselect?bid="+bid+"");
				} else {
					PrintWriter out = response.getWriter();
					
					out.write("<script>");
					out.write("alert('章节添加失败')");
					out.write("location.href='manage/admin_tobookadd'");
					out.write("</script>");
					
				}
		
		
	}
	}

