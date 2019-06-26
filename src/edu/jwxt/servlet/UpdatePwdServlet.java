package edu.jwxt.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jwxt.bean.Student;
import edu.jwxt.service.IStudentService;
import edu.jwxt.service.impl.IStudentServiceImpl;

public class UpdatePwdServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		IStudentService istuentservice = new IStudentServiceImpl();
		String user_who = (String) request.getSession().getAttribute("user_who");
		if(user_who.equals("student")) {
			//如果是学生
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
		}
		
	}
}
