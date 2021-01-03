<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device,initial-scale=1.0" />
		<title>注册</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css"/>
		<link rel="stylesheet" href="css/index.css" />
		

	</head>
	<body>
		<br />
		<br />
		<div class="m-container m-padded-tb-massive" style="max-width: 30em !important;">
			<div class="ui container">
				<div class="ui middle aligned center aligned grid">
  <div class="column">
    <h2 class="ui teal image header">
      <div class="text">
             创建你的墨与默账号 
      </div>
    </h2>
    <form class="ui large form" method="post" action="signup">
      <div class="ui  segment">
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            
        <input name="userName" id="userName" type="text" onkeyup="this.value=this.value.replace(/[^0-9\.]/g,'')"  placeholder="用户名">
            <span  ></span>
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
        <input name="name" id="name" type="text" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="用户姓名">
            <span  ></span>
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input name="email" type="text"  placeholder="邮箱"> 
          </div>
        </div>
        <div align="left"  class="field">
        	
                                <tr>性别：</tr>
                              
                                	<input type="radio" name="sex" value="T" checked="checked">男
                                	<input  type="radio" name="sex" value="F" >女
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input name="passWord" id="pwd" type="password" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="密码...."> <span ></span>
          </div>
        </div>
        
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input name="rePassWord" id="repwd" type="password" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="再次输入密码...."> <span ></span>
          </div>
        </div>
        
         <input  class="code" type="text" name="veryCode" id="veryCode" value="" onfocus="FocusItem(this)" onblur="CheckItem(this)" placeholder="验证码"><span></span>
        <img height="25"  src="getcode" alt="看不清，换一张" onclick="change(this)">
        
        <div class="ui fluid large teal submit button" onclick="return valForm()">确认</div>
        <p align="right" ><a href="login.jsp"><span></span>已有账号登录</a></p>
      </div>

    </form>
  </div>
</div>
			</div>
		</div>
<script type="text/javascript" language="javascript">
        		function change(img) {
        			
        			img.src="getcode?"+new Date().getTime();
        		}
  获取值
       function valForm(){
          var userName=document.getElementById("userName");
          var name=document.getElementById("name");
          var passWord =document.getElementById("pwd");
          var rePassWord=document.getElementById("repwd");
          var veryCode=document.getElementById("veryCode");
         if(userName.value==""){
             alert("用户名不能为空且只能为数字");
             return false;
             }else{
            	 
            	 var url="usernamecheck?name="+encodeURI(userName.value)+"&"+new Date().getTime();
 				// "false" "true"
 				$.get(url, function(data){
 					if(data == "false") {
 						alert("用户名已存在");
 			             return false;
 					}else if(name.value==""){
 			             alert("用户姓名不能为空");
 			             return false;
 			             }else{
 			            	 
 			            	 var url="namecheck?username="+encodeURI(name.value)+"&"+new Date().getTime();
 			 				// "false" "true"
 			 				$.get(url, function(data){
 			 					if(data == "false") {
 			 						alert("用户姓名已存在");
 			 			             return false;
 			 					}else if(pwd.value==""){
 			 		                 alert("密码不能为空");
 			 		                  return false;
 			 		                }
 			 		                   else if(pwd.value!=repwd.value){
 			 		                    alert("两次密码不一致");
 			 		                   return false;
 			 		                 }
                                       else if(veryCode.value==""){
 			 		                     alert("验证码不能为空");
 			 		                     return false;
 			 		                 		   }else{
 			 		                 			 var url="codecheck?num="+encodeURI(veryCode.value)+"&"+new Date().getTime(); 
 			 		                 			$.get(url, function(data){
 			 		          					if(data=="false") {
 			 		          					 alert("验证码错误");
 			 			 		                   return false;
 			 		          					}else{
 			 		          					document.forms[0].action="signup";
 			 	                              document.forms[0].submit();
 			 	                              return false;
 			 		          					}
 			 		          					
 			 		          				});
 			 		                 		   }
 			 				});
 			             }
 				});
             }
         
  }
                
</script>
		
		<script src="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
	</body>
</html>
