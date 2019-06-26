package edu.jwxt.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jwxt.service.IStudentService;
import edu.jwxt.service.impl.IStudentServiceImpl;

public class StudentSelectClassServlet extends HttpServlet{

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
		String tcid = request.getParameter("tcid");
		String kind = request.getParameter("kind");
		System.out.println("提交按钮传进来的"+tcid);
		
		if(null != request.getSession().getAttribute("id")) {
			if(kind.equals("1")) {
				int id = (int) request.getSession().getAttribute("id");
				IStudentService istudentservice = new IStudentServiceImpl();
				int result = istudentservice.SelectClass(tcid, id);
				if(result == 1) {
					request.setAttribute("result", "选择成功，2秒后自动刷新");
				}else if(result == -1) {
					request.setAttribute("result", "与已选课程时间冲突，2秒后自动刷新");
				}else {
					request.setAttribute("result", "选择失败，2秒后自动刷新");
				}
			}else {
				int id = (int) request.getSession().getAttribute("id");
				IStudentService istudentservice = new IStudentServiceImpl();
				boolean result1 = istudentservice.DeleteClass(tcid, id);
				if(result1) {
					request.setAttribute("result", "退选成功，2秒后自动刷新");
				}else {
					request.setAttribute("result", "退选失败，2秒后自动刷新");
				}
			}
			request.setAttribute("refresh", "refresh");
			request.getRequestDispatcher("select_course.jsp").forward(request, response);
		}else {
			System.out.println("登录失效！");
			response.sendRedirect("nologin.jsp");
		}
	}
}
