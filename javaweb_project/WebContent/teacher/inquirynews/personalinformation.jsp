<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统</title>
</head>
<body>
	<!-- 教师个人信息页面 -->
	<h1>${sessionScope.user.name },您好！</h1>
	<div>
		<%session.setAttribute("path", request.getRequestURI()); %>
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
		<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
		<br><br>
		<a href="<%=request.getContextPath() %>/teacher/teacher.jsp">返回上一步</a>
	</div>
	<div>
		<h3>个人信息</h3>
	</div>
	<div>
		<font color="RED">${requestScope.message }</font>	
	</div>
	<br>
	<form action="<%=request.getContextPath()%>/teacherInformationServlet" method="post">
		<div>
			教师编号：<input type="text" readonly="readonly" name="teacherId" value="${requestScope.teacher.teacherId }"/>
			姓名：<input type="text" readonly="readonly" name="teacherName" value="${requestScope.teacher.teacherName }"/>
			性别：<input type="text" readonly="readonly" name="gender" value="${requestScope.teacher.gender }"/>
		</div>
		<br><br>
		<div>
			政治面貌：<input type="text" name="politicstatus" value="${requestScope.teacher.politicstatus }"/>
			民族：<input type="text" readonly="readonly" name="nation" value="${requestScope.teacher.nation }"/>
			籍贯：<input type="text" readonly="readonly" name="nativeplace" value="${requestScope.teacher.nativeplace }"/>
		</div>
		<br><br>
		<div>
			学院：<input type="text" readonly="readonly" name="academy" value="${requestScope.teacher.academy }"/>
			专业：<input type="text" readonly="readonly" name="profession" value="${requestScope.teacher.profession }"/>
			联系电话：<input type="text" name="phone" value="${requestScope.teacher.phone }"/>
		</div>
		<br><br>
		<div>
			邮箱：<input type="text" size="40" name="email" value="${requestScope.teacher.email }"/>
			地址：<input type="text" size="40" name="address" value="${requestScope.teacher.address }"/>
			
		</div>
		<br><br>
		<div>
			<input type="submit" name="submit" value="修改并保存"/>
		</div>		
	</form>
</body>
</html>