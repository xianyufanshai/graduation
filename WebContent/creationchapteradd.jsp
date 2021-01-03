<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device,initial-scale=1.0" />
		<title>新增创作</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css"/>
		<link rel="stylesheet" href="css/index.css" />
	</head>
	<body>
		<!--
        	作者：1913549230@qq.com
        	时间：2020-01-14
        	描述：导航
        -->
         <%@ include file="header.jsp" %>
		<!--
        	作者：1913549230@qq.com
        	时间：2020-01-14
        	描述：中间内容
        -->
        <div class="m-padded-tb-large">
        	<div class="ui m-container">
        	    <h3 style="font-size:20px;">图书章节列表</h3>
            <div class="ui attached segment " style="background: url(images/m3.jpg);">
            	<form action="ccreationadd?bid=${p.BOOK_ID }" method="post"  enctype="multipart/form-data"   id="myform" name="myform">
            	<input type="hidden" name="bid" value="${p.BOOK_ID }">
                    <table class="insert-tab" width="100%">
                  
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>图书名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="Bname" size="50" value="${p.BOOK_NAME }" type="text" >
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>章节名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="Cname" size="50" value="" type="text" >
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>章节文件：</th>
                                <td>
                                    <input class="common-text required" id="title" name="pic" size="50" value="" type="file">
                                </td>

                            </tr>
                            
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="确认" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="取消" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
        </div>
     </div>
     </div>  
        <!--
        	作者：1913549230@qq.com
        	时间：2020-01-14
        	描述：底部
        -->
     <%@ include file="footer.jsp" %>
		<script scr="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
		<script scr="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
	</body>
</html>
