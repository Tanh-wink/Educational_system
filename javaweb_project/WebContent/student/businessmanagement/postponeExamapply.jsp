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
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
		<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
		<br><br>
		<a href="<%=request.getContextPath() %>/student/student.jsp">返回上一步</a>
	</div>
	<div>
		<h3>业务办理</h3>
	</div>
	<form action="<%=request.getContextPath()%>/postponeExamapplyServlet"  method="post">
		<div>
			<font color="RED">${sessionScope.message }	</font>					
			<%session.removeAttribute("message"); %>
		</div>
		<table>	
			<tr>
				<td>学年学期:</td>
				<td>	
					<select name="yearTerm" >
						<option value=""></option>
						<option value="2017秋季">2017秋季</option>
						<option value="2017春季">2017春季</option>
						<option value="2016秋季">2016秋季</option>
						<option value="2016春季">2016春季</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>申请课程:</td>
				<td>		
					<input type="text" name="courseName"/>
				</td>
			</tr>
			<tr>
				<td>申请原因:</td>
				<td>		
					<input type="text" name="applyReason" size=“100”/>
				</td>
			</tr>
			<tr>
				<td>		
					<input type="submit" value="提交申请"/>
				</td>
			</tr>
		</table>	
		
	</form>
</body>
</html>