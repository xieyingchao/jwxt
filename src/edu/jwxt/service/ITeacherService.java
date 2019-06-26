package edu.jwxt.service;

import edu.jwxt.bean.Teacher;

public interface ITeacherService {

	/**
	 * 获取教师信息
	 * @param num
	 * @param pwd
	 * @return Teacher类
	 */
	public Teacher GetTeacherInfo(String num,String pwd);
}
