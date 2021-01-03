<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="admin_menu.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="admin_index.jsp">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_bookselect">图书管理</a><span class="crumb-step">&gt;</span><span>新增图书</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/graduation/manage/admin_dobookadd" method="post"  enctype="multipart/form-data" id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                                <th><i class="require-red">*</i>图书名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="bookName" size="50" value="" type="text">
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
                                    				<option value="${f.SORT_ID }-${c.SORT_ID }"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;|-${c.SORT_NAME } </option>
                                    			    </c:if>
                                    	
                                    			</c:forEach>
                                    	</c:forEach>
                                    </select>
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>图书图片：</th>
                                <td>
                                    <input class="common-text required" id="title" name="pic" size="50" value="" type="file">
                                </td>
                            </tr>
                            
                            
                            <tr>
                                <th><i class="require-red">*</i>图书作者：</th>
                                <td>
                                    <input class="common-text required" id="title" name="bookWriter" size="50" value="" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>图书简介：</th>
                                <td>
                                    <textarea style="width:425px;height:100px;border-radius:10px" name="bookDecs" ></textarea>
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>图书点击量：</th>
                                <td>
                                    <input class="common-text required" id="title" name="bookCheck" size="50" value="" type="text">
                                </td>
                            </tr>
                         
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
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