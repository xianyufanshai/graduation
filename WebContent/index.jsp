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
		<link rel="stylesheet" href="css/index.css" />
		
         <link rel="stylesheet" type="text/css" href="css/public.css"/>
	</head>
	<body  οnlοad="hiddenImg()">
	   <%@ include file="header.jsp" %>
		<!--
        	作者：1913549230@qq.com
        	时间：2020-01-14
        	描述：中间内容
        -->
        <div class="m-padded-tb-large">
        	<div class="ui container">
        		<div class="ui grid">
        		<div class="eleven wide column">
        	
        	
        	<div class="block_home_slider">
                    <div id="home_slider" class="flexslider">
                      <ul class="slides">
                             <li>
                             <div class="slide"><img src="images/lb7.jpg" style="width:1000px;height:350px;"/></div>
                               </li>
                             <li>
                              <div class="slide"><img src="images/lb2.jpg" style="width:1000px;height:350px;"/></div>
                             </li>
                              <li>
                             <div class="slide"><img src="images/lb8.jpg" style="width:1000px;height:350px;"/></div>
                               </li>
                             <li>
                              <div class="slide"><img src="images/lb4.jpg" style="width:1000px;height:350px;"/></div>
                             </li>
                      </ul>
                 </div>
           </div>
                    <!--
                    	作者：1913549230@qq.com
                    	时间：2020-01-14
                    	描述：最新完结
                    -->
                    <div class="ui top attached segment">
        						<h3 class="ui  teal header  m-text-thin">热门推荐</h3>	
        			</div>
        			<!--
                    	作者：1913549230@qq.com
                    	时间：2020-01-14
                    	描述：图书列表展示
                    -->
        			<div class="ui attached segment">
        				<div class="ui padded vertical segment">
        				     <c:forEach var="b" items="${blist }">
        				       <c:if test="${b.BOOK_ID==blist[0].BOOK_ID }">
        					<div class="ui grid">
        						<div class="  three wide column">
        								<a href="selectbookview?bid=${b.BOOK_ID }" target="_blank">
        									<img src="images/book/${b.BOOK_FILENAME }" alt="" class="ui rounded image" style="width: 100px;height: 140px;" />
        								</a>
        						</div>
        						<div class=" twelve wide column">
        							 <div class="content" ><a href="selectbookview?bid=${b.BOOK_ID }" class="header m-content">${b.BOOK_NAME }</a></div>
        							 <h4 class="item m-text-lined" >作者：${b.BOOK_WRITER }</h4>
        							<p class="m-text-spaced m-text-lined">${b.BOOK_DESCRIPTION }</p>
        						</div>
        						
        					</div>
        					</c:if>
        					</c:forEach>
        					 <div class="ui inverted section divider"></div>
        					<c:forEach var="b" items="${blist }">
        				       <c:if test="${b.BOOK_ID==blist[1].BOOK_ID }">
        					<div class="ui grid">
        						<div class="  three wide column">
        								<a href="selectbookview?bid=${b.BOOK_ID }" target="_blank">
        									<img src="images/book/${b.BOOK_FILENAME }" alt="" class="ui rounded image" style="width: 100px;height: 140px;" />
        								</a>
        						</div>
        						<div class=" twelve wide column">
        							 <div class="content" ><a href="selectbookview?bid=${b.BOOK_ID }" class="header m-content">${b.BOOK_NAME }</a></div>
        							 <h4 class="item m-text-lined" >作者：${b.BOOK_WRITER }</h4>
        							<p class="m-text-spaced m-text-lined">${b.BOOK_DESCRIPTION }</p>
        						</div>
        						
        					</div>
        					</c:if>
        					</c:forEach>
        				</div>
        			</div>	
                    
                    <!--
                    	作者：1913549230@qq.com
                    	时间：2020-01-14
                    	描述：热门评论
                    -->
                     <div class="ui top attached segment">
        						<h3 class="ui  teal header  m-text-thin">最新评论</h3>	
        			</div>
        			<!--
                    	作者：1913549230@qq.com
                    	时间：2020-01-14
                    	描述：评论展示
                    -->
        			<div class="ui attached segment">
        				<div class="ui padded vertical segment">
        				 <c:forEach var="com" items="${comlist }">
        				     <c:if test="${com.COMMENT_ID==comlist[0].COMMENT_ID }">
        				      <c:forEach var="b" items="${blist }">
        				      <c:if test="${com.COM_BID==b.BOOK_ID }">
        					   <div class="content" style="font-size:18px;">有关：${b.BOOK_NAME }</div>
        					 </c:if>
        					 </c:forEach>
        					  <br>
        				    <p class="m-text-spaced m-text-lined">${com.COMMENT_CONTENT}</p>
        				   
        				    		<div class="ui horizontal link list">
        				    			<div class="item">
        				    				<img src="images/h01.png" alt="" class="ui avatar image"/>
        				    				<c:forEach var="u" items="${userlist }">
        				                   <c:if test="${com.COM_UID==u.USER_ID }">
        					                <div class="content" >${u.USER_NAME }</div>
        					                    </c:if>
        					                 </c:forEach>
        				    			</div>
        				    			<div class="item">
        				    				<i class="calendar icon"></i>${com.COM_DATE}
        				    			</div>
        				    			<div class="item">
        				    				<i class="eye icon"></i>${com.COM_CHECK}
        				    			</div>
        				    		</div>
        				    	</c:if>
        			        </c:forEach>
        				    <div class="ui inverted section divider"></div>
        				    
        				    
        				    
        				     <c:forEach var="com" items="${comlist }">
        				     <c:if test="${com.COMMENT_ID==comlist[1].COMMENT_ID }">
        				      <c:forEach var="b" items="${blist }">
        				      <c:if test="${com.COM_BID==b.BOOK_ID }">
        					   <div class="content" style="font-size:18px;">有关：${b.BOOK_NAME }</div>
        					 </c:if>
        					 </c:forEach>
        					 <br>
        				    <p class="m-text-spaced m-text-lined">${com.COMMENT_CONTENT}</p>
        				   
        				    		<div class="ui horizontal link list">
        				    			<div class="item">
        				    				<img src="images/h01.png" alt="" class="ui avatar image"/>
        				    				<c:forEach var="u" items="${userlist }">
        				                   <c:if test="${com.COM_UID==u.USER_ID }">
        					                <div class="content" >${u.USER_NAME }</div>
        					                    </c:if>
        					                 </c:forEach>
        				    			</div>
        				    			<div class="item">
        				    				<i class="calendar icon"></i>${com.COM_DATE}
        				    			</div>
        				    			<div class="item">
        				    				<i class="eye icon"></i>${com.COM_CHECK}
        				    			</div>
        				    		</div>
        				    	</c:if>
        			        </c:forEach>        				</div>
        			</div>	
        		</div>
               <!--
               	作者：1913549230@qq.com
               	时间：2020-01-15
               	描述：右边部分
               -->
        		<div class="five wide column">
        			<div class="ui  segments">
        		<div class="ui secondary segment">
                     <h3 class="ui  teal header  m-text-thin">最新公告</h3>	
        						
        		</div>
        		<div class="ui teal segment">
        			   <c:forEach var="in" items="${inlist }">
        			    <c:if test="${in.INFORM_ID==inlist[0].INFORM_ID }">
        				<div class="ui header">
        					标题：${in.i_NAME }
        				</div>
        				<div class="calendar">${in.i_DATE }</div>
        				<p class="m-text-spaced m-text-lined" >
        					${in.i_CONTENT }
        				</p>
        				</c:if>
        				 </c:forEach>
        			       
        			       <div class="ui inverted section divider"></div>
        			       <c:forEach var="in" items="${inlist }">
        			    <c:if test="${in.INFORM_ID==inlist[1].INFORM_ID }">
        				<div class="ui header">
        					标题：${in.i_NAME }
        				</div>
        				<div class="calendar">${in.i_DATE }</div>
        				<p class="m-text-spaced m-text-lined" >
        					${in.i_CONTENT }
        				</p>
        				</c:if>
        				 </c:forEach>  
        				 <div class="ui inverted section divider"></div>
        			       <c:forEach var="in" items="${inlist }">
        			    <c:if test="${in.INFORM_ID==inlist[2].INFORM_ID }">
        				<div class="ui header">
        					标题：${in.i_NAME }
        				</div>
        				<div class="calendar">${in.i_DATE }</div>
        				<p class="m-text-spaced m-text-lined" >
        					${in.i_CONTENT }
        				</p>
        				</c:if>
        				 </c:forEach>  
        				 <div class="ui inverted section divider"></div>
        			       <c:forEach var="in" items="${inlist }">
        			    <c:if test="${in.INFORM_ID==inlist[3].INFORM_ID }">
        				<div class="ui header">
        					标题：${in.i_NAME }
        				</div>
        				<div class="calendar">${in.i_DATE }</div>
        				<p class="m-text-spaced m-text-lined" >
        					${in.i_CONTENT }
        				</p>
        				</c:if>
        				 </c:forEach>  
        				
        			</div>
        			   
        			</div>
        			<div class="ui  segments">
        				<div class="ui  segment">
        					<div class="ui two column grid">
        					
        						<div class="column">
        							<h3 class="ui  teal header  m-text-thin">最近访问</h3>
        						</div>
        					</div>
        				</div>
        			<div class="ui teal segment">
        				<div class="ui fluid vertical menu">
        				<a href="#" class="item">
        					大话西游
        					<div class="calendar">20-01-09</div>
        				</a>
        				
        				<a href="#" class="item">
        					活着
        					<div class="calendar">20-01-09</div>
        				</a>
        				<a href="#" class="item">
        					红楼梦
        					<div class="calendar">20-01-09</div>
        				</a>
        				<a href="#" class="item">
        					生活日志
        					<div class="calendar">20-01-09</div>
        				</a>
        				<a href="#" class="item">
        					
        					<div class="calendar"></div>
        				</a>
        				<a href="#" class="item">
        					
        					<div class="calendar"></div>
        				</a>
        			</div>
        		</div>
        	</div>
        	
        			      <div class="ui  segment">
        			     	<div class="column">
        							<h3 class="ui  teal header  m-text-thin">小故事大道理</h3>		
        					</div>
        					<div class="ui teal segment">
        					<div class="item">
        						<p class="m-text-lined">一位大妈误加入一个博士群里。有人提问：一滴水从很高很高的地方自由落体下来，
        							砸到人会不会砸伤或砸死?群里一下就热闹起来，各种公式，各种假设，各种阻力，重力，
        							加速度的计算，足足讨论了近一个小时。这时大妈默默问了一句：你们没有淋过雨吗 ?
        							群里突然死一般的寂静……然后，然后大妈就被踢出群了。其实知识可以给你带来更多思考方式，
        							但是经验可以让你更快地解决问题。</p>
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
         

		<script scr="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
		<script scr="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
		<script src="js/jquery-1.12.4.min.js" type="text/javascript" charset="utf-8"></script>
         <script src="js/jquery.flexslider-min.js" type="text/javascript" charset="utf-8"></script>
        <script type="text/javascript">$(function () {
                  $('#home_slider').flexslider({
                      animation: 'slide',
                      controlNav: false,
                      directionNav: false,
                      animationLoop: true,
                      slideshow: true,
                      slideshowSpeed: 2000,
                      useCSS: false
                       });
                    });</script>
	</body>
</html>