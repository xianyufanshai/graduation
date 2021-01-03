<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device,initial-scale=1.0" />
		<title>信息管理</title>
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
        		<div class="menu">
                    <h3 class="ui teal header ">信息管理</h3> 
                    <div class="ui inverted section divider"></div>
               </div>
            <div class="ui attached segment " style="background: url(images/m3.jpg);">
            	<form action="userupdate" method="post" id="myform" name="myform">
            	<input type="hidden" name="userStatus" value="${u.STATUS}">
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>用户名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="userName" size="50" value="${u.USER_ID }" type="text" readonly="">
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>用户姓名：</th>
                                <td>
                                    <input class="common-text required" id="title" name="name" size="50" value="${u.USER_NAME}" type="text">
                                </td>
                            </tr>
                            
                            <tr>
                                <th><i class="require-red">*</i>登录密码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="passWord" size="50" value="${u.PWD}" type="password">
                                </td>
                            </tr>
                            
                             <tr>
                                <th><i class="require-red">*</i>确认密码：</th>
                                <td>
                                    <input class="common-text required" id="title" name="rePassWord" size="50" value="${u.PWD }" type="password">
                                </td>
                            </tr>
                            
                             <tr>
                                <th>性别：</th>
                                <td>
                                	<input type="radio" name="sex" value="T" checked="checked">男
                                	<input  type="radio" name="sex" value="F" >女
                                </td>
                            </tr>
                            
                           
                              <tr>
                                <th><i class="require-red">*</i>电子邮箱：</th>
                                <td>
                                    <input class="common-text required" id="title" name="email" size="50" value="${u.EMAIL }" type="text">
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
        	
        	       <br>
        	        <br>
        	         <br>
        	          <br>
        	           <br>
        	            <br>
        	      
        </div>
     </div>
         <br>
        	        <br>
        	         <br>
        	          <br>
        	           <br>
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
