<%@page import="com.hua.entity.CourseScheduleShow"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.hua.entity.CourseSchedule"%>
<%@page import="java.util.List"%>
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
		<a href="<%=request.getContextPath()%>/login/login.jsp">注销</a>
	</div>
	<br><br>
	<a href="<%=request.getContextPath() %>/student/informationinquiry/informationinquiry.jsp">返回上一步</a>
	<div>
		<h3>课表查询</h3>
	</div>
	<form action="<%=request.getContextPath()%>/courseScheduleServlet"  method="post">
		<div>		
			学年学期:		
				<select name="yearTerm">
					<option value=""></option>
					<option value="2017秋季">2017秋季</option>
					<option value="2017春季">2017春季</option>
					<option value="2016秋季">2016秋季</option>
					<option value="2016春季">2016春季</option>
				</select>
				
			周次：
				<select name="week">
					<option value=""></option>
					<option value="第1周">第1周</option>
					<option value="第2周">第2周</option>
					<option value="第3周">第3周</option>
					<option value="第4周">第4周</option>
					<option value="第5周">第5周</option>
					<option value="第6周">第6周</option>
					<option value="第7周">第7周</option>
					<option value="第8周">第8周</option>
					<option value="第9周">第9周</option>
					<option value="第10周">第10周</option>
					<option value="第11周">第11周</option>
					<option value="第12周">第12周</option>
					<option value="第13周">第13周</option>
					<option value="第14周">第14周</option>
					<option value="第15周">第15周</option>
					<option value="第16周">第16周</option>
					<option value="第17周">第17周</option>
					<option value="第18周">第18周</option>
					<option value="第19周">第19周</option>
					<option value="第20周">第20周</option>
				</select>
			<input type="submit" value="查询"/>
		</div>

	</form>
	<c:if test="${sessionScope.courseScheduleShows != null }">
		<table border="2" cellpadding="0" cellspacing="0">
				<tr>
					<th height="50px"></th>
					<th height="50px">星期一</th>
					<th height="50px">星期二</th>
					<th height="50px">星期三</th>
					<th height="50px">星期四</th>
					<th height="50px">星期五</th>
					<th height="50px">星期六</th>
					<th height="50px">星期日</th>
				</tr>
				<%
					
					List<CourseScheduleShow> courseScheduleShows = (List<CourseScheduleShow>)session.getAttribute("courseScheduleShows");
					session.removeAttribute("courseScheduleShows");
					for(CourseScheduleShow courseScheduleShow : courseScheduleShows){		
				%>	
					<tr>
						<td align="center" height="100px" width="100px"><%=courseScheduleShow.getJoint() %></td>
						<td height="100px" width="150px">
							<%
								if(courseScheduleShow.getMonday() != null){
							%>	
							<%=courseScheduleShow.getMonday().getCourse() %>
							<br>
							<%=courseScheduleShow.getMonday().getTeacher() %>
							<br>
							<%=courseScheduleShow.getMonday().getClassplace() %>
							<% 
								}
							%>	
												
						</td>
						<td height="100px" width="150px">
							<%
								if(courseScheduleShow.getTuesday() != null){
							%>	
							<%=courseScheduleShow.getTuesday().getCourse() %>
							<br>
							<%=courseScheduleShow.getTuesday().getTeacher() %>
							<br>
							<%=courseScheduleShow.getTuesday().getClassplace() %>
							<% 
								}
							%>	
						</td>
						<td height="100px" width="150px">
							<%
								if(courseScheduleShow.getWesneday() != null){
							%>	
							<%=courseScheduleShow.getWesneday().getCourse() %>
							<br>
							<%=courseScheduleShow.getWesneday().getTeacher() %>
							<br>
							<%=courseScheduleShow.getWesneday().getClassplace() %>
							<% 
								}
							%>	
						</td>
						<td height="100px" width="150px">
							<%
								if(courseScheduleShow.getThursday() != null){
							%>	
							<%=courseScheduleShow.getThursday().getCourse() %>
							<br>
							<%=courseScheduleShow.getThursday().getTeacher() %>
							<br>
							<%=courseScheduleShow.getThursday().getClassplace() %>
							<% 
								}
							%>	
						</td>
						<td height="100px" width="150px">
							<%
								if(courseScheduleShow.getFriday() != null){
							%>	
							<%=courseScheduleShow.getFriday().getCourse() %>
							<br>
							<%=courseScheduleShow.getFriday().getTeacher() %>
							<br>
							<%=courseScheduleShow.getFriday().getClassplace() %>
							<% 
								}
							%>	
						</td>
						<td height="100px" width="150px">
							<%
								if(courseScheduleShow.getSaturday() != null){
							%>	
							<%=courseScheduleShow.getSaturday().getCourse() %>
							<br>
							<%=courseScheduleShow.getSaturday().getTeacher() %>
							<br>
							<%=courseScheduleShow.getSaturday().getClassplace() %>
							<% 
								}
							%>	
						</td>
						<td height="100px" width="150px">
							<%
								if(courseScheduleShow.getSunday() != null){
							%>	
							<%=courseScheduleShow.getSunday().getCourse() %>
							<br>
							<%=courseScheduleShow.getSunday().getTeacher() %>
							<br>
							<%=courseScheduleShow.getSunday().getClassplace() %>
							<% 
								}
							%>	
						</td>
					</tr>
				<%						
					}
				%>
			</table>
		</c:if>
</body>
</html>