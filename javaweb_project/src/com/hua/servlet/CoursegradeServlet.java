package com.hua.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hua.dao.StudentBasicInforDAO;
import com.hua.dao.StudentGradeDAO;
import com.hua.entity.CriterStudent;
import com.hua.entity.GradeAnalysisResult;
import com.hua.entity.StudentBasicInformation;
import com.hua.entity.StudentGrade;
import com.hua.entity.User;
import com.hua.impl.StudentBasicInforDAOImpl;
import com.hua.impl.StudentGradeDAOIpml;
/**
 * 学生成绩servlet
 * 1.教务员查询学生成绩
 * 2.获取学生成绩后统计分析：计算总分，平均分，绩点等等
 * 3.学生用户查询自己的成绩
 * @author hua
 *
 */
@WebServlet("*.grade")
public class CoursegradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//1.获取ServletPath：/addUser.do
		String servletPath = request.getServletPath();
		//2.去除 / 和 .do ，得到类似于addUser这样的字符串
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
	
	//成绩统计分析：比如计算绩点,绩点排名等等
	@SuppressWarnings("unused")
	private void gradeAnalysis(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String yearTerm = request.getParameter("yearTerm");
		//获取要查询的所有学生的信息，放进List中
		List<StudentBasicInformation> students = getStudent(request, response);
		
		//获取每一位学生与其对应的所有的成绩，作为键值对存入map中
		Map<StudentBasicInformation,List<StudentGrade>> map = getAllGradeMap(students, yearTerm);
		//获取每一位学生的成绩统计分析结果
		Map<StudentBasicInformation, GradeAnalysisResult> results = getAnalysisResult(map);
		//将每一位学生的成绩分析结果放入session中
		session.setAttribute("results", results);
		//重定向到jsp显示页面
		response.sendRedirect(request.getContextPath() + "/acdemic_dean/acdemic/grademanagement/gradeanalysis.jsp");
	}
	
	//获取成绩分析结果，把结果放入一个数组中
	private Map<StudentBasicInformation, GradeAnalysisResult> getAnalysisResult(
			Map<StudentBasicInformation, List<StudentGrade>> map) {
		//List results = new ArrayList();
		Map<StudentBasicInformation, GradeAnalysisResult> GradeMap = new HashMap<>();
		
		for(Map.Entry<StudentBasicInformation,List<StudentGrade>> entry : map.entrySet()){
			StudentBasicInformation stu = entry.getKey();
			List<StudentGrade> studentGrades = entry.getValue();
			int courseCount = studentGrades.size();  //获取课程门数
			if(courseCount != 0){
				int score = getScore(studentGrades);  //获取总分
				double averScore = score / courseCount;    //平均分
				double gradePoint = getGradePoint(studentGrades);   //平均学分绩点
				double averCreditGrade = (gradePoint + 5) * 10;  //平均学分成绩
				
				//使平均分、平均学分绩点、平均学分成绩输出两位小数（四舍五入）
				 DecimalFormat df = new DecimalFormat("#.00");
				 
				GradeAnalysisResult gradeAnalysisResult = new GradeAnalysisResult(stu.getStudentId(),
						courseCount, score, df.format(gradePoint), df.format(averCreditGrade), df.format(averScore));
				
				GradeMap.put(stu, gradeAnalysisResult);	
			}
		}
		
		return GradeMap;
	}
	
	//求平均学分绩点
	private double getGradePoint(List<StudentGrade> studentGrades) {
		StudentGrade studentGrade = null;
		double credit = 0.0,sum = 0.0;
		
		Iterator<StudentGrade> iter = studentGrades.iterator();
		while(iter.hasNext()){
			studentGrade= iter.next();
			sum = sum + studentGrade.getGradePoint() * studentGrade.getCredit();
			credit = credit + studentGrade.getCredit();
			
		}
		
		return sum / credit;
	}
	
	private int getScore(List<StudentGrade> studentGrades) {
		int score = 0;
		
		Iterator<StudentGrade> iter = studentGrades.iterator();
		StudentGrade studentGrade = null;
		while(iter.hasNext()){
			studentGrade= iter.next();
			score = score + studentGrade.getScore();		
		}
		return score;
	}

	//教务员查询学生成绩
	@SuppressWarnings("unused")
	private void deanQuery(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String yearTerm = request.getParameter("yearTerm");
		
		List<StudentBasicInformation> students = getStudent(request, response);
		
		
		Map<StudentBasicInformation,List<StudentGrade>> map = getAllGradeMap(students, yearTerm);
		
		session.setAttribute("map", map);
		
		response.sendRedirect(request.getContextPath() + "/acdemic_dean/acdemic/grademanagement/gradequery.jsp");
	}
	
	

	private Map<StudentBasicInformation, List<StudentGrade>> getAllGradeMap(
			List<StudentBasicInformation> students, String yearTerm) {
		Map<StudentBasicInformation,List<StudentGrade>> map = new HashMap<>();
		StudentGradeDAO sgd = new StudentGradeDAOIpml();
		
		for(StudentBasicInformation sbi : students){
			List<StudentGrade> studentGrades = sgd.getAllWithYearTerm(sbi.getStudentId(),yearTerm);
			map.put(sbi, studentGrades);
		}
		return map;
	}
	
	//获取条件查询到的所有学生信息
	private List<StudentBasicInformation> getStudent(
			HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String academy = request.getParameter("academy");  //学院
		String profession = request.getParameter("profession");
		String className = request.getParameter("className");
		String studentId = request.getParameter("studentId");
		String studentName = request.getParameter("studentName");
		
		CriterStudent cs = new CriterStudent(academy, profession, className, studentName, studentId);
		StudentBasicInforDAO sbi = new StudentBasicInforDAOImpl();
		
		return sbi.getForListWithCriterStudent(cs);
	}
	
	//学生用户查询自己的成绩
	@SuppressWarnings("unused")
	private void studentQuery(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		User user = (User) session.getAttribute("user");
		
		List<StudentGrade> studentGrades = getAllcourseGradeList(user);
		
		session.setAttribute("studentGrades", studentGrades);
		
		response.sendRedirect(request.getContextPath() + "/student/informationinquiry/coursegrade.jsp");
	}
	
	private List<StudentGrade> getAllcourseGradeList(User user) {
		StudentGradeDAO sgd = new StudentGradeDAOIpml();
		return sgd.getAllCourseGrade(Long.parseLong(user.getUsername()));
	}



}
