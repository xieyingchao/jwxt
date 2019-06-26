package edu.jwxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jwxt.bean.StudentGrade;
import edu.jwxt.service.IStudentService;
import edu.jwxt.service.impl.IStudentServiceImpl;

public class StudentXuanxiuClassServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String xuanxiu = (String) request.getParameter("xuanxiu");
		System.out.println(xuanxiu);
		if(null != request.getSession().getAttribute("id")) {
			//int id = (int) request.getSession().getAttribute("id");
			IStudentService istudentservice = new IStudentServiceImpl();
			List<StudentGrade> list = istudentservice.GetXuanxiuClassList(xuanxiu);
			request.setAttribute("list", list);
			request.getRequestDispatcher("select_course.jsp").forward(request, response);
		}else {
			System.out.println("登录失效！");
			response.sendRedirect("nologin.jsp");
		}
	}
}
