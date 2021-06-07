package com.hua.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义的 HttpFilter, 实现自 Filter 接口
 *
 */
public abstract class HttpFilter implements Filter {

	/**
	 * 用于保存 FilterConfig 对象. 
	 */
	private FilterConfig filterConfig;
	
	/**
	 * 不建议子类直接覆盖. 若直接覆盖, 将可能会导致 filterConfig 成员变量初始化失败
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
		init();
	}

	/**
	 * 供子类继承的初始化方法. 可以通过 getFilterConfig() 获取 FilterConfig 对象. 
	 */
	protected void init() {}

	/**
	 * 直接返回 init(ServletConfig) 的 FilterConfig 对象
	 */
	public FilterConfig getFilterConfig() {
		return filterConfig;
	}
	
	/**
	 * 原生的 doFilter 方法, 在方法内部把 ServletRequest 和 ServletResponse 
	 * 转为了 HttpServletRequest 和 HttpServletResponse, 并调用了 
	 * doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	 * 
	 * 若编写 Filter 的过滤方法不建议直接继承该方法. 而建议继承
	 * doFilter(HttpServletRequest request, HttpServletResponse response, 
	 *		FilterChain filterChain) 方法
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		doFilter(request, response, chain);
	}
	
	/**
	 * 抽象方法, 为 Http 请求定制. 必须实现的方法. 
	 * @param request
	 * @param response
	 * @param filterChain
	 * @throws IOException
	 * @throws ServletException
	 */
	public abstract void doFilter(HttpServletRequest request, HttpServletResponse response, 
			FilterChain filterChain) throws IOException, ServletException;

	/**
	 * 空的 destroy 方法。 
	 */
	@Override
	public void destroy() {}

}
