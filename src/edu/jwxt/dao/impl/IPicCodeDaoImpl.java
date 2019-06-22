package edu.jwxt.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

//import com.mysql.jdbc.ResultSet;

import edu.jwxt.bean.PicCode;
import edu.jwxt.dao.IPicCodeDao;
import edu.jwxt.util.DBUtil;
import edu.jwxt.util.JDBCUtil;
import java.sql.ResultSet;

public class IPicCodeDaoImpl implements IPicCodeDao{

	@Override
	public PicCode GetCode() {
		/**
		 * 0 产生随机数10以内，根据随机数从数据库选择验证码照片
		 * x上限，y下限
		 * Math.random() * (x - y + 1) + y
		 */
		int randownum = (int) (Math.random()*(19-1+1)+1);
		System.out.println(randownum);
		//查询SQL
		String sql = "select * from yz_code where yzid ="+Integer.toString(randownum);
		
		//Class PicCode = null;
		//读数据库
		//List<PicCode> list = JDBCUtil.jdbc_query(PicCode, sql);
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int id = -1;
		String code=null,addr=null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				id = rs.getInt(1);
				code = rs.getString(2);
				addr = rs.getString(3);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		PicCode piccode = new PicCode(id, code, addr);
		System.out.println(piccode.getYzid());
		
		return piccode;
	}
	
}
