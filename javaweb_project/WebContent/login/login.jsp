<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统</title>
</head>
<body>
	<!-- 登录页面 -->
	<div class="page-container  ms-controller">
		<img src="<%=request.getContextPath() %>/img/1234.png" height="150px" width="400px">
		<div class="main_box">
			<div class="login_form">
				<div>
					<% String tokenValue = new Date().getTime() +""; %>
					<c:set value="<%=tokenValue %>" var="token" scope="session"/>
				</div>	
				<form action="<%=request.getContextPath()%>/loginChangeServlet" method="post">
					<div>
						<font color="RED">${sessionScope.message }	</font>					
						<%session.removeAttribute("message"); %>
					</div>
					<table>
						<tr>
							<td>
								<input type="hidden" name="token" value="<%=tokenValue %>"/>
							</td>
						</tr>
						<tr>
							<td>账号：</td>
							<td>
								<input type="text" name="username" value="${sessionScope.username }"/>
							</td>
						</tr>
						<tr>
							<td>密码：</td>
							<td>
								<input type="password" name="password" size="21"/>
							</td>
						</tr>
						<tr>
							<td>验证码：</td>
							<td>
								<input type="text" name="CHECK_CODE_PARAM_NAME"/> 	
							</td>
							<td>
								<img alt="" src="<%= request.getContextPath() %>/validateColorServlet"> 
							</td>
						</tr>
						<tr>
							<td>
								<input type="submit" name="submit" value="登录" />
							</td>
							<td>
								<a href="findpassword.jsp">找回密码</a>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>