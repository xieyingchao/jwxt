package edu.jwxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.jwxt.bean.Teacher;
import edu.jwxt.dao.ITeacherDao;
import edu.jwxt.service.ITeacherService;
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
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		Teacher teacher = new Teacher(tid, name, tnum, sex, sept, age, id, password, pic);
		return teacher;
	}
}
