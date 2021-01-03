<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device,initial-scale=1.0" />
		<title>修改创作</title>
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
        	<div class="ui m-container">
        	    <h3 style="font-size:20px;">图书基本信息</h3>
            <div class="ui attached segment " style="background: url(images/m3.jpg);">
            	<form action="docbookupdate" method="post"  enctype="multipart/form-data"   id="myform" name="myform">
            	<input type="hidden" name="bid" value="${p.BOOK_ID}">
            	<input type="hidden" name="check" value="${p.BOOK_CHECK}">
                    <table class="insert-tab" width="100%">
                  
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>图书名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="Bname" size="50" value="${p.BOOK_NAME}" type="text" >
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
                                </td>                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>图书封面：</th>
                                <td>
                                    <input class="common-text required" id="title" name="pic" size="50" value="" type="file">
                                    <img src="images/book/${p.BOOK_FILENAME}" width="80" height="80">
                                </td>

                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>作者名称：</th>
                                <td>
                                    <input class="common-text required" id="title" name="writerName" size="50" value="${p.BOOK_WRITER }" type="text" readonly="">
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>图书简介：</th>
                               <td>
                                    <textarea style="width:425px;height:100px;border-radius:10px" name="decs" >${p.BOOK_DESCRIPTION}</textarea>
                                </td>
                            </tr>
                            
                            
                            
                            
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="确认" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="取消" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
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
	</body>
</html>
