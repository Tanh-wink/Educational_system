<%@page import="com.hua.entity.LevelExamination"%>
<%@page import="java.util.List"%>
<%@page import="com.hua.entity.StudentBasicInformation"%>
<%@page import="java.util.Map"%>
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
		<%session.setAttribute("path", request.getRequestURI()); %>
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
		<a href="<%=request.getContextPath()%>/logoutServlet">注销</a>
		<br><br>
		<a href="<%=request.getContextPath() %>/acdemic_dean/acdemic_dean.jsp">返回上一步</a>
	</div>
	<h1>考级学生成绩</h1>
	<form action="<%=request.getContextPath()%>/dean.query"  method="post">
		
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
		
	<br><br>
	
	<table border="2" cellpadding="0" cellspacing="0">
			<tr>
				<th>学年学期</th>
				<th>学号</th>
				<th>学生姓名</th>
				<th>考级课程</th>
				<th>考级时间</th>
				<th>总成绩</th>
				<th>学生院系</th>
				<th>班级名称</th>
				<th>专业</th>
				<th>准考证号</th>
				<th>听力成绩</th>
				<th>阅读成绩</th>
				<th>写作成绩</th>
				<th>口语成绩</th>
			</tr>
			<%
				Map<StudentBasicInformation,List<LevelExamination>> map = (Map<StudentBasicInformation,List<LevelExamination>>)session.getAttribute("map");
			%>
			<%
				for(Map.Entry<StudentBasicInformation,List<LevelExamination>> entry : map.entrySet()){
					StudentBasicInformation student = entry.getKey();
					List<LevelExamination> levelExamination = entry.getValue();
					for(LevelExamination stu : levelExamination){
				
			%>	
				<tr>
					<td><%= stu.getYearTerm()%></td>
					<td><%= stu.getStudentId()%></td>
					<td><%= student.getStudentName()%></td>
					<td><%= stu.getLevelEaxmCourse()%></td>
					<td><%= stu.getEaxmTime()%></td>
					<td><%= stu.getGrade() %></td>
					<td><%= student.getAcademy() %></td>
					<td><%= student.getClassName() %></td>
					<td><%= student.getProfession() %></td>
					<td><%= stu.getExamId() %></td>
					<td><%= stu.getListenGrade() %></td>
					<td><%= stu.getReadingGrade() %></td>
					<td><%= stu.getWritingGrade() %></td>
					<td><%= stu.getSpokenGrade() %></td>
				</tr>
			<%
					}
				}
			%>
		</table>
</body>
</html>