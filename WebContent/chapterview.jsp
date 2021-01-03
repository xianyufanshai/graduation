<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device,initial-scale=1.0" />
		<title>章节阅读</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css"/>
		<link rel="stylesheet" href="css/index.css" />
		
	</head>
	<body>

        <%@ include file="header.jsp" %>
		<!--
        	作者：1913549230@qq.com
        	时间：2020-01-14
        	描述：中间内容
        -->
        <div class=" m-container  m-padded-tb-large">
        	<div class="ui container">
        		<div class="ui top attached   segment">
        		     <div class="ui padded vertical segment">
                    	<div class="ui middle two column grid">
        					<div class="column">
        					<input type="hidden" name="session" value="${sessionScop.name}">
        						<a href="selectbookview?bid=${p.BOOK_ID}" class="header m-content">${p.BOOK_NAME}</a>
        					</div>
        					<div class="right aligned column">
        						<a href="#" class="m-item item m-mobile-hide">作者：${p.BOOK_WRITER}</a>
        					</div>
        				</div>
                    </div>
        		</div>
        		<div class="ui attached segment ">
        			<div class="ui padded vertical segment">
        					<div class="column">
        						<h3 class="ui  center aligned header">${ch.CHAPTER_NAME}</h3>
        						<br />
        					</div>
        					<div id="content"  name="div1" class="typo typo-selection m-padded-lr">
						
                                    <div class="cont  m-text-lined" style="font-size:18px;"></div>
	 </div>
        			</div>
        		</div>
        	</div>
        </div>	
        <!--
        	作者：1913549230@qq.com
        	时间：2020-01-14
        	描述：底部
        -->
        <%@ include file="footer.jsp" %>
        <script type="text/javascript" language="javascript">
        var ajx = new XMLHttpRequest()  
        
        var url
        url=encodeURI("images/chapter/${ch.c_FILENAME}");
        url=encodeURI("images/chapter/${ch.c_FILENAME}");
        ajx.open("GET",url,true)
   
        
        ajx.onreadystatechange = function(){
            if(ajx.readyState!=4){
                return;
            }
            if(ajx.status>=200 && ajx.status<300){
                
                document.querySelector('.cont').innerHTML = ajx.responseText
            }
        }
       
        ajx.send()
   </script>
        
  
		<script scr="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
		<script scr="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
	</body>
</html>
