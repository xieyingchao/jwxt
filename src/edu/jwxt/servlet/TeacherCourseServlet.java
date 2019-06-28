package edu.jwxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jwxt.bean.Student;
import edu.jwxt.bean.TeacherCourse;
import edu.jwxt.service.ITeacherService;
import edu.jwxt.service.impl.ITeacherServiceImpl;

public class TeacherCourseServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String xuenian = request.getParameter("xuenian");
		String xueqi = request.getParameter("xueqi");
		System.out.println("学年："+xuenian+"学期："+xueqi);
		String teachergrade = request.getParameter("teachergrade");
		if(null != request.getSession().getAttribute("id")) {
			int id = (int) request.getSession().getAttribute("id");
			ITeacherService iteacherservice = new ITeacherServiceImpl();
			List<TeacherCourse> list = iteacherservice.GetTeacherClassTable(xuenian, xueqi, id);
			request.setAttribute("list", list);
			System.out.println(teachergrade);
			if(null == teachergrade) {
				//实现课表查询功能
				int i = 0;
				for(TeacherCourse t:list) {
					i++;
					String name ="LIST";
					List<Student> list2 = iteacherservice.GetClassStudent(xuenian, xueqi, id);
					request.setAttribute(name, list2);
				}
				
				request.getRequestDispatcher("teacher_course.jsp").forward(request, response);
			}else {
				//实现成绩管理功能中的课程列表
				request.getRequestDispatcher("teacher_grade.jsp").forward(request, response);
			}
			
		}else {
			System.out.println("登录失效！");
			response.sendRedirect("nologin.jsp");
		}
	}
}
