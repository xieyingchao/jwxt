package edu.jwxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.codec.digest.DigestUtils;

import edu.jwxt.bean.Student;
import edu.jwxt.bean.StudentGrade;
import edu.jwxt.bean.StudentTestInfo;
import edu.jwxt.dao.IStudentDao;
import edu.jwxt.util.DBUtil;
import edu.jwxt.util.FileWrite;

public class IStudentDaoImpl implements IStudentDao{

	/**
	 * 获取学生信息
	 * @param 学生学号、学生密码
	 * @return 学生信息类
	 */
	@Override
	public Student GetStudentInfo(String num, String pwd) {

		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		
		String sql = "select * from student where num = "+num+" and password = ?";
		ResultSet rs = null;
		
		int sid = 0;
		String name = null;
		String snum = null;
		int sex = 0;
		String cname = null;
		int age = 0;
		String id = null;
		String password = null;
		String pic = null;
		String email=null;
		String address = null;
		String tel = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			String md5pwd = DigestUtils.md5Hex(pwd);
			pstmt.setString(1, md5pwd);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				sid = rs.getInt(1);
				name = rs.getString(2);
				snum = rs.getString(3);
				sex = rs.getInt(4);
				cname = rs.getString(5);
				age = rs.getInt(6);
				id = rs.getString(7);
				password = rs.getString(8);
				pic = rs.getString(9);
				email = rs.getString(10);
				address = rs.getString(11);
				tel = rs.getString(12);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Student student = new Student(sid, name, snum, sex, cname, age, id, password, pic,email,address,tel);
		return student;
	}
	
	/**
	 * 获取学生成绩
	 * @param 学年、学期、学生id
	 * @return 学生成绩类构成的列表
	 */
	@Override
	public List<StudentGrade> GetStudentGrade(String xuenian, String xueqi,int id) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select course.name,xuefen,grade from student_course,teacher_course,course where student_course.tcid = teacher_course.tcid and teacher_course.coid = course.coid and xueqi = ? and xuenian = ? and sid = "+id;
		
		List<StudentGrade> list = new ArrayList<StudentGrade>();
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, xuenian);
			pstmt.setString(1, xueqi);
			System.out.println(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 String name = rs.getString(1);
				double xuefen = rs.getDouble(2);
				int grade = rs.getInt(3);
				StudentGrade studentgrade = new StudentGrade(name, xuefen, grade);
				System.out.println(name);
				list.add(studentgrade);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		FileWrite.filewrite(list);
		return list;
	}
	
	/**
	 * 更新学生信息
	 */
	@Override
	public boolean UpdateInfo(Student student) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		int rs = 0;
		
		String sql = "update student set email = ? , address = ? , tel = ? where sid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, student.getEmail());
			pstmt.setString(2, student.getAddress());
			pstmt.setString(3, student.getTel());
			pstmt.setInt(4, student.getSid());
			System.out.println(sql);
			rs = pstmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		if(rs > 0) {
			return true;
		}
		return false;
	}
	
	@Override
	public int UpdatePwd(Student student) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int result = 0;
		String pwd = null;
		
		String sql1 = "select password from student where sid = ?";
		String sql = "update student set password = ? where sid = ? and password = ?";
		try {
			System.out.println(sql1);
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, student.getSid());
			rs = pstmt1.executeQuery();
			while(rs.next()) {
				pwd = rs.getString(1);
			}
			String newmd5pwd = DigestUtils.md5Hex(student.getPassword());
