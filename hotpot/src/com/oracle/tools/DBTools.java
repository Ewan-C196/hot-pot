package com.oracle.tools;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBTools {
	
	private static String DRIVER;
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	
	/**
	 * 加载驱动
	 */
	static {

		try {
			//通过反射来加载db.properties文件的内容
			InputStream ips = DBTools.class.getClassLoader().getResourceAsStream("config/db.properties");
			//返回一个流
			Properties properties = new Properties();
			//加载流
			properties.load(ips);
			
			DRIVER = properties.getProperty("driver");
			URL = properties.getProperty("url");
			USER = properties.getProperty("user");
			PASSWORD = properties.getProperty("password");
			
			Class.forName(DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 获取数据库连接方法
	 * @return
	 */
	public static Connection getConn() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * 关闭资源的
	 * @param rs  结果集
	 * @param ps  预编译
	 * @param conn 数据库连接对象
	 */
	public static void close(ResultSet rs ,PreparedStatement ps, Connection conn) {
		try {
			if(rs != null) {//先关闭结果集
				rs.close();
			}
			if(ps != null) {//关闭预编译
				ps.close();
			}
			if(conn != null) {//关闭连接
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	
	
	

}
