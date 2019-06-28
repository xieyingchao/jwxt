package edu.jwxt.servlet;

import java.io.IOException;

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

public class UpdatePwdServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String user_who = (String) request.getSession().getAttribute("user_who");
		if(user_who.equals("student")) {
			//如果是学生
			IStudentService istuentservice = new IStudentServiceImpl();
			int id = (int) request.getSession().getAttribute("id");
			String oldpwd = request.getParameter("oldpwd");
			String newpwd = request.getParameter("newpwd");
			Student student = new Student(id, oldpwd, newpwd);
			int result = istuentservice.UpdatePwd(student);
			if(result == 1) {
				request.setAttribute("result", "修改成功");
				request.getSession().setAttribute("password", newpwd);
			}else if (result == -1) {
				request.setAttribute("result", "原密码错误");
			}else {
				request.setAttribute("result", "修改失败");
			}
			request.getRequestDispatcher("update_password.jsp").forward(request, response);
		}else {
			//如果是老师
			ITeacherService iteacherservice = new ITeacherServiceImpl();
			int id = (int) request.getSession().getAttribute("id");
			String oldpwd = request.getParameter("oldpwd");
			String newpwd = request.getParameter("newpwd");
			Teacher teacher = new Teacher(id, oldpwd, newpwd);
			int result = iteacherservice.UpdatePwd(teacher);
			if(result == 1) {
				request.setAttribute("result", "修改成功");
				request.getSession().setAttribute("password", newpwd);
			}else if (result == -1) {
				request.setAttribute("result", "原密码错误");
			}else {
				request.setAttribute("result", "修改失败");
			}
			request.getRequestDispatcher("update_password.jsp").forward(request, response);
		}
	}
}
