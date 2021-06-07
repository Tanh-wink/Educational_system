<%@page import="com.hua.entity.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统</title>
</head>
<body>
	<!-- 用户管理页面 -->
	<h1>${sessionScope.user.name },您好！</h1>
	<div>
		<%session.setAttribute("path", request.getRequestURI()); %>
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
		<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
		<br><br>
		<a href="<%=request.getContextPath() %>/administrator/administrator.jsp">返回上一步</a>
	</div>
	<h1>用户管理</h1>
	<form action="query.do" method="post">
		
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>用户姓名:</td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td>用户身份:</td>
				<td><input type="text" name="identity"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="查询"/></td>
				<td><a href="<%=request.getContextPath()%>/administrator/adduser.jsp">添加用户</a></td>
			</tr>
			
		</table>
	
	</form>
	
	<br><br>
	
	<%
		List<User> users = (List<User>)request.getAttribute("users");
		if(users != null && users.size() > 0){
	%>
	<hr>
	<br><br>
		<table border="1" cellpadding="0" cellspacing="0">
			<tr>
				<th>用户名</th>
				<th>密码</th>
				<th>姓名</th>
				<th>身份</th>
				<th>找回密码凭据</th>
				<th>最近一次登录时间</th>
				<th>最近一次修改密码时间</th>
				<th>修改/删除</th>
			</tr>
			<%
				for(User user : users){
			%>
				
				<tr>
					<td><%= user.getUsername() %></td>
					<td><%= user.getPassword() %></td>
					<td><%= user.getName() %></td>
					<td><%= user.getIdentity() %></td>
					<td><%= user.getFindMMproof() %></td>
					<td><%= user.getLogin_last_time() %></td>
					<td><%= user.getPassword_last_changed() %></td>
					<td> 
						<a href="edit.do?username=<%= user.getUsername()%>">UPDATE</a>/
						<a href="delete.do?username=<%=user.getUsername()%>" class="delete">DELETE</a>
					</td>
				</tr>
			
			<%
				}		
			%>
		</table>
	<%
		}	
	%>
</body>
</html>