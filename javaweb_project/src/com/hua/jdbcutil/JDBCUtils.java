package com.hua.jdbcutil;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
/**
 * JDBC操作的工具类
 * @author hua
 *
 */
public class JDBCUtils {
	private static DataSource dataSource = null;
	
	static{
		//数据源只能被创建一次
		dataSource = new ComboPooledDataSource("hua.project");
	}
	
	/**
	 * 
	 * @return 数据源的一个Connection对象
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
	/**
	 * 关闭Connection连接
	 * @param conn
	 */
	public static void closeConnection(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
