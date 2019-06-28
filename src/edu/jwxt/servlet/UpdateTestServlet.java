package edu.jwxt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jwxt.service.ITeacherService;
import edu.jwxt.service.impl.ITeacherServiceImpl;

public class UpdateTestServlet extends HttpServlet{

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
		String coid = request.getParameter("coid");
		String kind = request.getParameter("kind");
		String classroom = request.getParameter("classroom");
		String time = request.getParameter("time");
		System.out.println("["+coid+"]"+kind+":"+classroom+":"+time);
		
		String usernum = (String) request.getSession().getAttribute("user");
		if(null != usernum) {
			int tid = (int) request.getSession().getAttribute("id");
			ITeacherService iteacherservice = new ITeacherServiceImpl();
			int result = iteacherservice.UpdateTestinfo(coid, tid, kind, classroom, time);
			PrintWriter pw = response.getWriter();
			if(result == 1) {
				//request.setAttribute("result", "修改成功！");
				pw.print(1);
			}else if(result == -1) {
				//request.setAttribute("result", "与其他考试时间地点冲突！");
				pw.print(-1);
			}else {
				request.setAttribute("result", "修改失败！");
				pw.print(0);
			}
			//request.getRequestDispatcher("teacher_test.jsp").forward(request, response);
				
		}else {
			response.sendRedirect("nologin.jsp");
		}
	}
}
