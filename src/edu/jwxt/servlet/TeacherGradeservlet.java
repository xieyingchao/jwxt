package edu.jwxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jwxt.bean.Student;
import edu.jwxt.bean.StudentGrade;
import edu.jwxt.bean.TeacherCourse;
import edu.jwxt.service.ITeacherService;
import edu.jwxt.service.impl.ITeacherServiceImpl;

public class TeacherGradeservlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String coid = request.getParameter("coid");
		
		if(null != request.getSession().getAttribute("id")) {
			int id = (int) request.getSession().getAttribute("id");
			ITeacherService iteacherservice = new ITeacherServiceImpl();
			List<StudentGrade> list1 = iteacherservice.GetStudentGrade(id, coid);
			List<TeacherCourse> list = iteacherservice.GetTeacherClassTable("2019~2018学年", "第二学期", id);
			request.setAttribute("list", list);
			request.setAttribute("list1", list1);
			request.getRequestDispatcher("teacher_grade.jsp").forward(request, response);
		}else {
			System.out.println("登录失效！");
			response.sendRedirect("nologin.jsp");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
}
