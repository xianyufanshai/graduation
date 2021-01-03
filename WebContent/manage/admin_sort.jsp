<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/graduation/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">分类管理</span></div>
        </div>
        
        <div id="register" class="result-wrap">
            <form action="/graduation/manage/admin_tosortadd" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/graduation/manage/admin_tosortadd"><i class="icon-font"></i>新增分类</a>
                        <!--  a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a -->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="60%">
                        <tr>
                            <th>ID</th>
                            <th>分类名称</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="sort" items="${sortlist}">
                        <c:if test="${sort.SORT_PARENT_ID ==0 }">
		                        <tr>
		                        	<td>${sort.SORT_ID }</td>
		                        	<td>|-${sort.SORT_NAME }</td>
		                        	<td><a href="admin_tosortupdate?id=${sort.SORT_ID }">修改</a> <a href="javascript:sortdel(${sort.SORT_ID })">删除</a></td>
		                        
		                        </tr>
		                      	 <c:forEach var="zsort" items="${sortlist}">
		                      	 	<c:if test="${zsort.SORT_PARENT_ID ==sort.SORT_ID  }">
				                      	 <tr>
				                        	<td>${zsort.SORT_ID }</td>
				                        	<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${zsort.SORT_NAME }</td>
		                        	<td><a href="admin_tosortupdate?id=${zsort.SORT_ID }">修改</a> <a href="javascript:sortdel(${zsort.SORT_ID })">删除</a></td>
		                        
				                        
				                        </tr>
				                      </c:if>
		                          </c:forEach>
	                        </c:if>
	                    </c:forEach>
	                     
                        
                        <script>
                        	function sortdel(id) {
                        		if(confirm("确定要删除此分类吗?")) {
                        			location.href="admin_dosortdel?id="+id;
                        			
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