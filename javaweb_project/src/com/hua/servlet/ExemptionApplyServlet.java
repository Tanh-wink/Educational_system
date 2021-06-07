package com.hua.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hua.dao.ExemptionApplyDAO;
import com.hua.entity.ExemptionApply;
import com.hua.entity.User;
import com.hua.impl.ExemptionApplyDAOImpl;

@WebServlet("/exemptionApplyServlet")
public class ExemptionApplyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ExemptionApplyDAO pea = new ExemptionApplyDAOImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		String yearTerm = request.getParameter("yearTerm");
		String courseName = request.getParameter("courseName");
		String applyReason = request.getParameter("applyReason");
		
		ExemptionApply exemptionApply = new ExemptionApply(yearTerm, user.getUsername(), courseName, applyReason);
		pea.insert(exemptionApply);
		
		String message = "提交成功";
		session.setAttribute("message", message);
		response.sendRedirect(request.getContextPath() + "/student/businessmanagement/exemptionapply.jsp");
	}

}
