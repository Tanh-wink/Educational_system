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

/**
 * 修改密码时检验
 * 1.检验旧密码是否正确
 * 2.检验新密码与确认密码是否一致
 */
@WebFilter(dispatcherTypes = {
				DispatcherType.REQUEST, 
				DispatcherType.FORWARD, 
				DispatcherType.INCLUDE, 
				DispatcherType.ERROR
		}
					, urlPatterns = { "/modifyPasswordServlet" })
public class ModifyPasswordFilter extends HttpFilter{

    
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String oldpassword = request.getParameter("oldpassword");
		String newpassword = request.getParameter("newpassword");
		String confirmpassword = request.getParameter("confirmpassword");
		
		if(check(user,oldpassword)){
			if(newpassword.equals(confirmpassword)){
				//放行
				filterChain.doFilter(request, response);
				return;
			}else{
				session.setAttribute("message", "新密码与确认密码不一致");
			}
		}else{
			session.setAttribute("message", "输入旧密码有误");
		}
		//返回修改页面
		response.sendRedirect(request.getContextPath() + "/modify/modifypassword.jsp");
		
		
	}

	private boolean check(User user, String oldpassword) {
		
		if(user.getPassword().equals(oldpassword)){
			return true;
		}	
		return false;
	}

}
