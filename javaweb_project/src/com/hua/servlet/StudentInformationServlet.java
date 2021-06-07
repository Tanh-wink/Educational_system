package com.hua.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hua.dao.StudentBasicInforDAO;
import com.hua.entity.StudentBasicInformation;
import com.hua.entity.User;
import com.hua.impl.StudentBasicInforDAOImpl;

/**
 * Servlet implementation class StudentInformationServlet
 */
@WebServlet("/studentInformationServlet")
public class StudentInformationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//获得学生信息，转换到显示页面显示学生信息
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		StudentBasicInformation sbi = get(user);
		
		request.setAttribute("studentBasicInformation", sbi);
		
		request.getRequestDispatcher("/student/informationinquiry/studentinformation.jsp").forward(request, response);
	}

	private StudentBasicInformation get(User user) {
		StudentBasicInforDAO sbidao = new StudentBasicInforDAOImpl();
		
		StudentBasicInformation sbi = sbidao.get(Long.parseLong(user.getUsername()));
		if(sbi != null){
			return sbi;
		}
		
		return null;
	}

	//修改学生信息，转换到显示页面显示修改后的学生信息
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		StudentBasicInformation sbi = getStuInformation(request, response);
		
		//调用DAO修改数据库中的信息
		StudentBasicInforDAO sbidao = new StudentBasicInforDAOImpl();
		sbidao.update(sbi);
		
		request.setAttribute("message", "修改成功");
		doGet(request, response);
	}

	private StudentBasicInformation getStuInformation(HttpServletRequest request, 
			HttpServletResponse response)throws ServletException, IOException{
		StudentBasicInformation sbi = null;
		
		Enumeration<String> en = request.getParameterNames();
		List<String> parameterValues = new ArrayList<>();
		while(en.hasMoreElements()){
			parameterValues.add(request.getParameter(en.nextElement()));
		}
		
		sbi = new StudentBasicInformation(Long.parseLong(parameterValues.get(0)), parameterValues.get(1), 
				parameterValues.get(2), parameterValues.get(3), parameterValues.get(4), 
				parameterValues.get(5), parameterValues.get(6), parameterValues.get(7), 
				parameterValues.get(8), parameterValues.get(9));
		
		return sbi;
	}

}
