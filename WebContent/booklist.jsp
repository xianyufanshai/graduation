<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device,initial-scale=1.0" />
		<title>书库</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css"/>
		<link rel="stylesheet" href="css/index.css" />
		<link rel="stylesheet" href="css/public.css" />
	</head>
	<body>
		<div class="head">
	<%@include file="header.jsp" %>
    <div class="wrapper clearfix">
  
        <ul class="clearfix" id="bott">
            <li style="font-size:18px;" >分类：</li>
            <c:forEach var="f" items="${flist }">
            
            <li><a href="selectbooklist?fid=${f.SORT_ID }">${f.SORT_NAME }</a>
                <div class="sList2">
                    <div class="clearfix">
                    	<c:forEach var="c" items="${clist }">
                    		<c:if test="${f.SORT_ID == c.SORT_PARENT_ID }">
                    			<a href="selectbooklist?cid=${c.SORT_ID }">${c.SORT_NAME }</a>
                    		</c:if>
                    	</c:forEach>
                    </div>
                </div>
            </li>
           </c:forEach>
        </ul>
    </div>
</div>
		<!--
        	作者：1913549230@qq.com
        	时间：2020-01-14
        	描述：中间内容
        -->
        <div class="m-padded-tb-large">
        	<div class="ui container">
        	<div class="address">
               <div class="" style="font-size:20px;"><a href="stackselect">书库</a>
                   <span>/</span><span>	</span><a href="" class="on">${title }</a></div>
               </div>
               <br/>
     
               
                <div class="ui attached teal segment">
                	<div class="ui padded vertical  segment">
                	
        					<div class="ui  grid">
        					<c:forEach var="p" items="${list }">
        						<div class="  two wide column">
        								<a href="selectbookview?bid=${p.BOOK_ID }" target="_blank">
        									<img src="images/book/${p.BOOK_FILENAME }" alt="" class="ui rounded image" style="width: 100px;height: 140px;" />
        								</a>
        						</div>
        						<div class=" five wide  column">
        							 <div class="content" ><a href="selectbookview?bid=${p.BOOK_ID }" class="header m-content">${p.BOOK_NAME }</a></div>
        							 <h4 class="item m-text-lined" >${p.BOOK_WRITER }</h4>
        							<p>${p.BOOK_DESCRIPTION }</p>
        						</div>
        					    <div class="  one wide column">
        							
        						</div>
        						</c:forEach>
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
        <%@include file="footer.jsp" %>
		<script scr="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
		<script scr="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
		<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
<script src="js/public.js" type="text/javascript" charset="utf-8"></script>

<script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
<script type="text/javascript">$(function () {
    $('#home_slider').flexslider({
        animation: 'slide',
        controlNav: true,
        directionNav: true,
        animationLoop: true,
        slideshow: true,
        slideshowSpeed: 2000,
        useCSS: false
    });
});</script>
	</body>
</html>