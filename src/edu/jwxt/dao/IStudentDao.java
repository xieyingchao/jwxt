package edu.jwxt.dao;

import java.util.List;

import edu.jwxt.bean.Student;
import edu.jwxt.bean.StudentGrade;
import edu.jwxt.bean.StudentTestInfo;

public interface IStudentDao {

	/**
	 * 获取学生信息
	 * @return Student类
	 */
	public Student GetStudentInfo(String num,String pwd);
	/**
	 * 获取学生课程分数
	 * @param xuenian
	 * @param xueqi
	 * @return
	 */
	public List<StudentGrade> GetStudentGrade(String xuenian,String xueqi,int id);
	
	/**
	 * 更新学生信息
	 * @param student
	 * @return
	 */
	public boolean UpdateInfo(Student student);
	
	/**
	 * 修改学生信息
	 * @param student
	 * @return
	 */
	public int UpdatePwd(Student student);
	
	/**
	 * 查询学生考试信息
	 * @param studenttestinfo
	 * @return
	 */
	public List<StudentTestInfo> SearchTestInfo(StudentTestInfo studenttestinfo);
	
	/**
	 * 查询学生信息
	 * @param xuenian
	 * @param xueqi
	 * @param id
	 * @return
	 */
	public List<StudentGrade> GetStudentClassTable(String xuenian, String xueqi, int id);
	
	/**
	 * 检索所有的选修课
	 */
	public List<StudentGrade> GetXuanxiuClassList(String i);
	
	/**
	 * 学生提交选修课
	 * @param tcid
	 * @return 
	 */
	public int SelectClass(String tcid,int sid);
}
