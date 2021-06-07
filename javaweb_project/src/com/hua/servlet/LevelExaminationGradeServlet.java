package com.hua.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hua.dao.LevelExaminationDAO;
import com.hua.dao.StudentBasicInforDAO;
import com.hua.entity.CriterStudent;
import com.hua.entity.LevelExamination;
import com.hua.entity.StudentBasicInformation;
import com.hua.entity.User;
import com.hua.impl.LevelExaminationDAOImpl;
import com.hua.impl.StudentBasicInforDAOImpl;

@WebServlet("*.query")
public class LevelExaminationGradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取ServletPath：/studentquery.query
		String servletPath = request.getServletPath();
		//2.去除 / 和 .query ，得到类似于studentquery这样的字符串
		String methodName = servletPath.substring(1, servletPath.length() - 6);
		
		try {
			//3.利用反射获取methodName对应的方法
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			//4.利用反射调用对应的方法
			method.invoke(this, request, response);
		} catch (Exception e) {	
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unused")
	private void dean(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		HttpSession session = request.getSession();
		String yearTerm = request.getParameter("yearTerm");
		
		List<StudentBasicInformation> students = getStudent(request, response);
		
		Map<StudentBasicInformation,List<LevelExamination>> map = getAllGradeMap(students, yearTerm);
		
		session.setAttribute("map", map);
		
		response.sendRedirect(request.getContextPath() + "/acdemic_dean/levelexaminationmanage/studentgrade.jsp");
	}
	

	

	private Map<StudentBasicInformation, List<LevelExamination>> getAllGradeMap(
			List<StudentBasicInformation> students, String yearTerm) {
		Map<StudentBasicInformation,List<LevelExamination>> map = new HashMap<>();
		LevelExaminationDAO led = new LevelExaminationDAOImpl();
		
		for(StudentBasicInformation sbi : students){
			List<LevelExamination> levelExaminations = led.getAllWithYearTerm(sbi.getStudentId().toString(),yearTerm);
			map.put(sbi, levelExaminations);
		}
		return map;
	}

	private List<StudentBasicInformation> getStudent(
			HttpServletRequest request, HttpServletResponse response) {
		String academy = request.getParameter("academy");
		String profession = request.getParameter("profession");
		String className = request.getParameter("className");
		String studentId = request.getParameter("studentId");
		String studentName = request.getParameter("studentName");
		
		CriterStudent cs = new CriterStudent(academy, profession, className, studentName, studentId);
		StudentBasicInforDAO sbi = new StudentBasicInforDAOImpl();
		
		return sbi.getForListWithCriterStudent(cs);
	}

	@SuppressWarnings("unused")
	private void studentquery(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		StudentBasicInformation student = getStudent(user);
		
		List<LevelExamination> levelExamination = getAllGradeList(user);
		
		session.setAttribute("levelExamination", levelExamination);
		session.setAttribute("student", student);
		
		response.sendRedirect(request.getContextPath() + "/student/informationinquiry/levelExaminationGrade.jsp");
	}
	
	private StudentBasicInformation getStudent(User user) {
		StudentBasicInforDAO sbi = new StudentBasicInforDAOImpl();
		return sbi.get(Long.parseLong(user.getUsername()));
	}

	private List<LevelExamination> getAllGradeList(User user) {
		LevelExaminationDAO led = new LevelExaminationDAOImpl();
		return led.getAllLevelWithStudentId(user.getUsername());
	}

}
