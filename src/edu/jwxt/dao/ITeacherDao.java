package edu.jwxt.dao;

import edu.jwxt.bean.Teacher;

public interface ITeacherDao {

	/**
	 * 获取教师信息
	 * @param num
	 * @param pwd
	 * @return Teacher类
	 */
	public Teacher GetTeacherInfo(String num,String pwd);
}
