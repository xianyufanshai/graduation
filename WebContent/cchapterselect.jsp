<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device,initial-scale=1.0" />
		<title>首页</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css"/>
		<link rel="stylesheet" href="lib/editormd/css/editormd.min.css" />
		<link rel="stylesheet" href="css/index.css" />
		
	</head>
	<body>
	<%@ include file="header.jsp" %>
		<!--
        	作者：1913549230@qq.com
        	时间：2020-01-14
        	描述：中间内容
        -->
        <div class="m-padded-tb-large">
        	<div class="ui m-container">
        		<div class="ui top attached  teal segment">
        		     <div class="ui two column grid">
        						<div class="column">
        						     <h3>${p.BOOK_NAME }</h3>
        						</div>
        						<div class="right aligned column">
        							<a href="chaptercreation?bid=${p.BOOK_ID}" class="item" style="font-size:17px;color:red;">
        				                                          新增章节
        			               	</a>
        						</div>
        			  </div>
        		
                 </div>    
         <div class="ui attached segment">
         <c:forEach var="c" items="${chlist }">
         <input type="hidden" name="bid" value="${p.BOOK_ID }">
            <div class="ui two column grid">
        						<div class="column">
        						    <a href="selectchapterview?cid=${c.CHAPTER_ID}&bid=${p.BOOK_ID}" class="item" style="font-size:17px;">
        				                                       ${c.CHAPTER_NAME }
        			               	</a>
        						</div>
        						<div class="right aligned column">
        							<a href="cchapterdel?cid=${c.CHAPTER_ID }&bid=${p.BOOK_ID}" class="item" style="font-size:17px;color:red;">
        				                                          删除章节
        			               	</a>
        						</div>
        			  </div>
        	
             </c:forEach>    
          </div>
        </div>		
        		
        </div>
        
    
        <!--
        	作者：1913549230@qq.com
        	时间：2020-01-14
        	描述：底部
        -->
        <%@ include file="footer.jsp" %>
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.2.1/dist/jquery.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
	
		 
          
            
	</body>
</html>
