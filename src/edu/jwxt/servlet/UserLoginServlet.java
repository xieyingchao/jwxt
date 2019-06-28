package edu.jwxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jwxt.bean.User;
import edu.jwxt.service.IUserService;
import edu.jwxt.service.impl.IUserServiceImpl;

public class UserLoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//乱码解决
		req.setCharacterEncoding("UTF-8");
		String user_name = req.getParameter("user_name");
		String user_pwd = req.getParameter("user_pwd");
		String user_code = req.getParameter("user_code");
		String user_who= req.getParameter("primaryRadioGroup1");
		
		User user = new User(user_name,user_pwd);
		IUserService iuserservice = new IUserServiceImpl();
		
		System.out.println("用户名："+user_name+"密码："+user_pwd+"验证码"+user_code+"用户"+user_who);
		//resp.sendRedirect("index.jsp");//登录成功，重定向到首页
		
		System.out.println(user_code.equalsIgnoreCase((String) req.getSession().getAttribute("code")));
		//验证码正确就比较账号密码,读取session比较
		
		if(user_code.equalsIgnoreCase((String) req.getSession().getAttribute("code"))) {
			int result = iuserservice.login(user,user_who);
			System.out.println(result);
			if(result == 0) {
				
				//学生账号密码正确，跳转首页,将用户账户存入到session，以便首页读取
				req.getSession().setAttribute("user", user_name);
				req.getSession().setAttribute("user_who", user_who);
				req.getSession().setAttribute("password", user_pwd);
				//req.getRequestDispatcher("index.jsp").forward(req, resp);
				resp.sendRedirect("index.jsp");
			}else if(result == 1){
				
				//教师账号密码正确，跳转到教师首页，将用户账户存入session
				req.getSession().setAttribute("user", user_name);
				req.getSession().setAttribute("user_who", user_who);
				req.getSession().setAttribute("password", user_pwd);
				//req.getRequestDispatcher("index.jsp").forward(req, resp);
				resp.sendRedirect("teacher_index.jsp");
			}else {
				System.out.println("密码错误");
				req.setAttribute("info", "账户或密码错误，请重试！");
				req.getRequestDispatcher("login_page.jsp").forward(req, resp);
			}
		}else {
			System.out.println("验证码错误");
			req.setAttribute("info", "验证码错误，请点击图片重试！");
			req.getRequestDispatcher("login_page.jsp").forward(req, resp);
		}
	}
}
