package com.hua.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hua.dao.LevelExamDAO;
import com.hua.dao.LevelExamListDAO;
import com.hua.dao.OptionalCourseDAO;
import com.hua.dao.StudentBasicInforDAO;
import com.hua.dao.StudentOptCourseDAO;
import com.hua.entity.CriterStudent;
import com.hua.entity.LevelExam;
import com.hua.entity.LevelExamList;
import com.hua.entity.OptionalCourse;
import com.hua.entity.StudentBasicInformation;
import com.hua.entity.StudentOptCourse;
import com.hua.impl.LevelExamDAOImpl;
import com.hua.impl.LevelExamListDAOImpl;
import com.hua.impl.OptionalCourseDAOImpl;
import com.hua.impl.StudentBasicInforDAOImpl;
import com.hua.impl.StudentOptCourseDAOImpl;

@WebServlet("*.List")
public class ApplyStudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取ServletPath
		String servletPath = request.getServletPath();
		//2.去除 / 和 .List 
		String methodName = servletPath.substring(1, servletPath.length() - 5);
						
		try {
			//3.利用反射获取methodName对应的方法
			Method method = getClass().getDeclaredMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
			//4.利用反射调用对应的方法
			method.invoke(this, request, response);
		} catch (Exception e) {	
			e.printStackTrace();
		}
	}
	//查询考级报名学生名单
	@SuppressWarnings("unused")
	private void levelExam(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String yearTerm = request.getParameter("yearTerm");
		
		List<StudentBasicInformation> students = getStudent(request, response);
		
		Map<StudentBasicInformation,List<LevelExam>> map = getAllLevelExamMap(students, yearTerm);
		
		session.setAttribute("map", map);
		response.sendRedirect(request.getContextPath() + "/acdemic_dean/levelexaminationmanage/applystudents.jsp");
	}
	
	private Map<StudentBasicInformation, List<LevelExam>> getAllLevelExamMap(
			List<StudentBasicInformation> students, String yearTerm) {
		Map<StudentBasicInformation,List<LevelExam>> map = new HashMap<>();
		LevelExamListDAO lel = new LevelExamListDAOImpl();
		LevelExamDAO led = new LevelExamDAOImpl();
		
		for(StudentBasicInformation sbi : students){
			List<LevelExamList> levelExamLists = lel.getAll(String.valueOf(sbi.getStudentId()));
			List<LevelExam> levelExams = new ArrayList<LevelExam>();
			for(LevelExamList levelExamList: levelExamLists){
				LevelExam levelExam = led.get(levelExamList.getCourseId(),yearTerm);
				if(levelExam != null){
					levelExams.add(levelExam);
				}
			}
			
			map.put(sbi, levelExams);
		}
		return map;
	}

	//获取选修报名的学生
	@SuppressWarnings("unused")
	private void optStudent(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String yearTerm = request.getParameter("yearTerm");
		
		List<StudentBasicInformation> students = getStudent(request, response);
		
		Map<StudentBasicInformation,List<OptionalCourse>> map = getAllOptionalCourseMap(students, yearTerm);
		
		session.setAttribute("map", map);
		response.sendRedirect(request.getContextPath() + "/acdemic_dean/acdemic/optionalcourse.jsp");
	}

	private Map<StudentBasicInformation, List<OptionalCourse>> getAllOptionalCourseMap(
			List<StudentBasicInformation> students, String yearTerm) {
		Map<StudentBasicInformation,List<OptionalCourse>> map = new HashMap<>();
		OptionalCourseDAO oc = new OptionalCourseDAOImpl();
		StudentOptCourseDAO soc = new StudentOptCourseDAOImpl();
		
		for(StudentBasicInformation sbi : students){
			List<StudentOptCourse> studentOptCourses = soc.getAll(String.valueOf(sbi.getStudentId()));
			List<OptionalCourse> optionalCourses = new ArrayList<OptionalCourse>();
			for(StudentOptCourse studentOptCourse: studentOptCourses){
				OptionalCourse optionalCourse = oc.get(studentOptCourse.getCourseId(),yearTerm);
				if(optionalCourse != null){
					optionalCourses.add(optionalCourse);
				}
			}
			
			map.put(sbi, optionalCourses);
		}
		return map;
	}
	
	//获取要查询的学生信息List
	private List<StudentBasicInformation> getStudent(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String academy = request.getParameter("academy");  //学院
		String profession = request.getParameter("profession");
		String className = request.getParameter("className");
		String studentId = request.getParameter("studentId");
		String studentName = request.getParameter("studentName");
		
		CriterStudent cs = new CriterStudent(academy, profession, className, studentName, studentId);
		StudentBasicInforDAO sbi = new StudentBasicInforDAOImpl();
		
		return sbi.getForListWithCriterStudent(cs);
	}

}
