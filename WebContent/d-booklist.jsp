<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device,initial-scale=1.0" />
		<title>书籍列表</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css"/>
		<link rel="stylesheet" href="css/index.css" />
	</head>
	<body>
		<!--
        	作者：1913549230@qq.com
        	时间：2020-01-14
        	描述：导航
        -->
        <nav class="ui inverted  attached segment m-padded-tb-mini">
        	<div class="ui container">
        		<div class="ui inverted secondary menu ">
        		    <h2 class="ui teal header item">墨与默</h2>
        		    <a href="index.html" class=" m-item item m-mobile-hide">首页</a>
                     <a href="stack.html" class="m-item item m-mobile-hide">书库</a>
                    <a href="shelf.html" class="m-item item m-mobile-hide">书架</a>
                    <a href="m-allcomment.html" class="m-item item m-mobile-hide">评论</a>
                    <a href="message.html" class="m-item item m-mobile-hide">信息管理</a>
                    <a href="login.html" class="m-item item m-mobile-hide">退出</a>
                    <div class="item">
        				<img src="images/h01.png" alt="" class="ui avatar image"/>
        				<c:if test="${isLogin ==1 }">
            		<b>你好：</b><a href="login.jsp" id="login">${name.USER_NAME }</a>
            	
            	</c:if>
            
            	 <c:if test="${isAdminLogin ==1 }">
            		<p style="color="teal";"><a href="manage/admin_index.jsp" id="login1">---->进入后台</a></p>
            	
            	</c:if>
                    </div>
                    
                    <div class="right item">
                    	<div class="ui icon  inverted   input">
                    		<input type="text" placeholder="Search......." />
                    		<i class="search link icon"></i>
                    	</div>
                    </div>
                </div>
        			
        	</div>
        	
        </nav>
		<!--
        	作者：1913549230@qq.com
        	时间：2020-01-14
        	描述：中间内容
        -->
        <div class="m-padded-tb-large">
        	<div class="ui container">
           		<div class="ui top attached  teal segment">
        			<h3 class="ui  teal header  m-text-thin">推理</h3>				
                </div>    
                <div class="ui attached segment">
                	<div class="ui padded vertical segment">
        					<div class="ui grid">
        						<div class="  three wide column">
        								<a href="#" target="_blank">
        									<img src="images/fiction03.jpg" alt="" class="ui rounded image" style="width: 100px;height: 140px;" />
        								</a>
        						</div>
        						<div class=" five wide column">
        							 <div class="content" ><a href="#" class="header m-content">南山下的传说</a></div>
        							 <h4 class="item m-text-lined" >作者：一枝花</h4>
        							<p>无家可归，父母惨死！后又被百般折磨，偶然机会死里逃生，得到了无数奇遇，回归江湖....</p>
        						</div>
        						<div class="three wide column">
        							<a href="#" target="_blank">
        									<img src="images/fiction04.jpg" alt="" class="ui rounded image" style="width: 100px;height: 140px; "/>
        								</a>
        						</div>
        						<div class="five wide column">
        							 <div class="content" ><a href="#" class="header m-content">长安策</a></div>
        							 <h4 class="item m-text-lined" >作者：一颗糖</h4>
        							<p>五胡十六国时期，天下大乱。北方暗中流传一秘密：谁能得到继绝环，谁就能一统...</p>
        						</div>
        					</div>
        				</div>
        		</div>	
        		<div class="ui attached segment">
                	<div class="ui padded vertical segment">
        					<div class="ui grid">
        						<div class="  three wide column">
        								<a href="#" target="_blank">
        									<img src="images/fiction03.jpg" alt="" class="ui rounded image" style="width: 100px;height: 140px;" />
        								</a>
        						</div>
        						<div class=" five wide column">
        							 <div class="content" ><a href="#" class="header m-content">南山下的传说</a></div>
        							 <h4 class="item m-text-lined" >作者：一枝花</h4>
        							<p>无家可归，父母惨死！后又被百般折磨，偶然机会死里逃生，得到了无数奇遇，回归江湖....</p>
        						</div>
        						<div class="three wide column">
        							<a href="#" target="_blank">
        									<img src="images/fiction04.jpg" alt="" class="ui rounded image" style="width: 100px;height: 140px; "/>
        								</a>
        						</div>
        						<div class="five wide column">
        							 <div class="content" ><a href="#" class="header m-content">长安策</a></div>
        							 <h4 class="item m-text-lined" >作者：一颗糖</h4>
        							<p>五胡十六国时期，天下大乱。北方暗中流传一秘密：谁能得到继绝环，谁就能一统...</p>
        						</div>
        					</div>
        				</div>
        		</div>	
        		<div class="ui attached segment">
                	<div class="ui padded vertical segment">
        					<div class="ui grid">
        						<div class="  three wide column">
        								<a href="#" target="_blank">
        									<img src="images/fiction03.jpg" alt="" class="ui rounded image" style="width: 100px;height: 140px;" />
        								</a>
        						</div>
        						<div class=" five wide column">
        							 <div class="content" ><a href="#" class="header m-content">南山下的传说</a></div>
        							 <h4 class="item m-text-lined" >作者：一枝花</h4>
        							<p>无家可归，父母惨死！后又被百般折磨，偶然机会死里逃生，得到了无数奇遇，回归江湖....</p>
        						</div>
        						<div class="three wide column">
        							<a href="#" target="_blank">
        									<img src="images/fiction04.jpg" alt="" class="ui rounded image" style="width: 100px;height: 140px; "/>
        								</a>
        						</div>
        						<div class="five wide column">
        							 <div class="content" ><a href="#" class="header m-content">长安策</a></div>
        							 <h4 class="item m-text-lined" >作者：一颗糖</h4>
        							<p>五胡十六国时期，天下大乱。北方暗中流传一秘密：谁能得到继绝环，谁就能一统...</p>
        						</div>
        					</div>
        				</div>
        		</div>	
        		<div class="ui attached segment">
                	<div class="ui padded vertical segment">
        					<div class="ui grid">
        						<div class="  three wide column">
        								<a href="#" target="_blank">
        									<img src="images/fiction03.jpg" alt="" class="ui rounded image" style="width: 100px;height: 140px;" />
        								</a>
        						</div>
        						<div class=" five wide column">
        							 <div class="content" ><a href="#" class="header m-content">南山下的传说</a></div>
        							 <h4 class="item m-text-lined" >作者：一枝花</h4>
        							<p>无家可归，父母惨死！后又被百般折磨，偶然机会死里逃生，得到了无数奇遇，回归江湖....</p>
        						</div>
        						<div class="three wide column">
        							<a href="#" target="_blank">
        									<img src="images/fiction04.jpg" alt="" class="ui rounded image" style="width: 100px;height: 140px; "/>
        								</a>
        						</div>
        						<div class="five wide column">
        							 <div class="content" ><a href="#" class="header m-content">长安策</a></div>
        							 <h4 class="item m-text-lined" >作者：一颗糖</h4>
        							<p>五胡十六国时期，天下大乱。北方暗中流传一秘密：谁能得到继绝环，谁就能一统...</p>
        						</div>
        					</div>
        				</div>
        		</div>	
        		<div class="ui bottom attached segment">
        			<div class="ui two column grid">
        						<div class="column">
        							<button class="ui teal button">上一页</button>
        						</div>
        						<div class="right aligned column">
        							<button class="ui teal button">下一页</button>
        						</div>
        			</div>
        		</div>
        	</div>
        </div>
        <!--
        	作者：1913549230@qq.com
        	时间：2020-01-14
        	描述：底部
        -->
        <footer class="ui inverted vertical segment m-padded-tb-massive">
        	<div class="ui center aligned container">
        		<div class="ui inverted divided  grid">
        			<!--
                    	作者：1913549230@qq.com
                    	时间：2020-01-14
                    	描述：底部四块
                    -->
        			<div class="three wide column">
        				<div class="ui inverted link list">
        					<div class="item">
        						<img src="images/01.jpg" class="ui rounded " alt="" style="width: 100px;"/>	
        					</div>
        				</div>
        			</div>
        			
        			<div class="four wide column">
        				<h4 class="ui inverted header m-opacity-mini">墨与默</h4>
        				<div class="ui inverted link list">
        					<a href="#" class="item">关于阅读与思考</a>
        					<a href="#" class="item">来此各抒己见</a>	
        					<a href="#" class="item">在此不必争论</a>	
        				</div>
        			</div>
        			
        			<div class="four wide column">
        					<h4 class="ui inverted header m-opacity-mini">联系我</h4>
        				<div class="ui inverted link list">
        					<a href="#" class="item">Email:3487975016@qq.com</a>
        					<a href="#" class="item">Phone:18849335517</a>	
        				</div>
        			</div>
        			
        			<div class="five wide column">
        				<h4 class="ui inverted header m-opacity-mini">WangShuJie</h4>
        				<div class="ui inverted link list">
        					<a href="#" class="item">某人的毕业设计</a>
        					<a href="#" class="item">熬秃头也要保持微笑！</a>
        				</div>
        			</div>
        			
        		</div>
        		<div class="ui inverted section divider"></div>
        		<p class="m-text-thin m-text-spaced m-opacity-mini">Copyright @ 2016-2020 WangShuJIe Designer by WangShuJie</p>
        	</div>
        </footer>
		<script scr="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
		<script scr="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
	</body>
</html>