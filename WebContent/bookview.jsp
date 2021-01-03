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
           		    <div class="ui grid">
        				<div class="  six wide column">
        					
        						<img src="images/book/${p.BOOK_FILENAME}" alt="" class="ui rounded image" style="width: 350px;height: 400px;" />
        					
        				</div>
        				    <div class=" one wide column">
        						
        					</div>
        					<div class=" eight wide column " >
        					     <br/>
        					     
                               <button id="payButton" class="ui orange basic circular button" style="float:right;">打赏本站</button>
                               
                                 <div class="ui payQR flowing popup transition hidden">
                                <div class="ui orange basic label">
                                  <div class="ui images" style="font-size: inherit !important;">
                                <div class="image">
                                <img src="images/zfb.jpg" " alt="" class="ui rounded bordered image" style="width: 120px">
                               <div>支付宝</div>
                                  </div>
                                   <div class="image">
                                  <img src="images/wx.png" " alt="" class="ui rounded bordered image" style="width: 120px">
                                  <div>微信</div>
                                 </div>
                                </div>
                             </div>
                             </div>
                               
        						 <h1 class="ui  teal header  m-text-thin">${p.BOOK_NAME}</h1>
        						 	  
        						 <div class="ui labeled ">
        					   <div class="ui basic teal top pointing label" style="font-size:34;">
        					   
        					   
        					   ${sort1.SORT_NAME}</div>
        					   <div class="ui basic teal top pointing label">${sort.SORT_NAME}</div>
        				      </div>
        	 
        			
        						<h3 class="item m-text-lined" >作者：${p.BOOK_WRITER}</h3>
        						<div class="ui  segment">
                		         <h4 class="item" >简介：</h4>
                		            <div class="content">
                			          <p class="m-text-lined">${p.BOOK_DESCRIPTION}
                			                                 </p>
                		                </div>
        		               </div>
        		                  <c:forEach var="c" items="${chlist }">
        		                  <c:if test="${c.CHAPTER_ID==chlist[0].CHAPTER_ID }">
        						   <a href="selectchapterview?cid=${chlist[0].CHAPTER_ID}&bid=${p.BOOK_ID}" class="ui teal button">立即阅读</a>
        					       </c:if>   
        					           
        					            </c:forEach>
        							<a href="bookadd?id=${p.BOOK_ID}" class="ui teal button">加入书架</a>
        				
        						
        					</div>
        					 <div class=" one wide column">
        						
        					</div>
        					
        		    </div>
                </div>    
    <div class="ui attached segment">
                		<div class="introMsg wrapper clearfix">
    <div class="msgL fl">
        <div class="msgTit clearfix"><a class="on">书籍章节</a><a>所有评论</a></div>
        <div class="msgAll">
            <div class="ui fluid vertical menu">
                     <c:forEach var="c" items="${chlist }">
        				<a href="selectchapterview?cid=${c.CHAPTER_ID}&bid=${p.BOOK_ID}" class="item">
        					${c.CHAPTER_NAME}
        				</a>
        		     </c:forEach>
        	</div>	
            <div class="eva">
               <div class="ui padded vertical segment">
               <c:forEach var="com" items="${comlist }">
        				    <p>${com.COMMENT_CONTENT }</p>
        				    		<div class="ui horizontal link list">
        				    			<div class="item">
        				    				<img src="images/h01.png" alt="" class="ui avatar image"/>
        				    		 <c:forEach var="u" items="${userlist}">
        				    				<c:if test="${com.COM_UID==u.USER_ID}">
                    			            <a href="#" class="header">${u.USER_NAME }</a>
                    		                </c:if>
        				    	       </c:forEach>     
        				    			</div>
        				    			<div class="item">
        				    				<i class="calendar icon"></i> ${com.COM_DATE }
        				    			</div>
        				    			<div class="item">
        				    				<i class="eye icon"></i>${com.COM_CHECK }
        				    			</div>
        				    		</div>
        			
        		      <div class="ui inverted section divider"></div>
        			 </c:forEach>	    
            </div>
            <div class="ui field">
        		   	<form action="docommentadd" method="post" class="ui form">
        		      	<input type="hidden" name="bid" value="${p.BOOK_ID}">
        		      	<input type="hidden" name="uid" value="${user.USER_ID}">
        		      	
        		      	<div  id="md-content">
        		      	   <textarea id="content" name="content" style="display:none;"></textarea>
        		      	</div>
                		<div class="ui right aligned container">
                		 <input class="ui teal button" value="发送" type="submit">
                	</div>
        		      
                	</form>
                		
        		      </div>
            
        </div>
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
        <script src="https://cdn.jsdelivr.net/npm/jquery@3.2.1/dist/jquery.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
		<script src="lib/editormd/editormd.min.js"></script>
		 <script type="text/javascript">
			var testEditor;
            $(function() {
            	
                testEditor = editormd("md-content", {
                    width   : "100%",
                    height  : 300,
                    syncScrolling : "single",
                    path    : "./lib/editormd/lib/"
                });
            });
            
            $(".msgTit a").click(function () {
                var c = $(this).index();
                $(this).addClass("on").siblings().removeClass("on");
                $(".msgAll").children("div").eq(c).show().siblings().hide()
            });
          
            $('#payButton').popup({
                popup : $('.payQR.popup'),
                on : 'click',
                position: 'bottom center'
              });
          
            $("#content").val(md_edit.getTEXT());

        </script>
          <script type="text/javascript">
            editormd.markdownToHTML("content", {
                htmlDecode      : "style,script,iframe",
                emoji           : true,
                taskList        : true,
                tex             : true,  // 默认不解析
                flowChart       : true,  // 默认不解析
                sequenceDiagram : true  // 默认不解析
            });
        </script>
            
	</body>
</html>
