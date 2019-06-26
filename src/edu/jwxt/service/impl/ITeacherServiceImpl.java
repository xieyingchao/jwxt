package edu.jwxt.service.impl;

import edu.jwxt.bean.Teacher;
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
}
