<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生选课系统</title>
<style type="text/css">
	h1{font-family:"华文行楷";font-size:300%;color:blue}
	h2{font-family:"楷体";font-size:25px;color:blue}
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
	<table border="0" width="75%">
			<tr height="50">
				<td align="center"><h2><a href=WelcomeServlet?requestPage=student>个人信息</a></h2></td>
				<td align="center"><h2><a href=WelcomeServlet?requestPage=course>选课管理</a></h2></td>
				<td align="center"><h2><a href=WelcomeServlet?requestPage=select>已选课程</a></h2></td>
			</tr>
	</table>
	<h2>很遗憾，操作失败！</h2><br>
	<a href="#" onClick="javascript :history.back(-1);">返回重新操作</a><br><br>
	<h3><a href = WelcomeServlet?requestPage=quit>安全退出系统</a></h3>
	</center>
</body>
</html>