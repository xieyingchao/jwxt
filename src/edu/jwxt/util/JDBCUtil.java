package edu.jwxt.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;

public class JDBCUtil {

	/**
	 * 对指定的sql进行修改操作（insert\ update\ delete）
	 * @param sql 以preparedstatement方式执行的带问号参数的业务sql
	 * @param params sql对应的参数值（顺序和业务sql参数一致）
	 * @return i：业务sql执行后影响的记录条数
	 */
	public static int jdbc_update(String sql,Object... params) {
		PreparedStatement pstmt = null;
		Connection conn = DBUtil.getConn();
		int i = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			if(null != params) {
				for(int j=0;j<params.length;j++) {
					pstmt.setObject(j+1, params[j]);
				}
			}
			i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	/**
	 * 实现对任意sql的查询
	 * 注意：参数和sql位置要一一对应，查询的结果字段要和封装的类的属性一致
	 * @param <T> 查询结果封装的类型
	 * @param classes 查询结果封装的类型
	 * @param query_sql 查询sql
	 * @param params 查询sql中对应的参数
	 * @return List<T>
	 */
	public static <T> List<T> jdbc_query(Class<T> classes,String query_sql,Object... params){
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		List<T> list = null;
		try {
			pstmt = conn.prepareStatement(query_sql);
			
			if(null != params) {
				for(int j=0;j<params.length;j++) {
					pstmt.setObject(j+1, params[j]);
				}
			}
			
			ResultSet rs = pstmt.executeQuery();
			// 获取rs的元数据
			ResultSetMetaData rsmd = rs.getMetaData();
			// 获取列的长度
			int length = rsmd.getColumnCount();

			list = new ArrayList<T>();
			Map<String,Object> map = new HashMap<String, Object>(); 
			while(rs.next()) {
				// 获取一行结果
				for(int k=0;k<length;k++) {
					Object obj = rs.getObject(k+1);
					map.put(rsmd.getColumnLabel(k+1), obj);
				}
				// 通过类对象构建一个类的对象
				T t = classes.newInstance();
				BeanUtils.populate(t, map);
				list.add(t);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 实现对任意sql的查询总记录条数
	 * 注意：参数和sql位置要一一对应，查询的结果字段要和封装的类的属性一致
	 * @param <T> 查询结果封装的类型
	 * @param classes 查询结果封装的类型
	 * @param query_sql 查询sql
	 * @param params 查询sql中对应的参数
	 * @return int 总记录条数
	 */
	public static <T> int jdbc_query_count(Class<T> classes,String query_sql,Object... params){
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		int i = 0;
		try {
			pstmt = conn.prepareStatement(query_sql);
			if(null != params) {
				for(int j=0;j<params.length;j++) {
					pstmt.setObject(j+1, params[j]);
				}
			}
			
			ResultSet rs = pstmt.executeQuery();
			 
			rs.next();
			i = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

}
