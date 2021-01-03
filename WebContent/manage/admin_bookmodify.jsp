<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_bookselect">图书管理</a><span class="crumb-step">&gt;</span><span>修改图书</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/graduation/manage/admin_dobookupdate" method="post"  enctype="multipart/form-data" id="myform" name="myform">
					    <input type="hidden" name="id" value="${p.BOOK_ID}">
					    
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                                <th><i class="require-red">*</i>图书名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="name" size="50" value="${p.BOOK_NAME}" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th><i class="require-red">*</i>图书分类：</th>
                                <td>
                                    <select class="common-text required"  name="parentId">
                                    	<c:forEach var="f" items="${flist }">
                                    	       <option value="${f.SORT_ID }" disabled="disabled">|-${f.SORT_NAME } </option>
                                                     
                                    				 <c:forEach var="c" items="${clist }">
                                    				 <c:if test="${c.SORT_PARENT_ID == f.SORT_ID}">
                                    				<option value="${f.SORT_ID }-${c.SORT_ID }" <c:if test="${c.SORT_ID == p.BOOK_CID}">selected</c:if>> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${c.SORT_NAME } </option>
                                    			    </c:if>
                                    			</c:forEach>
                                    			  
                                    	        
                                    	</c:forEach>
                                    </select>
                                      <input type="hidden" name="bfid" value="${p.BOOK_FID}">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>图书图片：</th>
                                <td>
                                  
                                    <input class="common-text required" id="title" name="file" size="50" value="" type="file">
                                    <img src="../images/book/${p.BOOK_FILENAME}" width="80" height="80">
                                </td>
                            </tr>
                            
                            
                            <tr>
                                <th><i class="require-red">*</i>图书作者：</th>
                                <td>
                                    <input class="common-text required" id="title" name="writer" size="50" value="${p.BOOK_WRITER}" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>图书简介：</th>
                                <td>
                                    <textarea style="width:425px;height:100px;border-radius:10px" name="decs">${p.BOOK_DESCRIPTION}</textarea>
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>图书点击量：</th>
                                <td>
                                    <input class="common-text required" id="title" name="check" size="50" value="${p.BOOK_CHECK}" type="text">
                                </td>
                            </tr>
                         
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="修改" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>


</html>