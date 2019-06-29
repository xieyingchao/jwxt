package edu.jwxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.apache.commons.codec.digest.DigestUtils;

import edu.jwxt.bean.User;
import edu.jwxt.dao.IUserDao;
import edu.jwxt.util.DBUtil;

public class IUserDaoImpl implements IUserDao{

	/**
	 * 返回查询结果
	 * @author 谢迎超
	 * @return -1:没找到;0:找到学生;1:找到教师
	 */
	public int login(User user,String user_who) {
		int result = -1;
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		String md5pwd = DigestUtils.md5Hex(user.getPassword());
		System.out.println(md5pwd);
		String sql = "select * from "+user_who+" where num = "+user.getNum()+" and password = ?";
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			//System.out.println(sql);
			pstmt.setString(1, md5pwd);
//			pstmt.setString(2, user.getNum());
//			pstmt.setString(3, user.getPassword());
			rs = pstmt.executeQuery();
			System.out.println(sql);
			//System.out.println(rs.first());
			if(rs.next()) {
				System.out.println("找到了！！！");
				result = 0;
			}
			if(result == 0 && user_who.equals("teacher")) {
				result = 1;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
}
