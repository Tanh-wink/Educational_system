<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>找回密码</title>
</head>
<body>
	<!-- 找回密码页面 -->
	<div class="findMM">
		<div>
			<% String tokenValue = new Date().getTime() +""; %>
			<c:set value="<%=tokenValue %>" var="token" scope="session"/>
		</div>	
		<form action="<%=request.getContextPath()%>/findPasswordServlet" method="post">
			<div>
				${sessionScope.message }
			</div>
			<div>
				<input type="hidden" name="token" value="<%=tokenValue %>"/>
			</div>
			<div class="form-group">
				账号：<input type="text" name="username" value="${sessionScope.username }"/>
				<%session.removeAttribute("message"); %>
			</div>
			<br>
			<div class="form-group">
				凭据：<input type="text" name="idCard"/>
			</div>
			<br>
			<div class="form-group">
				验证码：<input type="text" name="CHECK_CODE_PARAM_NAME"/> 
				<img alt="" src="<%= request.getContextPath() %>/validateColorServlet"> 
			</div>
			<br>
			<div>
				凭据默认是身份证或护照
			</div>
			<div>
				<input type="submit" name="submit" value="找回密码" />
				<a href="<%=request.getContextPath() %>/login/login.jsp">返回登录</a>
			</div>
		</form>
	</div>
</body>
</html>