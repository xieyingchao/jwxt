package edu.jwxt.service.impl;

import java.util.List;

import edu.jwxt.bean.Student;
import edu.jwxt.bean.StudentGrade;
import edu.jwxt.bean.StudentTestInfo;
import edu.jwxt.dao.IStudentDao;
import edu.jwxt.dao.impl.IStudentDaoImpl;
import edu.jwxt.service.IStudentService;

public class IStudentServiceImpl implements IStudentService{

	IStudentDao istudentdao = new IStudentDaoImpl();
	@Override
	public Student GetStudentInfo(String num, String pwd) {
		Student student = istudentdao.GetStudentInfo(num, pwd);
		return student;
	}
	@Override
	public List<StudentGrade> GetStudentGrade(String xuenian, String xueqi,int id) {
		List<StudentGrade> list = istudentdao.GetStudentGrade(xuenian, xueqi,id);
		return list;
	}
	
	@Override
	public boolean UpdateInfo(Student student) {
		// TODO Auto-generated method stub
		return istudentdao.UpdateInfo(student);
	}
	
	@Override
	public int UpdatePwd(Student student) {
		// TODO Auto-generated method stub
		return istudentdao.UpdatePwd(student);
	}
	
	@Override
	public List<StudentTestInfo> SearchTestInfo(StudentTestInfo studenttestinfo) {
		// TODO Auto-generated method stub
		return istudentdao.SearchTestInfo(studenttestinfo);
	}
	
	@Override
	public List<StudentGrade> GetStudentClassTable(String xuenian, String xueqi, int id) {
		List<StudentGrade> list = istudentdao.GetStudentClassTable(xuenian, xueqi,id);
		return list;
	}
	
	@Override
	public List<StudentGrade> GetXuanxiuClassList(String i) {
		List<StudentGrade> list = istudentdao.GetXuanxiuClassList(i);
		return list;
	}
	
	@Override
	public int SelectClass(String tcid,int sid) {
		// TODO Auto-generated method stub
		return istudentdao.SelectClass(tcid, sid);
	}
}
