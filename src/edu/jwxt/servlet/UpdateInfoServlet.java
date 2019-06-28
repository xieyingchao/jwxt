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

public class UpdateInfoServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String user_who = (String) request.getSession().getAttribute("user_who");
		
		System.out.println(user_who.equals("student"));
		if(user_who.equals("student")) {
			//如果是学生
			IStudentService istudentservice = new IStudentServiceImpl();
			int id = (int) request.getSession().getAttribute("id");
			String email = request.getParameter("email");
			String addr = request.getParameter("provice") + request.getParameter("address");
			String tel = request.getParameter("tel");
			System.out.println(email +addr +tel);
			Student student = new Student(id, email, addr, tel);
			boolean result = istudentservice.UpdateInfo(student);
			System.out.println(result);
			if(result) {
				request.setAttribute("result", "修改成功");
			}else {
				request.setAttribute("result", "修改失败");
			}
			request.getRequestDispatcher("update_info.jsp").forward(request, response);
		}else {
			//如果是教师
			ITeacherService iteacherservice = new ITeacherServiceImpl();
			int id = (int) request.getSession().getAttribute("id");
			String email = request.getParameter("email");
			String addr = request.getParameter("provice") + request.getParameter("address");
			String tel = request.getParameter("tel");
			System.out.println(email +addr +tel);
			Teacher teacher = new Teacher(id, email, tel, addr);
			boolean result = iteacherservice.UpdateInfo(teacher);
			System.out.println(result);
			if(result) {
				request.setAttribute("result", "修改成功");
			}else {
				request.setAttribute("result", "修改失败");
			}
			request.getRequestDispatcher("update_info.jsp").forward(request, response);
		}
	}
}
