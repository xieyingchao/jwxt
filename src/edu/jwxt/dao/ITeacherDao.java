package edu.jwxt.dao;

import java.util.List;

import edu.jwxt.bean.Student;
import edu.jwxt.bean.StudentGrade;
import edu.jwxt.bean.StudentTestInfo;
import edu.jwxt.bean.Teacher;
import edu.jwxt.bean.TeacherCourse;

public interface ITeacherDao {

	/**
	 * 获取教师信息
	 * @param num
	 * @param pwd
	 * @return Teacher类
	 */
	public Teacher GetTeacherInfo(String num,String pwd);
	
	/**
	 * 更新教师信息
	 * @param teacher
	 * @return
	 */
	public boolean UpdateInfo(Teacher teacher);
	
	/**
	 * 更新教师密码
	 * @param teacher
	 * @return
	 */
	public int UpdatePwd(Teacher teacher);
	
	/**
	 * 获取教师课程安排表
	 * @param xuenian
	 * @param xueqi
	 * @param id
	 * @return
	 */
	public List<TeacherCourse> GetTeacherClassTable(String xuenian,String xueqi,int id);
	
	/**
	 * 获取上课学生人员名单
	 * @param xuenian
	 * @param xueqi
	 * @param id
	 * @return
	 */
	public List<Student> GetClassStudent(String xuenian,String xueqi,int id);
	/**
	 * 获取考试安排表
	 * @param kind
	 * @param tid
	 * @return
	 */
	public List<StudentTestInfo> GetTestTable(String kind , int tid);
	
	/**
	 * 教师更新考试信息
	 * @param coid
	 * @param id
	 * @param kind
	 * @param classroom
	 * @param time
	 * @return
	 */
	public int UpdateTestinfo(String coid,int id,String kind,String classroom,String time);
	
	/**
	 * 教师获取学生成绩
	 * @param tid
	 * @param coid
	 * @return
	 */
	public List<StudentGrade> GetStudentGrade(int tid, String coid);
	
	/**
	 * 教师修改学生成绩
	 * @param a
	 * @return
	 */
	public int UpdateStudentGrade(String[] a);
}
