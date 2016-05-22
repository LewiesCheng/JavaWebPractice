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
	<hr style="border:3 double #987cb9" width="80%" color=#987cb9 SIZE=3>
	<table border="0" width="75%">
			<tr height="50">
				<td align="center"><h2><a href=WelcomeServlet?requestPage=student>个人信息</a></h2></td>
				<td align="center"><h2><a href=WelcomeServlet?requestPage=course>选课管理</a></h2></td>
				<td align="center"><h2><a href=WelcomeServlet?requestPage=select>已选课程</a></h2></td>
			</tr>
	</table>
	<div>
		<h2>个人信息</h2>
		<table border = "1" width="30%">
		<tr align="center">
			<td>姓名</td><td><%=(String)session.getAttribute("sName") %></td>
		</tr>
		<tr align="center">
			<td>学号</td><td><%=(String)session.getAttribute("sId") %></td>
		</tr>
		<tr align="center">
			<td>专业</td><td><%=(String)request.getAttribute("dept") %></td>
		</tr>
	</table><br>
	<a href = updatePassword.jsp>修改密码</a>
	</div>
	
	<h3><a href = WelcomeClServlet?requestPage=quit>安全退出</a></h3>
	</center>
	
</body>
</html>