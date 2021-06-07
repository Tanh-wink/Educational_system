<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${sessionScope.user.name },您好！</h1>
	<div>
		<%session.setAttribute("path", request.getRequestURI()); %>
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
		<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
		<br><br>
		<a href="<%=request.getContextPath() %>/acdemic_dean/acdemic_dean.jsp">返回上一步</a>
	</div>
	<h3>教务管理</h3>
		<a href="<%=request.getContextPath()%>/acdemic_dean/acdemic/grademanagement/gradequery.jsp">成绩总库查询</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/acdemic_dean/acdemic/grademanagement/gradeanalysis.jsp">成绩统计分析</a>
</body>
</html>