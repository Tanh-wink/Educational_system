<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学籍信息</title>
</head>
<body>
	<h1>${sessionScope.user.name },您好！</h1>
	<div>
		<a href="<%=request.getContextPath()%>/modify/modifypassword.jsp">修改密码</a>
		<a href="<%=request.getContextPath()%>/login/login.jsp">注销</a>
	</div>
	<div>
		<h3>学籍信息</h3>
	</div>
	<div>
		<font color="RED">${requestScope.message }</font>	
	</div>
	<br>
	<form action="<%=request.getContextPath()%>/studentInformationServlet" method="post">
		<div>
			学号：<input type="text" readonly="readonly"  name="studentId" value="${requestScope.studentBasicInformation.studentId }"/>
			姓名：<input type="text" readonly="readonly"  name="studentName" value="${requestScope.studentBasicInformation.studentName }"/>
			性别：<input type="text" readonly="readonly"  name="gender" value="${requestScope.studentBasicInformation.gender }"/>
		</div>
		<br><br>
		<div>
			年级：<input type="text" readonly="readonly"  name="grade" value="${requestScope.studentBasicInformation.grade }"/>
			班级：<input type="text" readonly="readonly"  name="className" value="${requestScope.studentBasicInformation.className }"/>
			学院：<input type="text" readonly="readonly"  name="academy" value="${requestScope.studentBasicInformation.academy }"/>
		</div>
		<br><br>
		<div>
			专业：<input type="text" readonly="readonly"  name="profession" value="${requestScope.studentBasicInformation.profession }"/>
			所在校区：<input type="text" readonly="readonly"  name="campus" value="${requestScope.studentBasicInformation.campus }"/>
			联系电话：<input type="text" name="phone" value="${requestScope.studentBasicInformation.phone }"/>
		</div>
		<br><br>
		<div>
			家庭地址：<input type="text" size="40" name="homeAddress" value="${requestScope.studentBasicInformation.homeAddress }"/>
			
		</div>
		<br><br>
		<div>
			<input type="submit" name="submit" value="修改"/>
			<a href="<%=request.getContextPath() %>/student/informationinquiry/informationinquiry.jsp">返回上一步</a>
		</div>		
	</form>
</body>
</html>