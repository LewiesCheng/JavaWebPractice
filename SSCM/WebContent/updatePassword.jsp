<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生选课系统</title>
<style type="text/css">
	h1{font-family:"华文行楷";font-size:300%;color:blue}
	h2{font-family:"楷体";font-size:30px;color:blue}
	h3{font-family:"宋体";font-size:20px;color:blue}
</style>
</head>
<body>
    <%
		//防止用户非法登录
		if((String)session.getAttribute("sName") == null) {
			response.sendRedirect("login.jsp");
		}
	%>
	
	<center>
	<h1>欢迎使用学生选课系统</h1>
	姓名：<%=(String)session.getAttribute("sName") %>
	<hr style="border:3 double #987cb9" width="80%" color=#987cb9 SIZE=3><br>
	<div>
		<h2>修改密码</h2>
		<form action="StudentClServlet" method="post" onsubmit="return func();">
			输入新密码：<input id="new" type="password" name="newPassword"><br><br>
			确认新密码：<input id="confirm" type="password" name="confirmPassword"><br><br>
			<input type="submit" value="确认修改">&nbsp;
			<input type="reset" value="重置信息">
		</form>
	</div>
	
	<h3><a href = WelcomeClServlet?requestPage=quit>安全退出</a></h3>
	</center>
	
	<script type="text/javascript">
			function func(){
				var newPassword = document.getElementById("new").value;
				var confirm = document.getElementById("confirm").value;
				
				if (newPassword == "" || confirm == "") {
					alert("请输入新密码或确认密码！！");
					return false;
				} else if (newPassword != confirm ) {
					alert("新密码与确认密码不相符！");
					return false;
				} else {
					return true;
				}
			}
	</script>
	
</body>
</html>