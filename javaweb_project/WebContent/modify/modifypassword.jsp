<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统</title>
</head>
<body>
	<!-- 修改密码页面 -->
	<div class="modifyMM">
		<div>
			<% String tokenValue = new Date().getTime() +""; %>
			<c:set value="<%=tokenValue %>" var="token" scope="session"/>
		</div>	
		<form action="<%=request.getContextPath()%>/modifyPasswordServlet" method="post">
			<div>
				${sessionScope.message }	
				<%session.removeAttribute("message"); %>
			</div>
			<div>
				<input type="hidden" name="token" value="<%=tokenValue %>"/>
			</div>
			<div class="form-group">
				旧密码：<input type="password" name="oldpassword"/>
			</div>
			<br>
			<div class="form-group">
				新密码：<input type="password" name="newpassword"/>
			</div>
			<br>
			<div class="form-group">
				确认密码：<input type="password" name="confirmpassword"/>  
			</div>
			<br>
			<div>
				<input type="submit" name="submit" value="确定" />
				<a href="${sessionScope.path }">返回</a>
			</div>
		</form>
	</div>
</body>
</html>