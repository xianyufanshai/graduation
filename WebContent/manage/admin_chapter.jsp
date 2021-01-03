<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/graduation/manage/admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><span class="crumb-name">章节列表</span></div>
        </div>
        
        <div id="register" class="result-wrap">
            <form action="/graduation/manage/admin_douserdel" id="myform" method="post">
                <div class="result-title">
                    <div class="result-list">
                          <h3>${p.BOOK_NAME}</h3>
                        <a href="/graduation/manage/admin_tochapteradd?bid=${p.BOOK_ID}"><i class="icon-font"></i>新增章节</a>
                        <!--  a id="updateOrd" href="javascript:void(0)"><i class="icon-font"></i>更新排序</a -->
                    </div>
                </div>
                <div class="result-content">
                <input type="hidden" name="bid" value="${p.BOOK_ID}/">
                    <table class="result-tab" width="100%">
                        <tr>
                            <th class="tc" width="5%"></th>
                            <th>ID</th>
                            <th>章节名</th>
                            <th>章节内容</th>
                            <th>书名</th>
                            <th>操作</th>
                        </tr>
                        
                        <c:forEach var="c" items="${chlist}">
	                        <tr>	
	                            <td class="tc"><input name="id[]" value="${c.CHAPTER_ID}" type="checkbox"></td>
	                            <td> ${c.CHAPTER_ID  }</td>
	                             <td> ${c.CHAPTER_NAME  }</td>
	                              <td> ${c.c_FILENAME }</td>
	                               <td> ${c.c_BNAME  }</td>
	                            <td>
	                                <a class="link-update" href="admin_tochapterupdate?cid=${c.CHAPTER_ID}&bid=${p.BOOK_ID}">修改</a>
	                              
	                                <a class="link-del" href="javascript:Delete('你确定要删除【${c.c_BNAME}】的章节吗？', '/graduation/manage/admin_dochapterdel?cid=${c.CHAPTER_ID}&bid=${p.BOOK_ID}')">删除</a>
	                       
	                            
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
                    	<a href="admin_chapterselect?bid=${p.BOOK_ID}&cp=1${searchParams}">首页</a>
                    	<a href="admin_chapterselect?bid=${p.BOOK_ID}&cp=${cpage-1<1?1:cpage-1}${searchParams}">上一页</a>
                    	<a href="admin_chapterselect?bid=${p.BOOK_ID}&cp=${cpage+1>tpage?tpage:cpage+1}${searchParams}">下一页</a>
                    	<a href="admin_chapterselect?bid=${p.BOOK_ID}&cp=${tpage}${searchParams}">尾页</a>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!--/main-->
</div>
</body>
</html>