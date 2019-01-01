package edu.hyit.bm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DbUtils {

	private static String url = "jdbc:mysql://localhost:3306/bm?useUnicode=true&characterEncoding=utf8";
	private static String username = "root";
	private static String password = "1234";
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static Connection getConn() throws SQLException {
		return DriverManager.getConnection(url, username, password);
	
	}
	
	public static void free(ResultSet rs,Statement stmt,Connection conn) {
		try {
			if(rs!=null) {				
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
