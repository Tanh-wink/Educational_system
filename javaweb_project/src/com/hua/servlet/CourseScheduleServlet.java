package com.hua.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hua.dao.CourseScheduleDAO;
import com.hua.entity.CourseSchedule;
import com.hua.entity.CourseScheduleShow;
import com.hua.entity.User;
import com.hua.impl.CourseScheduleDAOImpl;

/**
 * 获取学生课程表
 * @author hua
 *
 */
@WebServlet("/courseScheduleServlet")
public class CourseScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String yearTerm = request.getParameter("yearTerm");
		String week = request.getParameter("week");
		User user = (User) session.getAttribute("user");
		if(yearTerm != "" && yearTerm != null && week != null && week != ""){
			List<CourseSchedule> courseSchedules = getCourseSchedule(user.getUsername(), yearTerm, week);

			List<CourseScheduleShow> courseScheduleShows = getCourseScheduleShow(courseSchedules);
			
			session.setAttribute("courseScheduleShows", courseScheduleShows);
		}
		
		response.sendRedirect(request.getContextPath() + "/student/informationinquiry/examarrange.jsp");
	}

	
	private List<CourseScheduleShow> getCourseScheduleShow(
			List<CourseSchedule> courseSchedules) {
		List<CourseScheduleShow> courseScheduleShows = new ArrayList<CourseScheduleShow>();
		
		
		String[] joints = {"1-2","3-4","5","6-7","8-9","10-12"};
		String[] weekdays = {"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
		
		
		if(courseSchedules != null){
			for(int i = 0;i < 6;i++){
				CourseSchedule[] weekday = new CourseSchedule[7];
				for(CourseSchedule courseSchedule : courseSchedules){
					if(courseSchedule.getJoint().equals(joints[i])){
						for(int j = 0;j < 7;j++){
							if(courseSchedule.getWeekday().equals(weekdays[j])){
								weekday[j] = courseSchedule;
							}
						}
					}
				}
				CourseScheduleShow courseScheduleShow = new CourseScheduleShow(joints[i],
						weekday[0], weekday[1], weekday[2], weekday[3], weekday[4], weekday[5], weekday[6]);
				courseScheduleShows.add(courseScheduleShow);
			}
		}
		
		return courseScheduleShows;
	}


	private List<CourseSchedule> getCourseSchedule(String studentId,
			String yearTerm, String week) {
		CourseScheduleDAO csd = new CourseScheduleDAOImpl();
		return csd.getAllWithYearTerm(studentId, yearTerm, week);
	}


}
