<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device,initial-scale=1.0" />
		<title>我的评论</title>
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
        	<div class="ui container">
        		
        		<!--
                	作者：1913549230@qq.com
                	时间：2020-01-14
                	描述：榜单/更多
                -->
        			<div class="ui top attached segment">
        						<h3 class="ui  teal header  m-text-thin">评论</h3>	
        			</div>
        			<!--
                    	作者：1913549230@qq.com
                    	时间：2020-01-14
                    	描述：图书列表展示
                    -->
        			<div class="ui attached segment">
        				<div class="ui padded vertical segment">
        				   <c:forEach var="com" items="${comlist }">
        				    <div class="ui grid">
        				     <div class="fourteen wide column">
        				      <c:forEach var="b" items="${blist }">
        				   		<c:if test="${com.COM_BID==b.BOOK_ID }">
        					      <div class="content" style="font-size:20px;color:teal;">${b.BOOK_NAME}</div>
        					     </c:if>
        					   </c:forEach>
        					   </br>
        				          <p>${com.COMMENT_CONTENT}</p>
        				   
        				    		<div class="ui horizontal link list">
        				    			<div class="item">
        				    				<i class="calendar icon"></i> ${com.COM_DATE}
        				    			</div>
        				    			<div class="item">
        				    				<i class="eye icon"></i>  ${com.COM_CHECK}
        				    			</div>
        				    		</div>
        				    	</div>
        				    	  <div class="two wide column">
        				    	   <a href="javascript:Delete('你确定要删除该评论吗？', 'mycomdel?comid=${com.COMMENT_ID}')" class="link-del" style="font-size:16px;color:red;">
        								删除
        								</a>
        				    	  </div>
        			           </div>
        				      <div class="ui inverted section divider"></div>
        				   </c:forEach>
        				</div>
        			</div>	
        		
                    <!--
                    	作者：1913549230@qq.com
                    	时间：2020-01-14
                    	描述：最新完结
                    -->
                  
        	</div>
        
        </div>
        <!--
        	作者：1913549230@qq.com
        	时间：2020-01-14
        	描述：底部
        --> <%@ include file="footer.jsp" %>
        <script>
                        	function Delete(mess, url) {
                        		if(confirm(mess)) {
                        			location.href=url;
                        			
                        		}
                        	}
                        
                        </script>
		<script scr="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
		<script scr="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
	</body>
</html>
