<%@page import="model.CourseBean"%>
<%@page import="java.util.ArrayList"%>
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
		<h2>已选课程</h2>
		<%
			@SuppressWarnings("unchecked")
			ArrayList<CourseBean> arrayList = (ArrayList<CourseBean>)request.getAttribute("course");
		%>
		<form action="SelectClServlet" method="post">
			<table border="1">
				<tr align="center">
					<td>课程号</td><td>课程名</td><td>教师</td><td>学分</td><td>学时</td><td>教材</td><td>适应专业</td><td>退选</td>
				</tr>
				<%
					for (int i = 0; i < arrayList.size(); i++) {
						CourseBean courseBean = (CourseBean) arrayList.get(i);
				%>
				<tr align="center">
					<td><%=courseBean.getcNo() %></td>
					<td><%=courseBean.getcName() %></td>
					<td><%=courseBean.getcTeacher() %></td>
					<td><%=courseBean.getcCredit() %></td>
					<td><%=courseBean.getcTime() %></td>
					<td><%=courseBean.getcBook() %></td>
					<td><%=courseBean.getcDept() %></td>
					<td><input type="checkbox" name="boxes" value="<%=courseBean.getcNo() %>"></td>
				</tr>
				<%
					}
				%>
			</table><br>
			<input type="hidden" name="page" value="drop">
			<input type="submit" value="确认退选">
		</form>
	</div>
	
	<h3><a href = WelcomeClServlet?requestPage=quit>安全退出</a></h3>
	</center>
	
</body>
</html>