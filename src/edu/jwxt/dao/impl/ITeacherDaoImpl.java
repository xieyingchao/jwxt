package edu.jwxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import edu.jwxt.bean.Student;
import edu.jwxt.bean.StudentGrade;
import edu.jwxt.bean.StudentTestInfo;
import edu.jwxt.bean.Teacher;
import edu.jwxt.bean.TeacherCourse;
import edu.jwxt.dao.ITeacherDao;
import edu.jwxt.util.DBUtil;

public class ITeacherDaoImpl implements ITeacherDao{

	@Override
	public Teacher GetTeacherInfo(String num, String pwd) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		String sql = "select * from teacher where num = "+ num +" and password = "+ pwd;
		ResultSet rs = null;
		
		int tid = 0;
		String name = null;
		String tnum = null;
		int sex = 0;
		String sept = null;
		int age = 0;
		String id = null;
		String password = null;
		String pic = null;
		String email = null;
		String tel = null;
		String address = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				tid = rs.getInt(1);
				name = rs.getString(2);
				tnum = rs.getString(3);
				sex= rs.getInt(4);
				sept = rs.getString(6);
				age = rs.getInt(5);
				id = rs.getString(7);
				password = rs.getString(8);
				pic = rs.getString(9);
				email = rs.getString(10);
				tel = rs.getString(11);
				address = rs.getString(12);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Teacher teacher = new Teacher(tid, name, tnum, sex, sept, age, id, password, pic, email, tel, address);
		return teacher;
	}
	
	@Override
	public boolean UpdateInfo(Teacher teacher) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		int rs = 0;
		
		String sql = "update teacher set email = ? , address = ? , tel = ? where tid = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getEmail());
			pstmt.setString(2, teacher.getAddress());
			pstmt.setString(3, teacher.getTel());
			pstmt.setInt(4, teacher.getTid());
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
	public int UpdatePwd(Teacher teacher) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		int result = 0;
		String pwd = null;
		
		String sql1 = "select password from teacher where tid = ?";
		String sql = "update teacher set password = ? where tid = ? and password = ?";
		try {
			System.out.println(sql);
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, teacher.getTid());
			rs = pstmt1.executeQuery();
			while(rs.next()) {
				pwd = rs.getString(1);
			}
			
			System.out.println(teacher.getPassword().equals(pwd));
			if(teacher.getPassword().equals(pwd)) {
				pstmt2 = conn.prepareStatement(sql);
				pstmt2.setString(1, teacher.getNewpwd());
				pstmt2.setInt(2, teacher.getTid());
				pstmt2.setString(3, teacher.getPassword());
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
	
	@Override
	public List<TeacherCourse> GetTeacherClassTable(String xuenian, String xueqi, int id) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select course.name,xuefen,course.num,time,classroom,ppnum from course,teacher_course where course.coid = teacher_course.coid and tid = ? and xuenian = ? and xueqi = ?";
		
		List<TeacherCourse> list = new ArrayList<TeacherCourse>();
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(2, xuenian);
			pstmt.setString(3, xueqi);
			pstmt.setInt(1, id);
			System.out.println(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String num = rs.getString(3);
				String name = rs.getString(1);
				double xuefen = rs.getDouble(2);
				String ppnum = rs.getString(6);
				String time = rs.getString(4);
				String classroom = rs.getString(5);
				TeacherCourse teachercourse = new TeacherCourse(name, xuefen, num, time, classroom, ppnum);
				System.out.println(name);
				list.add(teachercourse);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return list;
	}
	
	@Override
	public List<Student> GetClassStudent(String xuenian, String xueqi, int id) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Student> list = new ArrayList<Student>();
		
		String sql = "select student.name,student.num,sex,cname from student where sid in (select distinct sid from student_course,teacher_course,course where teacher_course.tcid = student_course.tcid and course.coid = teacher_course.coid and tid = ? and xuenian = ? and xueqi = ?)";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setString(2, xuenian);
			pstmt.setString(3, xueqi);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString(1);
				String num = rs.getString(2);
				int sex = rs.getInt(3);
				String cname = rs.getString(4);
				Student student = new Student(name, num, sex, cname);
				list.add(student);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	@Override
	public List<StudentTestInfo> GetTestTable(String kind, int tid) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql="select course.name,ppnum,course_test.address,test_date,course.coid from course,teacher_course,course_test,teacher where teacher_course.tcid = course_test.tcid and  course.coid = teacher_course.coid and teacher.tid = teacher_course.tid and kind = ? and teacher.tid = ?";
		
		List<StudentTestInfo> list = new ArrayList<StudentTestInfo>();
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			pstmt.setInt(2, tid);
			System.out.println(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				 String name = rs.getString(1);
				 String ppnum = rs.getString(2);
				String addr = rs.getString(3);
				String time = rs.getString(4).substring(0, 16);
				String coid = rs.getString(5);
				StudentTestInfo studentgrade = new StudentTestInfo(name, addr, time, ppnum,coid,kind);
				System.out.println(name+time);
				list.add(studentgrade);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int UpdateTestinfo(String coid, int id, String kind, String classroom, String time) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		int rs = 0;
		
		PreparedStatement pstmt1 = null;
		ResultSet rs1 = null;
		
		String sql = "update course_test set test_date = ?,address = ? where kind = ? and tcid in (select tcid from teacher_course where tid = ? and coid = ?)";
		String sql1 = "select address,test_date from course_test where ckid not in (select ckid from teacher_course t,course_test c where c.tcid = t.tcid and tid = ? and coid = ? and kind = ?)";
		
		try {
			pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, id);
			pstmt1.setString(2, coid);
			pstmt1.setString(3, kind);
			rs1 = pstmt1.executeQuery();
			while(rs1.next()) {
				String other = rs1.getString(1)+rs1.getString(2).substring(0, 16);
				System.out.println(other);
				String my = classroom+time;
				System.out.println(my);
				if(other.equals(my)) {
					return -1;
				}
			}
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, time);
			pstmt.setString(2, classroom);
			pstmt.setString(3, kind);
			pstmt.setInt(4, id);
			pstmt.setString(5, coid);
			rs = pstmt.executeUpdate();
			if(rs > 0) {
				return 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public List<StudentGrade> GetStudentGrade(int tid, String coid) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select distinct student.name,student.num,cname,grade,scid from student,student_course,teacher_course where student.sid = student_course.sid and student_course.tcid = teacher_course.tcid and student_course.tcid in (select tcid from teacher_course where coid = ? and tid = ? )";
		System.out.println(sql);
		List<StudentGrade> list = new ArrayList<StudentGrade>();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, coid);
			pstmt.setInt(2, tid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				String name = rs.getString(1);
				String num = rs.getString(2);
				String cname = rs.getString(3);
				int grade = rs.getInt(4);
				String scid = rs.getString(5);
				System.out.println(name+":"+scid);
				StudentGrade studentgrade = new StudentGrade(name, grade, num, cname,scid);
				list.add(studentgrade);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public int UpdateStudentGrade(String[] a) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		int rs = 0;
		String sql = "update student_course set grade = ? where scid = ?";
		int i = 0;
		int flag = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			for (String s:a) {
				i++;
				String[] b = s.split(":");
				
				pstmt.setString(2,b[0]);
				pstmt.setString(1, b[1]);
				System.out.println(b[0]+"/"+b[1]);
				rs = pstmt.executeUpdate();
				System.out.println(rs);
				if(rs == 0) {
					flag = i;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
}
