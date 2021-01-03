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
                <form action="/graduation/manage/admin_doinformadd" method="post"   id="myform" name="myform">
                    <table class="insert-tab" width="100%">
                        <tbody>
                        <tr>
                                <th><i class="require-red">*</i>公告标题：</th>
                                <td>
                                    <input class="common-text required" id="title" name="Title" size="50" value="" type="text">
                                </td>
                            </tr>
 
                            <tr>
                                <th><i class="require-red">*</i>发布者：</th>
                                <td>
                                    <input class="common-text required" id="title" name="Writer" size="50" value="${user.USER_NAME }" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>内容：</th>
                                <td>
                                    <textarea style="width:425px;height:100px;border-radius:10px" name="Content" ></textarea>
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