package edu.jwxt.servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.jwxt.bean.PicCode;
import edu.jwxt.service.IPicCodeService;
import edu.jwxt.service.impl.IPicCodeServiceImpl;
import edu.jwxt.util.JDBCUtil;

public class CodeServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		
		IPicCodeService ipcs = new IPicCodeServiceImpl();
		PicCode code = ipcs.CheckPicCode();
		
		//1 word存取验证码答案，通过数据库读取
		String word = code.getDa_an();
		String path = code.getAddress();
		//2 path存取验证码照片路径，通过数据库读取
		String allpath = "E:\\eclipse-workspace\\jwxt\\WebContent\\images\\code\\"+path;
		System.out.println(allpath);
		//3 bufferedimage读取照片到缓存
		BufferedImage bufferedimage = ImageIO.read(new File(allpath));
		
		//4 将照片传送到页面
		ImageIO.write(bufferedimage, "png", response.getOutputStream());
		
		//5 将验证码答案保存到session里，以便登陆时验证
		request.getSession().setAttribute("code", word);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		doGet(req, resp);
	}
}
