<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/graduation/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">公告管理</span></div>
        </div>
        
        <div id="register" class="result-wrap">
            <form action="/graduation/manage/admin_tosortadd" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/graduation/manage/admin_toinformadd"><i class="icon-font"></i>发布公告</a>
                        <!--  a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a -->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="60%">
                        <tr>
                            <th>ID</th>
                            <th>标题</th>
                            <th>发布者</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="in" items="${inlist}">
                      
		                        <tr>
		                        	<td>${in.INFORM_ID }</td>
		                        	<td>${in.i_NAME }</td>
		                        	 <c:forEach var="u" items="${userlist}">
		                        	 <c:if test="${in.i_UID ==u.USER_ID  }">
		                        	<td>${u.USER_NAME }</td>
		                        	</c:if>
		                        	 </c:forEach>
		                        	<td>  <a href="javascript:Delete('你确定要删除该公告吗？', 'admin_doinformdel?inid=${in.INFORM_ID }')" class="link-del" style="font-size:16px;color:red;">
        								删除
        								</a></td>
		                        
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