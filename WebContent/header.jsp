<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<!--
        	作者：1913549230@qq.com
        	时间：2020-01-14
        	描述：导航
        -->
        <nav class="ui inverted  attached segment m-padded-tb-mini">
        	<div class="ui container">
        	
        		<div class="ui inverted secondary menu ">
        		    <h2 class="ui teal header item">墨与默</h2>
        		    <a href="index" class=" m-item item m-mobile-hide">首页</a>
                     <a href="stackselect" class="m-item item m-mobile-hide">书库</a>
                    <a href="bookshelf" class="m-item item m-mobile-hide">我的书架</a>
                    <a href="mycomment" class="m-item item m-mobile-hide">我的评论</a>
                    <c:if test="${name.STATUS==2 }">
                     <a href="mycreation" class="m-item item m-mobile-hide">我的创作</a>
                    </c:if>
                    <a href="touserupdate1?id=${name.USER_ID }" class="m-item item m-mobile-hide">个人信息</a>
                    <a href="logout" class="m-item item m-mobile-hide">退出</a>
                    <div class="item">
        				<img src="images/h01.png" alt="" class="ui avatar image"/>
        				<c:if test="${isLogin ==1 }">
            		<b style="color:teal;font-size:16px">你好：</b><a href="login.jsp" id="login">${name.USER_NAME }</a>
            		<c:if test="${name.STATUS==1 }">
            		<p><a href="manage/admin_index.jsp" id="login1">---->进入后台</a></p>
            	
            	</c:if>
            	
            	</c:if>
                    </div>
                    
                    <div class="right item">
                     <form name="search" action="selectbook" method="get" target="_blank">
                    	<div class="ui icon  inverted   input">
                    		<input type="text" placeholder="全网搜书" name="keywords" value="" />
                    		<i onclick="document.forms['search'].submit()" class="search link icon" ></i>
                    	</div>
                    </form>
                    </div>
                </div>
        			
        	</div>
        	
        </nav>