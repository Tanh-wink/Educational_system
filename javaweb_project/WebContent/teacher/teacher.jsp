<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 老师的主页面 -->
	<h1>${sessionScope.user.name },您好！</h1>
	<div>
		<%session.setAttribute("path", request.getRequestURI()); %>
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
		<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
	</div>
	<div>
		<h3>信息查询</h3>
		<a href="<%=request.getContextPath()%>/teacherInformationServlet">个人信息</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/teacher/inquirynews/classinformation.jsp">班级信息</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/teacher/inquirynews/courseinformation.jsp">课程信息</a>
	</div>
	<div>
		<h3>成绩管理</h3>
		<a href="<%=request.getContextPath()%>/teacher/grademanagement/insertgrade.jsp">录入成绩</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/teacher/grademanagement/modifygrade.jsp">修改成绩</a>
	</div>
</body>
</html>