<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device,initial-scale=1.0" />
		<title>我的创作</title>
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
        	
        						
        					   <a href="creation" class="ui blue header" style="font-size:20px;">开始创作</a>	
  
        			<!--
                    	作者：1913549230@qq.com
                    	时间：2020-01-14
                    	描述：图书列表展示
                    -->
        			<div class="ui teal segment">
        						<h3 class="ui  teal header  m-text-thin">我的作品管理</h3>	
        
        			<!--
                    	作者：1913549230@qq.com
                    	时间：2020-01-14
                    	描述：图书列表展示
                    -->
        			<div class="ui attached segment">
        				<div class="ui padded vertical segment">
        				 <c:forEach var="p" items="${blist}">
        					<div class="ui grid">
        					 
        					  
        						<div class="  one wide column">
        						<input type="checkbox" name="id[]" value="${p.BOOK_ID}" style="height:18px;width:18px;"/>
		
        						</div>
        						<div class="  two wide column">
        						<a href="selectbookview?bid=${p.BOOK_ID}" target="_blank">
        									<img src="images/book/${p.BOOK_FILENAME} " alt="" class="ui rounded image" style="width: 100px;height: 140px; "/>
        								</a>		
        						</div>
        						<div class=" four wide column">
        							 <div class="content" ><a href="selectbookview?bid=${p.BOOK_ID}" class="header m-content">${p.BOOK_NAME}</a></div>
        							 </br>
        							 <div class="ui labeled ">
        							 <c:forEach var="f" items="${flist}">
        							      <c:if test="${p.BOOK_FID==f.SORT_ID }">
        					                <div class="ui basic teal top pointing label" style="font-size:34;">
        					                    ${f.SORT_NAME}</div>
        					               </c:if>
        					           </c:forEach>
        				              <c:forEach var="c" items="${clist}">
        							      <c:if test="${p.BOOK_CID==c.SORT_ID }">
        					                <div class="ui basic teal top pointing label" style="font-size:34;">
        					                    ${c.SORT_NAME}</div>
        					               </c:if>
        					           </c:forEach>
        				             </div>
        							 <h4 class="item m-text-lined" >作者：${p.BOOK_WRITER} </h4>
        						</div>
        						<div class=" six wide column">
        							 <h4 class="item m-text-lined" style="font-size:16px" >简介： </h4>
        							 <p class="m-text-lined m-text-spaced" style="font-size:15px" >${p.BOOK_DESCRIPTION}</p>
        								 
        						</div>
        						<div class=" one  wide column">
        					         
        						</div>
        						<div class=" two wide column">
        						<br>
        						<div>
        							 <a href="ccreationselect?bid=${p.BOOK_ID}" class="link-add" style="font-size:18px;color:red;">
        								章节管理
        								</a>
        						</div>
        						<br>
        							<div>
        								 <a href="cbookupdate?bid=${p.BOOK_ID}" class="link-del" style="font-size:18px;color:red;">
        								信息修改
        							</a>
        							</div>
        						<br>
        						
        								 <a href="javascript:Delete('你确定要删除书籍 【${p.BOOK_NAME} 】吗？', 'cbookdel?bid=${p.BOOK_ID}')" class="link-del" style="font-size:18px;color:red;">
        								删除
        								</a>
        								
        						</div>
        						
        				</div>
        				<div class="ui inverted section divider"></div>
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
