package com.hua.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hua.entity.User;
import com.hua.impl.UserDAOImpl;

@WebServlet("/findPasswordServlet")
public class FindPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		//获取请求参数username和idCard
		String username = request.getParameter("username");
		String idCard = request.getParameter("idCard");		
		
		//防止重复提交
		if(!repeatSubmit(request, response)) return;
		
		if(username == "" && idCard == ""){
			String message = "账号和凭据不能为空";
			session.setAttribute("message", message);	
		}else{
			User user = get(username);
			if(user != null && (!user.getFindMMproof().equals(idCard))){
				//密码匹配失败后返回登录页面并带回一条信息：输入密码错误，请重新输入
				String message = "账号或凭据不正确，请重新输入";
				session.setAttribute("message", message);
					
				session.setAttribute("username", username);
			}else{
				//重置密码
				String newPassword = resetPassword(user);
				session.setAttribute("message", "重置密码为：" + newPassword);
			}
			
		}
		//重定向回到登录页面
		response.sendRedirect("login/findpassword.jsp");
		
	}

	private String resetPassword(User user) {
		String newPassword = "000000";
		
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		
		user.setPassword(newPassword);
		
		userDAOImpl.update(user);
		
		return newPassword;
		
	}

	private boolean repeatSubmit(HttpServletRequest request, HttpServletResponse response) 
			throws IOException, ServletException{
		HttpSession session = request.getSession();
		
		Object token = session.getAttribute("token");
		String tokenVlaue = request.getParameter("token");
		
		if(token != null && token.equals(tokenVlaue)){
			session.removeAttribute("token");
			return true;
		}else{
			response.sendRedirect(request.getContextPath() + "/repeatsubmit.jsp");
			return false;
		}
		
	}

	private User get(String username) {
		//进入数据库查询
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		User user = userDAOImpl.get(username);
		if(user != null){
			return user;
		}
		return null;
	}

}
