package com.jiang.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public class ConnectionManager {
	// 防止并发出现问题
	private static final List<Connection> pool = Collections
			.synchronizedList(new ArrayList<Connection>());
	private static final Properties ps = new Properties();

	private ConnectionManager() {

	}

	static {
		try {
			loadProperties();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception {
		Connection conn = null;
		if (pool.isEmpty()) {
			String url = ps.getProperty("url");
			String username = ps.getProperty("username");
			String password = ps.getProperty("password");
			conn = DriverManager.getConnection(url, username, password);

		} else {
			// 从队尾去取连接
			conn = pool.remove(pool.size() - 1);
		}
		return conn;
	}

	public static void closeConnection(Connection conn) throws Exception {
		if (conn != null) {
			if (pool.size() > 10) {
				conn.close();
			} else {
				pool.add(conn);
			}
		}
	}

	// 驱动加载
	private static void loadProperties() throws Exception {
		if (ps.isEmpty()) {
			InputStream is = ConnectionManager.class
					.getResourceAsStream("database.properties");
			ps.load(is);
			String className = ps.getProperty("driver");
			Class.forName(className);
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println(getConnection());
	}
	
}
