package com.hua.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hua.dao.UserDAO;
import com.hua.entity.CriterUser;
import com.hua.entity.User;
import com.hua.impl.UserDAOImpl;

@WebServlet("*.do")
public class AdminUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UserDAO userDAO = new UserDAOImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取ServletPath：/addUser.do
		String servletPath = request.getServletPath();
		//2.去除 / 和 .do ，得到类似于addUser这样的字符串
		String methodName = servletPath.substring(1, servletPath.length() - 3);
		
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
	private void addUser(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		//1.获取表单参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String identity = request.getParameter("identity");
		String findMMproof = request.getParameter("findMMproof");
		
		//2.检验username是否已经被占用：	
		//2.1 调用userDAO的getCountWithName(String username)获取username在数据库中是否存在
		long i = userDAO.getCountWithName(username);
		//2.2 若返回值大于0，则响应adduser.jsp页面
		//通过转发的方式来响应adduser.jsp
		if(i > 0){
			//2.2.1 要求在adduser.jsp页面显示一个错误信息：用户名username已经被占用，请重新选择！
			//在request中放入一个属性message：用户名username已经被占用，请重新选择！ 
			//在页面上通过request.getAttribute("message")的方式来显示
			String message = "用户名" +username +"已经被占用，请重新选择！";
			request.setAttribute("message", message);
			//2.2.2 adduser.jsp的表单可以回显。
			request.getRequestDispatcher("/administrator/adduser.jsp").forward(request, response);
			//2.2.3 结束办法：return
			return ;
		}
			
		//3.把表单参数封装为一个User对象user
		User user = new User(username, password, name, identity, findMMproof,null,null);
		//4.调用userDAO的insert(User user)执行保存操作
		userDAO.insert(user);
		
		String message = "添加成功";
		request.setAttribute("message", message);
		//5 adduser.jsp的表单可以回显。
		request.getRequestDispatcher("/administrator/adduser.jsp").forward(request, response);
	}
	
	@SuppressWarnings("unused")
	private void query(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		String identity = request.getParameter("identity");
		
		CriterUser user = new CriterUser(username, name, identity);
		
		//1.直接调用CustomerDAO的getAll()得到Customer的集合
		List<User> users = userDAO.getForListWithCriterCustomer(user);
		
		//2.把Customer的集合放入request中
		request.setAttribute("users", users);
		
		//3.转发页面到adminuser.jsp(不能使用重定向)
		request.getRequestDispatcher("/administrator/adminuser.jsp").forward(request, response);
		
	}
	
	@SuppressWarnings("unused")
	private void delete(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		String username = request.getParameter("username");		
		
		userDAO.delete(username);
				
		//重定向到query页面
		response.sendRedirect("query.do");
	}
	
	@SuppressWarnings("unused")
	private void update(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		//1.获取表单参数
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String identity = request.getParameter("identity");
		String findMMproof = request.getParameter("findMMproof");
		String oldUsername = request.getParameter("oldUsername");
		//2.检验username是否已经被占用
		//2.1比较username和oldUsername是否相同，若相同说明name可用
		//若不相同，调用userDAO的getCountWithName(String username)获取username在数据库中是否存在
		if(!oldUsername.equals(username)){
			long count = userDAO.getCountWithName(username);
			//2.2 若返回值大于0，则响应updateuser.jsp页面
			//通过转发的方式来响应updateuser.jsp
			if(count > 0){				
				//2.2.1 要求在updateuser.jsp页面显示一个错误信息：用户名username已经被占用，请重新选择！
				//在request中放入一个属性message：用户名username已经被占用，请重新选择！ 
				//在页面上通过request.getAttribute("message")的方式来显示
				String message = "用户名" +username +"已经被占用，请重新选择！";
				request.setAttribute("message", message);
				//2.2.2 updatecustomer.jsp的表单可以回显。
				//address, phone 显示提交表单的新的值，而username显示oldName，而不是新提交的username
				request.getRequestDispatcher("/administrator/updateuser.jsp").forward(request, response);
				
				//2.2.3 结束办法：return
				return ;
			}
		}
		
		
		
		//3.把表单参数封装为一个User对象user
		User user = new User(username, password, name, identity, findMMproof, null, null);
		//4.调用userDAO的update(User user)执行更新操作
		userDAO.update(user);
		//5.重定向到查询显示adminuser.jsp页面
		response.sendRedirect("query.do");
	}
	@SuppressWarnings("unused")
	private void edit(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		String forwardPath = "/error.jsp";
		
		//1.获取请求参数id
		String username = request.getParameter("username");
		
		//2.调用UserDAO的userDAO.get(username)获取和username对应的User对象
		try {
			User user = userDAO.get(username);
			if(user != null){
				forwardPath = "/administrator/updateuser.jsp";
				//3.将user放入request中
				request.setAttribute("user", user);
			}
		} catch (Exception e) {
			
		}
		//4.响应updatecustomer.jsp页面：转发		
		request.getRequestDispatcher(forwardPath).forward(request, response);
		
		
	}
}
