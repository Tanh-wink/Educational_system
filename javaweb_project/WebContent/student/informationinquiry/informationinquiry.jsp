<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>信息查询</title>
</head>
<body>
	<h1>${sessionScope.user.name },您好！</h1>
	<div>
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
		<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
		<br><br>
		<a href="<%=request.getContextPath() %>/student/student.jsp">返回上一步</a>
	</div>
	<div>
		<h3>信息查询</h3>
		<a href="<%=request.getContextPath()%>/studentInformationServlet">学籍信息</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/student/informationinquiry/courseschedule.jsp">课表查询</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/studentquery.query">考级成绩</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/studentQuery.grade">课程成绩</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/student/informationinquiry/examarrange.jsp">考试安排</a>
	</div>
</body>
</html>