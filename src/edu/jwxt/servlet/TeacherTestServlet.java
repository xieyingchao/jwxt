package edu.jwxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jwxt.bean.StudentTestInfo;
import edu.jwxt.service.ITeacherService;
import edu.jwxt.service.impl.ITeacherServiceImpl;

public class TeacherTestServlet extends HttpServlet{

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
		
		String kind = request.getParameter("testkind");
		
		String usernum = (String) request.getSession().getAttribute("user");
		if(null != usernum) {
			int tid = (int) request.getSession().getAttribute("id");
			ITeacherService iteacherservice = new ITeacherServiceImpl();
			List<StudentTestInfo> list = iteacherservice.GetTestTable(kind, tid);
			if(null != list) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("teacher_test.jsp").forward(request, response);
			}else {
				
			}
		}else {
			response.sendRedirect("nologin.jsp");
		}
	}
}
