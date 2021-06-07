<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 添加系统用户页面 -->
	<h1>${sessionScope.user.name },您好！</h1>
	<div>
		<%session.setAttribute("path", request.getRequestURI()); %>
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
		<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
		<br><br>
		<a href="<%=request.getContextPath() %>/query.do">返回上一步</a>
	</div>
	<h1>学生用户管理</h1>
	<form action="<%=request.getContextPath()%>/addUser.do" method="post">
		<div>
			<font color="RED">${requestScope.message }</font>
			<br><br>	
		</div>
		<table>
			<tr>
				<td>用户名:</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>登录密码:</td>
				<td><input type="text" name="password"/></td>
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
				<td>找回密码凭据:</td>
				<td><input type="text" name="findMMproof"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="添加用户"/></td>
			</tr>
			
		</table>
	
	</form>
</body>
</html>