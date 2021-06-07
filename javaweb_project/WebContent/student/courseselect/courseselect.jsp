<%@page import="java.util.Map"%>
<%@page import="com.hua.entity.OptionalCourse"%>
<%@page import="java.nio.channels.SeekableByteChannel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>教务管理系统</title>
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
		<h3>选课报名</h3>
			<form action="<%=request.getContextPath()%>/queryOptionalCourse.optional"  method="post">
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
						<td>		
							<input type="submit" value="查询"/>
						</td>
					</tr>
				</table>
			</form>			
	</div>
	<br><br>
	${sessionScope.message }
	<%session.removeAttribute("message"); %>
	<c:if test="${sessionScope.map != null }">
		<div>
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<th>学年学期</th>
					<th>课程编号</th>
					<th>课程名称</th>
					<th>学分</th>
					<th>课程类型</th>
					<th>任课老师</th>
					<th>上课方式</th>
					<th>上课时间</th>
					<th>是否已报名</th>
					<th></th>
				</tr>
				<%
					Map<OptionalCourse, String> map = (Map<OptionalCourse, String>)session.getAttribute("map");
					for(Map.Entry<OptionalCourse, String> entry : map.entrySet()){
				%>
					
					<tr>
						<td><%= entry.getKey().getYearTerm() %></td>
						<td><%= entry.getKey().getCourseId() %></td>
						<td><%= entry.getKey().getCourseName() %></td>
						<td><%= entry.getKey().getCredit() %></td>
						<td><%= entry.getKey().getCourseType() %></td>
						<td><%= entry.getKey().getTeacher() %></td>
						<td><%= entry.getKey().getClassWay() %></td>
						<td><%= entry.getKey().getClassTime() %></td>
						<td><%= entry.getValue() %></td>
						<td> 
							<a href="<%=request.getContextPath()%>/studentApply.optional?courseId=<%= entry.getKey().getCourseId()%>">报名</a>
			
						</td>
					</tr>
				
				<%
					}		
				%>
			</table>
		</div>
	</c:if>
</body>
</html>