package edu.jwxt.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jwxt.bean.StudentTestInfo;
import edu.jwxt.service.IStudentService;
import edu.jwxt.service.impl.IStudentServiceImpl;

public class StudentTestServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		IStudentService istuentservice = new IStudentServiceImpl();
		String testkind = request.getParameter("testkind");
		
		String usernum = (String) request.getSession().getAttribute("user");
		if(null != usernum) {
			int sid = (int) request.getSession().getAttribute("id");
			StudentTestInfo studenttestinfo = new StudentTestInfo(sid, testkind);
			List<StudentTestInfo> list = istuentservice.SearchTestInfo(studenttestinfo);
			if(null != list) {
				request.setAttribute("list", list);
				request.getRequestDispatcher("Test.jsp").forward(request, response);
			}else {
				
			}
		}else {
			response.sendRedirect("nologin.jsp");
		}
	}
}
