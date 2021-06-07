<%@page import="com.hua.entity.ExamArrange"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<a href="<%=request.getContextPath()%>/login/login.jsp">注销</a>
	</div>
	<br><br>
	<a href="<%=request.getContextPath() %>/student/informationinquiry/informationinquiry.jsp">返回上一步</a>
	<div>
		<h3>考试安排</h3>
	</div>
	<form action="<%=request.getContextPath()%>/examArrangeServlet"  method="post">
		<div>		
			学年学期:		
				<select name="yearTerm">
					<option value=""></option>
					<option value="2017秋季">2017秋季</option>
					<option value="2017春季">2017春季</option>
					<option value="2016秋季">2016秋季</option>
					<option value="2016春季">2016春季</option>
				</select>
			<input type="submit" value="查询"/>
		</div>

	</form>
	<c:if test="${sessionScope.examArranges != null }">
	<table border="2" cellpadding="0" cellspacing="0">
			<tr>
				<th>学年学期</th>
				<th>学号</th>
				<th>学生姓名</th>
				<th>考试课程</th>
				<th>考试形式</th>
				<th>考试日期</th>
				<th>考试时间</th>
				<th>考试周次</th>
				<th>考试校区</th>
				<th>考试地点</th>
				<th>考试座位号</th>
			</tr>
			<%
				List<ExamArrange> examArranges = (List<ExamArrange>)session.getAttribute("examArranges");
				session.removeAttribute("examArranges");
			%>
			<%
				for(ExamArrange examArrange : examArranges){
				
			%>	
				<tr>
					<td><%= examArrange.getYearTerm()%></td>
					<td><%= examArrange.getStudentId()%></td>
					<td><%= examArrange.getStudentName()%></td>
					<td><%= examArrange.getExamCourse()%></td>
					<td><%= examArrange.getExamWay()%></td>
					<td><%= examArrange.getExamDate() %></td>
					<td><%= examArrange.getExamTime() %></td>
					<td><%= examArrange.getExamWeek() %></td>
					<td><%= examArrange.getExamCampus() %></td>
					<td><%= examArrange.getExamplace() %></td>
					<td><%= examArrange.getExamSeatNum() %></td>
				</tr>
			<%
				}
			%>
		</table>
		</c:if>
</body>
</html>