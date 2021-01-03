<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/graduation/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">图书管理</span></div>
        </div>
        <div id="register" class="result-wrap">
            <form action="/graduation/manage/admin_dobookdel" id="myform" method="post">
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                              <th class="tc" width="5%"></th>
                            <th>ID</th>
                            <th>时间</th>
                            <th>书籍</th>
                            <th>用户</th>
                            <th>操作</th>
                        </tr>
                        
                         <c:forEach var="com" items="${comlist }">
                        	<tr>
                        	<td class="tc"><input name="id[]" value="${com.COMMENT_ID}" type="checkbox"></td>
                        		<td>${com.COMMENT_ID }</td>
                        		<td >
                        		  
                        			${com.COM_DATE }
                        		
                        		</td>
                        		<td>
                        		  <c:forEach var="b" items="${blist }">
                        		  <c:if test="${com.COM_BID==b.BOOK_ID }">
                        			 ${b.BOOK_NAME }
                        		 </c:if>
                        		   </c:forEach>
                        		</td>
                                <td>
                        			<c:forEach var="u" items="${userlist }">
                        		  <c:if test="${com.COM_UID==u.USER_ID }">
                        			 ${u.USER_NAME }
                        		 </c:if>
                        		   </c:forEach>
                        		</td>
                        		<td>
                        		<a class="link-del" href="javascript:Delete('你确定要删除评论吗？','/graduation/manage/admin_docommentdel?comid=${com.COMMENT_ID}')">删除</a>
                        		 
                        		</td>
                        	</tr>
                
	                    </c:forEach>
                        
                        <script>
                        function Delete(mess, url) {
                    		if(confirm(mess)) {
                    			location.href=url;
                    			
                    		}
                    	}
                        	
                        </script>
                        
                    </table>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>