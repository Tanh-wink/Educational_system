<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统</title>
</head>
<body>
	<!-- 学生的主页面 -->
	<h1>${sessionScope.user.name },您好！</h1>
	<div>
		<%session.setAttribute("path", request.getRequestURI()); %>
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
		<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
	</div>
	<div>
		<h3>选课报名</h3>
		<a href="<%=request.getContextPath()%>/student/courseselect/courseselect.jsp">选修课报名</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/student/courseselect/levelexamapply.jsp">考级报名</a>
	</div>
	<div>
		<h3>业务办理</h3>
		<a href="<%=request.getContextPath()%>/student/businessmanagement/postponeExamapply.jsp">缓考申请</a>
		<br><br>
		<a href="<%=request.getContextPath()%>/student/businessmanagement/exemptionapply.jsp">免修申请</a>
	</div>
	<div>
		<h3>信息查询</h3>
		<a href="<%=request.getContextPath()%>/student/informationinquiry/informationinquiry.jsp">信息查询</a>
	</div>
</body>
</html>