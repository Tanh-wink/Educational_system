package com.hua.test;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import com.hua.jdbcutil.JDBCUtils;

public class JDBCUtilsTest {

	@Test
	public void test() throws SQLException {
		Connection conn = null;
		conn = JDBCUtils.getConnection();
		System.out.println(conn);
		JDBCUtils.closeConnection(conn);
	}

}
