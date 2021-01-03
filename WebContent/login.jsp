<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html >
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device,initial-scale=1.0" />
		<title>登陆</title>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.css"/>
		<link rel="stylesheet" href="css/index.css" />
	</head>
	<body>
	<br />
	<br />
		<br />
		<br />
		<br />
		<div class="m-container m-padded-tb-massive" style="max-width: 30em !important;">
			<div class="ui container">
				<div class="ui middle aligned center aligned grid">
  <div class="column">
    <h2 class="ui teal image header">
      <div class="content">
                   Hi 一起阅读
      </div>
    </h2>
    <form class="ui large form" method="post" action="login">
      <div class="ui  segment">
        <div class="field">
          <div class="ui left icon input">
            <i class="user icon"></i>
            <input name="userName" id="userName" type="text" placeholder="用户名">
          </div>
        </div>
        <div class="field">
          <div class="ui left icon input">
            <i class="lock icon"></i>
            <input name="passWord" id="passWord" type="password" placeholder="密码">
          </div>
        </div>
        <div class="ui fluid large teal submit button" onclick="return valForm()" >登陆</div>
        <br />
      </div>
     
      <div   class="field">
     <div class="ui grid">
         <div align="left" class="eight wide column">
          还没有账号？ <a href="signup.jsp">注册</a>
         </div>
         
     </div>
  </div>
    </form>

    
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
       var passWord =document.getElementById("passWord");
         if(userName.value==""){
             alert("用户名不能为空");
             return false;
             }else if(passWord.value==""){
                 alert("密码不能为空");
                  return false;
                } else{
                	     
          				 document.forms[0].action="login";
                              document.forms[0].submit();
                              return false;
                              }
      }

</script>
		
		
		
		<script scr="https://cdn.jsdelivr.net/npm/jquery@3.2/dist/jquery.min.js"></script>
		<script scr="https://cdn.jsdelivr.net/semantic-ui/2.2.4/semantic.min.js"></script>
	</body>
</html>
