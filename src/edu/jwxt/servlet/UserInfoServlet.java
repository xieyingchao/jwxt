package edu.jwxt.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jwxt.bean.Student;
import edu.jwxt.bean.Teacher;
import edu.jwxt.service.IStudentService;
import edu.jwxt.service.ITeacherService;
import edu.jwxt.service.impl.IStudentServiceImpl;
import edu.jwxt.service.impl.ITeacherServiceImpl;

public class UserInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//获取session中的登录号，用户种类，和用户密码
		Object user = request.getSession().getAttribute("user");
		Object user_who = request.getSession().getAttribute("user_who");
		Object pwd = request.getSession().getAttribute("password");
		
		//如果session为空，表示不是通过登录页面进入到index的，提示重新登录
		if(null != user) {
			//System.out.println(user_who.equals("student"));
				//如果登录用户是学生，查找返回学生用户信息
			System.out.println("学生模式");
				IStudentService istudentservice = new IStudentServiceImpl();
				Student student = istudentservice.GetStudentInfo((String)user, (String) pwd);
				request.getSession().setAttribute("id", student.getSid());
				request.getSession().setAttribute("name", student.getName());
				request.setAttribute("student", student);
				request.getRequestDispatcher("user_info.jsp").forward(request, response);
			
			
		}else {
			//如果session为空，表示不是通过登录页面进入到index的，提示重新登录
			response.sendRedirect("nologin.jsp");
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
