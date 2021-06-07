package com.hua.filter;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 找回密码时判断验证码正不正确
 */
@WebFilter("/findPasswordServlet")
public class FindMMCheckCodeFilter extends HttpFilter {

	@Override
	public void doFilter(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		//1. 获取请求参数: CHECK_CODE_PARAM_NAME
		String paramCode = request.getParameter("CHECK_CODE_PARAM_NAME");
				
		//2. 获取 session 中的 CHECK_CODE_KEY 属性值
		String sessionCode = (String)request.getSession().getAttribute("CHECK_CODE_KEY");
				
		//3. 比对. 看是否一致, 若一致说明验证码正确, 若不一致, 说明验证码错误
		if(!(paramCode != null && paramCode.equalsIgnoreCase(sessionCode))){
			request.getSession().setAttribute("message", "验证码不一致!");
			request.getSession().setAttribute("username", request.getParameter("username"));
			
			response.sendRedirect(request.getContextPath() + "/login/findpassword.jsp");
			return;
		}
				
		filterChain.doFilter(request, response);
		
	}
}
