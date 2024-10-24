package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DButil {
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=QL_Khach_San";
	private static final String USER = "sa";
	private static final String PW = "123456";

	/**
	 * Connect DB QL_Khach_San
	 * 
	 * @return
	 */
	public static Connection connectDB() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, USER, PW);
			System.out.println("Kết nối thành công!!!");
			return conn;
		} catch (SQLException e) {
			System.out.println("Kết nối thất bại!!!");
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Close DB QL_Khach_San
	 * 
	 * @return
	 */
	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * truyền vào 1 state và Close state nếu nó không null
	 * 
	 * @return
	 */
	public static void closeState(PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
