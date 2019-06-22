package edu.jwxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.jwxt.bean.User;
import edu.jwxt.dao.IUserDao;
import edu.jwxt.util.DBUtil;

public class IUserDaoImpl implements IUserDao{

	public boolean login(User user) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		String sql = "select * from student where num = ? and password = ?";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			//System.out.println(sql);
			pstmt.setString(1, user.getNum());
			pstmt.setString(2, user.getPassword());
			rs = pstmt.executeQuery();
			//System.out.println(rs.first());
			if(rs.next()) {
				System.out.println("找到了！！！");
				return true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
}