//			System.out.println(pwd);
//			System.out.println(newmd5pwd);
//			System.out.println(newmd5pwd.equals(pwd));
			if(newmd5pwd.equals(pwd)) {
				pstmt2 = conn.prepareStatement(sql);
				pstmt2.setString(1, DigestUtils.md5Hex(student.getNewpwd()));
				pstmt2.setInt(2, student.getSid());
				System.out.println(newmd5pwd);
				pstmt2.setString(3, newmd5pwd);
				result = pstmt2.executeUpdate();
				if(result > 0) {
					return 1;
				}
			}else {
				return -1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 获取学生考试信息
	 * @param 学生考试信息类
	 * @return 学生考试信息类构成的列表
	 */
	@Override
	public List<StudentTestInfo> SearchTestInfo(StudentTestInfo studenttestinfo) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select course.name,address,test_date from course,teacher_course,course_test where course.coid = teacher_course.coid and teacher_course.tcid = course_test.tcid and kind = ? and teacher_course.tcid in (select tcid from student_course where sid = ?) order by test_date;";
		
		List<StudentTestInfo> list = new ArrayList<StudentTestInfo>();
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, studenttestinfo.getKind());
			pstmt.setInt(2, studenttestinfo.getSid());
			System.out.println(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 String name = rs.getString(1);
				String addr = rs.getString(2);
				String time = rs.getString(3).substring(0, 16);
				StudentTestInfo studentgrade = new StudentTestInfo(name, addr, time);
				System.out.println(name+time);
				list.add(studentgrade);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 获取学生课表
	 */
	@Override
	public List<StudentGrade> GetStudentClassTable(String xuenian, String xueqi, int id) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select course.num,course.name,xuefen,teacher.name teacher,time,classroom from course,teacher_course,teacher where teacher_course.coid = course.coid and teacher_course.tid = teacher.tid and xuenian = ? and xueqi = ? and teacher_course.tcid in (select tcid from student_course where sid = ?) order by course.num";
		
		List<StudentGrade> list = new ArrayList<StudentGrade>();
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, xuenian);
			pstmt.setString(2, xueqi);
			pstmt.setInt(3, id);
			System.out.println(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				double xuefen = rs.getDouble(3);
				String teacher = rs.getString(4);
				String time = rs.getString(5);
				String classroom = rs.getString(6);
				StudentGrade studentgrade = new StudentGrade(name, xuefen, num, teacher, time, classroom);
				System.out.println(name);
				list.add(studentgrade);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 获取选修课程信息
	 * @param 课程的类型 0：主修课 1：选修课
	 * @return 课程列表
	 */
	@Override
	public List<StudentGrade> GetXuanxiuClassList(String i) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select teacher_course.tcid,course.name,xuefen,course.sept,teacher.name,time,classroom,ppnum from course,teacher,teacher_course where teacher_course.coid = course.coid and teacher_course.tid = teacher.tid and xuanxiu = " + i;
		
		List<StudentGrade> list = new ArrayList<StudentGrade>();
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			System.out.println(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String num = rs.getString(1);
				String name = rs.getString(2);
				double xuefen = rs.getDouble(3);
				String sept = rs.getString(4);
				String teacher = rs.getString(5);
				String time = rs.getString(6);
				String classroom = rs.getString(7);
				String ppnum = rs.getString(8);
				StudentGrade studentgrade = new StudentGrade(name, xuefen, num, teacher, time, classroom, sept, ppnum);
				System.out.println(name);
				list.add(studentgrade);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**
	 * 学生选课
	 * @param 选取的教师课程id和选课学生的id
	 * @return int型结果 1：成功 0：失败 -1：与已选课程冲突
	 */
	@Override
	public int SelectClass(String tcid,int sid) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs2 = null;
		PreparedStatement pstmt = null;
		int rs = 0;
		
		String time = null;
		
		String sql1 = "select time from teacher_course where teacher_course.tcid in (select distinct teacher_course.tcid from teacher_course,student_course where teacher_course.time in (select time from student_course,teacher_course where student_course.tcid = teacher_course.tcid))";
		String sql2 = "select time from teacher_course where tcid = "+tcid;
		String sql = "insert into student_course(sid,tcid) values(?,?)";
		try {
			pstmt1 = conn.prepareStatement(sql1);
			rs1 = pstmt1.executeQuery();
			pstmt2 = conn.prepareStatement(sql2);
			rs2 = pstmt2.executeQuery();
			if(rs2.next()) {
				time = rs2.getString(1);
				System.out.println("要插入的课表时间"+time);
			}
			while(rs1.next()) {
				String id = rs1.getString(1);
				System.out.println("已选择的课表时间"+id);
				if(id.equals(time)) {
					return -1;
				}
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, sid);
			pstmt.setString(2, tcid);
			rs = pstmt.executeUpdate();
			System.out.println("rs:"+rs);
			if(rs > 0) {
				String sql3 = "update teacher_course set ppnum = ppnum+1 where coid = "+tcid;
				PreparedStatement pstmt3 = conn.prepareStatement(sql3);
				int result = pstmt3.executeUpdate();
				if(result > 0) {
					return 1;
				}else {
					return 0;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	/**
	 * 学生退选课程
	 * @param 退选课程的教师课程id、学生id
	 * @return true:退选成功
	 */
	@Override
	public boolean DeleteClass(String tcid, int sid) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "delete from student_course where sid = ? and tcid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, tcid);
			pstmt.setInt(1, sid);
			result = pstmt.executeUpdate();
			if(result > 0) {
				String sql1 = "update teacher_course set ppnum = ppnum-1 where coid = "+tcid;
				PreparedStatement pstmt1 = conn.prepareStatement(sql1);
				int rs = pstmt1.executeUpdate();
				if(rs > 0) {
					return true;
				}else {
					return false;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 获取学生已选的选修课
	 */
	@Override
	public List<String> GetXuanxiuClass(int sid) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<String> list = new ArrayList<String>();
		String sql = "select student_course.tcid from student_course where sid = "+sid;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String tcid = rs.getString(1);
				list.add(tcid);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
}
