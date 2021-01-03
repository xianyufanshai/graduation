<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/graduation/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">图书管理</span></div>
        </div>
        <div class="search-wrap">
            <div class="search-content">
                <form action="/graduation/manage/admin_bookselect" method="get">
                    <table class="search-tab">
                        <tr>
                            <!-- th width="120">选择分类:</th>
                            <td>
                                <select name="search-sort" id="">
                                    <option value="">全部</option>
                                    <option value="19">管理员</option><option value="20">读者</option><option value="20">作者</option>
                                </select>
                            </td> -->
                            <th width="70">书籍:</th>
                            <td><input class="common-text" placeholder="书名/关键字" name="keywords" value="${param.keywords}" id="" type="text"></td>
                            <td><input class="btn btn-primary btn2" name="sub" value="查询" type="submit"></td>
                        </tr> 
                    </table>
                </form>
            </div>
        </div>
        
        <div id="register" class="result-wrap">
            <form action="/graduation/manage/admin_dobookdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                        <a href="/graduation/manage/admin_tobookadd"><i class="icon-font"></i>新增图书</a>
                        <!--  a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a -->
                    </div>
                </div>
                <div class="result-content">
                    <table class="result-tab" width="100%">
                        <tr>
                              <th class="tc" width="5%"></th>
                            <th>ID</th>
                            <th>图书名称</th>
                            <th>作者</th>
                            
                            <th>操作</th>
                        </tr>
                        
                         <c:forEach var="p" items="${plist }">
                         <input type="hidden" name="bid" value="${p.BOOK_ID}">
                        	<tr>
                        	<td class="tc"><input name="id[]" value="${u.USER_ID}" type="checkbox"></td>
                        		<td>${p.BOOK_ID }</td>
                        		<td><img src="../images/book/${p.BOOK_FILENAME}" width="80" height="60">
                        			${p.BOOK_NAME }
                        		
                        		</td>
                        		<td>
                        			${p.BOOK_WRITER }
                        		
                        		</td>
                                
                        		<td>
                        			<a class="link-update" href="admin_tobookupdate?id=${p.BOOK_ID}&cpage=${cpage}">修改</a>
                        		<a class="link-del" href="javascript:Delete('你确定要删除书籍【${p.BOOK_NAME}】吗？','/graduation/manage/admin_dobookdel?id=${p.BOOK_ID}&cpage=${cpage }')">删除</a>
                        		 <a href="admin_chapterselect?bid=${p.BOOK_ID }">章节列表</a>
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
                      <div class="list-page"> 
                    	共 ${tsum} 条记录， 当前 ${cpage}/${tpage} 页
                    	<a href="admin_bookselect?cp=1${searchParams}">首页</a>
                    	<a href="admin_bookselect?cp=${cpage-1<1?1:cpage-1}${searchParams}">上一页</a>
                    	<a href="admin_bookselect?cp=${cpage+1>tpage?tpage:cpage+1}${searchParams}">下一页</a>
                    	<a href="admin_bookselect?cp=${tpage}${searchParams}">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>