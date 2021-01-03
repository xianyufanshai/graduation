<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8"/>
    <title>墨与默阅读网站后台管理</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<div class="topbar-wrap white">
    <div class="topbar-inner clearfix">
        <div class="topbar-logo-wrap clearfix">
            <h1 class="topbar-logo none"><a href="/graduation/manage/admin_index.jsp" class="navbar-brand">后台管理</a></h1>
            <ul class="navbar-list clearfix">
                <li><a class="on" href="/graduation/manage/admin_index.jsp">首页</a></li>
                <li><a href="/graduation/index" target="_blank">网站首页</a></li>
            </ul>
        </div>
        <div class="top-info-wrap">
            <ul class="top-info-list clearfix">
                <li>管理员:${name.USER_NAME}</li>
              
                <li><a href="/graduation/manage/admin_logout">退出</a></li>
            </ul>
        </div>
    </div>
</div>
<div class="container clearfix">
    <div class="sidebar-wrap">
        <div class="sidebar-title">
            <h1>菜单</h1>
        </div>
        <div class="sidebar-content">
            <ul class="sidebar-list">
                <li>
                    <a href="#"><i class="icon-font">&#xe003;</i>常用操作</a>
                    <ul class="sub-menu">
                        <li><a href="/graduation/manage/admin_douserselect"><i class="icon-font">&#xe008;</i>用户管理</a></li>
                        <li><a href="/graduation/manage/admin_sortselect"><i class="icon-font">&#xe005;</i>分类管理</a></li>
                        <li><a href="/graduation/manage/admin_bookselect"><i class="icon-font">&#xe006;</i>图书管理</a></li>
                        <li><a href="/graduation/manage/admin_selectcomment"><i class="icon-font">&#xe012;</i>评论管理</a></li>
                        <li><a href="/graduation/manage/admin_informselect"><i class="icon-font">&#xe052;</i>公告管理</a></li>
                      
                    </ul>
                </li>
                
            </ul>
        </div>
    </div>