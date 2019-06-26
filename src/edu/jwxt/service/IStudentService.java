package edu.jwxt.service;

import java.util.List;

import edu.jwxt.bean.Student;
import edu.jwxt.bean.StudentGrade;
import edu.jwxt.bean.StudentTestInfo;

public interface IStudentService {

	/**
	 * 获取学生信息
	 * @return Student类
	 */
	public Student GetStudentInfo(String num,String pwd);
	/**
	 * 获取学生成绩信息
	 * @param xuenian
	 * @param xueqi
	 * @return StudentGrade类
	 */
	public List<StudentGrade> GetStudentGrade(String xuenian,String xueqi, int id);
	
	/**
	 * 更新学生信息
	 * @param student
	 * @return true:success
	 */
	public boolean UpdateInfo(Student student);
	
	/**
	 * 修改学生密码
	 * @param student
	 * @return
	 */
	public int UpdatePwd(Student student);
	
	/**
	 * 查询学生考试信息
	 * @param studenttestinfo
	 * @return 由StudentTestInfo类构成的列表
	 */
	public List<StudentTestInfo> SearchTestInfo(StudentTestInfo studenttestinfo);
	
	/**
	 * 查询学生课表
	 * @param xuenian
	 * @param xueqi
	 * @param id
	 * @return
	 */
	public List<StudentGrade> GetStudentClassTable(String xuenian,String xueqi, int id);
	
	/**
	 * 检索所有的选修课
	 * @param i
	 * @return
	 */
	public List<StudentGrade> GetXuanxiuClassList(String i);
	
	/**
	 * 学生提交选修课
	 * @param tcid
	 * @return 0:失败 1:成功 -1:时间冲突
	 */
	public int SelectClass(String tcid,int sid);
	
	/**
	 * 学生退选选修课
	 * @param tcid
	 * @param sid
	 * @return true:退选成功
	 */
	public boolean DeleteClass(String tcid,int sid);
	
	/**
	 * 获取学生已选的选修课
	 * @param sid
	 * @return
	 */
	public List<String> GetXuanxiuClass(int sid);
}
