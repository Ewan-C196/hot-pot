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
	 * ��������
	 */
	static {

		try {
			//ͨ������������db.properties�ļ�������
			InputStream ips = DBTools.class.getClassLoader().getResourceAsStream("config/db.properties");
			//����һ����
			Properties properties = new Properties();
			//������
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
	 * ��ȡ���ݿ����ӷ���
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
	 * �ر���Դ��
	 * @param rs  �����
	 * @param ps  Ԥ����
	 * @param conn ���ݿ����Ӷ���
	 */
	public static void close(ResultSet rs ,PreparedStatement ps, Connection conn) {
		try {
			if(rs != null) {//�ȹرս����
				rs.close();
			}
			if(ps != null) {//�ر�Ԥ����
				ps.close();
			}
			if(conn != null) {//�ر�����
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	
	
	
	

}
