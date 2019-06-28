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

public class TeacherInfoServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
			
				//如果登陆用户是教师，查找返回教师用户信息
				System.out.println("教师模式");
				ITeacherService iteacherservice = new ITeacherServiceImpl();
				Teacher teacher = iteacherservice.GetTeacherInfo((String)user, (String)pwd);
				request.getSession().setAttribute("id", teacher.getTid());
				request.getSession().setAttribute("name", teacher.getName());
				request.setAttribute("teacher", teacher);
				request.getRequestDispatcher("teacher_info.jsp").forward(request, response);
			
			
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
