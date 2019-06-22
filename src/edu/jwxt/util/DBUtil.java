package edu.jwxt.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.jwxt.config.*;
/**
 * @fileName: DBUtil.java
 * @describe:
 * @author: roben.he
 * @date: 2019年6月20日
 * @version: 1.0.0
 */
public class DBUtil {
	
	// 硬编码：把一些会动态改变的值写死在代码中
	private static final String url = Config.MYSQL_CONN_URL;
	private static final String user = Config.MYSQL_USERNAME;
	private static final String password = Config.MYSQL_PASSWORD;
	private static final String path = Config.MYSQL_DRIVERCLASS_PATH;
	
	private static Connection conn = null;
	
	static {
		try {
			Class.forName(path);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取jdbc的连接对象
	 * 单例模式：在整个应用中只返回一个对象
	 * @return Connection
	 */
	public static Connection getConn() {
		try {
			// 当conn对象不等于null且对象未被关闭,conn.close()并不会把conn对象置为null，只是状态的改变
			if(null != conn && !conn.isClosed()) {
				return conn;
			}else{
				conn = DriverManager.getConnection(url, user, password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	
	/**
	 * 关闭jdbc资源
	 * @param rs
	 * @param pstmt
	 * @param conn
	 */
	public static void close(ResultSet rs,PreparedStatement pstmt,Connection conn) {
		try {
			if(null != rs) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(null != pstmt) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
