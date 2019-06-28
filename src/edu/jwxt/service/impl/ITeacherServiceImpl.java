package edu.jwxt.service.impl;

import java.util.List;

import edu.jwxt.bean.Student;
import edu.jwxt.bean.StudentGrade;
import edu.jwxt.bean.StudentTestInfo;
import edu.jwxt.bean.Teacher;
import edu.jwxt.bean.TeacherCourse;
import edu.jwxt.dao.ITeacherDao;
import edu.jwxt.dao.impl.ITeacherDaoImpl;
import edu.jwxt.service.ITeacherService;

public class ITeacherServiceImpl implements ITeacherService{

	ITeacherDao iteacherdao = new ITeacherDaoImpl();
	@Override
	public Teacher GetTeacherInfo(String num, String pwd) {

		Teacher teacher = iteacherdao.GetTeacherInfo(num, pwd);
		return teacher;
	}
	
	@Override
	public boolean UpdateInfo(Teacher teacher) {
		// TODO Auto-generated method stub
		return iteacherdao.UpdateInfo(teacher);
	}
	
	@Override
	public int UpdatePwd(Teacher teacher) {
		// TODO Auto-generated method stub
		return iteacherdao.UpdatePwd(teacher);
	}
	
	@Override
	public List<TeacherCourse> GetTeacherClassTable(String xuenian, String xueqi, int id) {
		List<TeacherCourse> list = iteacherdao.GetTeacherClassTable(xuenian, xueqi, id);
		return list;
	}
	
	@Override
	public List<Student> GetClassStudent(String xuenian, String xueqi, int id) {
		List<Student> list = iteacherdao.GetClassStudent(xuenian, xueqi, id);
		return list;
	}
	
	@Override
	public List<StudentTestInfo> GetTestTable(String kind, int tid) {
		List<StudentTestInfo> list = iteacherdao.GetTestTable(kind, tid);
		return list;
	}
	
	@Override
	public int UpdateTestinfo(String coid, int id, String kind, String classroom, String time) {
		// TODO Auto-generated method stub
		return iteacherdao.UpdateTestinfo(coid, id, kind, classroom, time);
	}
	
	@Override
	public List<StudentGrade> GetStudentGrade(int tid, String coid) {
		// TODO Auto-generated method stub
		return iteacherdao.GetStudentGrade(tid, coid);
	}
	
	@Override
	public int UpdateStudentGrade(String[] a) {
		// TODO Auto-generated method stub
		return iteacherdao.UpdateStudentGrade(a);
	}
}
