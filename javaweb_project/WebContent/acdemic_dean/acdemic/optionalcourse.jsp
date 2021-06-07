<%@page import="java.util.List"%>
<%@page import="com.hua.entity.StudentBasicInformation"%>
<%@page import="com.hua.entity.OptionalCourse"%>
<%@page import="java.util.Map"%>
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
		<%session.setAttribute("path", request.getRequestURI()); %>
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
		<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
		<br><br>
		<a href="<%=request.getContextPath() %>/acdemic_dean/acdemic_dean.jsp">返回上一步</a>
	</div>
	<form action="<%=request.getContextPath()%>/optStudent.List"  method="post">
		
		<table>
			<tr>
				<td>学年学期:</td>
				<td>
					<select name="yearTerm">
						<option value=""></option>
						<option value="2017秋季">2017秋季</option>
						<option value="2017春季">2017春季</option>
						<option value="2016秋季">2016秋季</option>
						<option value="2016春季">2016春季</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>学院:</td>
				<td>
					<select name="academy">
						<option value=""></option>
						<option value="自动化学院">自动化学院</option>
						<option value="物理学院">物理学院</option>
						<option value="电子信息学院">电子信息学院</option>
						<option value="计算机学院">计算机学院</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>专业:</td>
				<td>
					<select name="profession">
						<option value=""></option>
						<option value="自动化">自动化</option>
						<option value="应用物理">应用物理</option>
						<option value="电子信息工程">电子信息工程</option>
						<option value="计算机科学与技术">计算机科学与技术</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>班级:</td>
				<td>
					<select name="className">
						<option value=""></option>
						<option value="电子15(1)">电子15(1)</option>
						<option value="电子15(2)">电子15(2)</option>
						<option value="计算机14(1)">计算机14(1)</option>
						<option value="计算机14(2)">计算机14(2)</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>学号:</td>
				<td><input type="text" name="studentId"/></td>
			</tr>
			<tr>
				<td>学生姓名:</td>
				<td><input type="text" name="studentName"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="查询"/></td>
			</tr>
			
		</table>
	
	</form>
	<c:if test="${sessionScope.map != null }">
		<div>
			<table border="1" cellpadding="0" cellspacing="0">
				<tr>
					<th>学年学期</th>
					<th>学号</th>
					<th>学生姓名</th>
					<th>学院</th>
					<th>专业</th>
					<th>班级</th>
					<th>课程编号</th>
					<th>课程名称</th>
					<th>学分</th>
					<th>课程类型</th>
					<th>任课老师</th>
					<th>上课方式</th>
					<th>上课时间</th>
					<th></th>
				</tr>
				<%
					Map<StudentBasicInformation,List<OptionalCourse>> map = 
						(Map<StudentBasicInformation,List<OptionalCourse>>)session.getAttribute("map");
					session.removeAttribute("map");
				%>
				<%
					for(Map.Entry<StudentBasicInformation,List<OptionalCourse>> entry : map.entrySet()){
						StudentBasicInformation stu = entry.getKey();
						List<OptionalCourse> optionalCourses = entry.getValue();
						for(OptionalCourse optionalCourse : optionalCourses){
				
				%>	
					<tr>
						<td><%= optionalCourse.getYearTerm() %></td>
						<td><%= stu.getStudentId() %></td>
						<td><%= stu.getStudentName() %></td>
						<td><%= stu.getAcademy() %></td>
						<td><%= stu.getProfession() %></td>
						<td><%= stu.getClassName() %></td>
						<td><%= optionalCourse.getCourseId() %></td>
						<td><%= optionalCourse.getCourseName() %></td>
						<td><%= optionalCourse.getCredit() %></td>
						<td><%= optionalCourse.getCourseType() %></td>
						<td><%= optionalCourse.getTeacher() %></td>
						<td><%= optionalCourse.getClassWay() %></td>
						<td><%= optionalCourse.getClassTime() %></td>
					</tr>
				
				<%
						}
					}		
				%>
			</table>
		</div>
	</c:if>
</body>
</html>