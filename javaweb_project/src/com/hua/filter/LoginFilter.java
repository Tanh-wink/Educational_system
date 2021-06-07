package com.hua.filter;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hua.entity.User;
import com.hua.impl.UserDAOImpl;


@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/loginChangeServlet" })
public class LoginFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpSession session = request.getSession();
		
		//获取请求参数username和password
		String username = request.getParameter("username");
		String password = request.getParameter("password");		
		
		//防止重复提交
		if(!repeatSubmit(request, response)) return;
		
		if(username == "" && password == ""){
			String message = "账号和密码不能为空";
			session.setAttribute("message", message);
			//重定向回到登录页面
			response.sendRedirect("login/login.jsp");	
		}else{
			if(!check(username,password)){
				//密码匹配失败后返回登录页面并带回一条信息：输入密码错误，请重新输入
				String message = "账号或密码不正确，请重新输入";
				session.setAttribute("message", message);
				
				session.setAttribute("username", username);
				//重定向回到登录页面
				response.sendRedirect("login/login.jsp");
				return;
			}
			filterChain.doFilter(request, response);
			return;
		}
		
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

	private boolean check(String username, String password) {
		//进入数据库查询
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		User user = userDAOImpl.get(username);
		if(user != null){
			if(user.getPassword().equals(password)){
				return true;
			}	
		}
		return false;
	}
 

}
