package edu.jwxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jwxt.service.ITeacherService;
import edu.jwxt.service.impl.ITeacherServiceImpl;

public class TeacherUpdateGradeServlet extends HttpServlet{

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
		String all = request.getParameter("all");
		all = all.substring(0, all.length()-1);
		System.out.println(all);
		String[] a = all.split("/");
		for(String s:a) {
			System.out.println(s);
		}
		ITeacherService iteacherservice = new ITeacherServiceImpl();
		int result = iteacherservice.UpdateStudentGrade(a);
		PrintWriter pw = response.getWriter();
		pw.print(result);
	}
}
