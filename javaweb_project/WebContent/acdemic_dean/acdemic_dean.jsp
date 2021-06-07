<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统</title>
</head>
<body>
	<h1>${sessionScope.user.name },您好！</h1>
	<div>
		<%session.setAttribute("path", request.getRequestURI()); %>
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
		<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
	</div>
	<!-- 教务员主页面 -->
	<div>
		<h3>学籍管理</h3>
		<a href="<%=request.getContextPath()%>/acdemic_dean/schoolroll/studentinformation.jsp">学生基本信息</a>
	</div>
	<div>
		<h3>考级管理</h3>
		<a href="<%=request.getContextPath()%>/acdemic_dean/levelexaminationmanage/applystudents.jsp">考级报名学生</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/dean.query">考级学生成绩</a>
	</div>
	<div>
		<h3>教务管理</h3>
		<a href="<%=request.getContextPath()%>/acdemic_dean/acdemic/grademanagement.jsp">成绩管理</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/acdemic_dean/acdemic/optionalcourse.jsp">选修报名学生</a>
	</div>
	<div>
		<h3>个人事务</h3>
		<a href="<%=request.getContextPath()%>/jwTeacherInformationServlet">个人信息</a>
	</div>
</body>
</html>