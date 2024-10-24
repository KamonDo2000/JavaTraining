package ultil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DButil {
	private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=FINAL_EXAM";
	private static final String USER = "sa";
	private static final String PW = "123456";

	public static Connection connectDB() {
		Connection conn;
		try {
			conn = DriverManager.getConnection(URL, USER, PW);
			return conn;
		} catch (SQLException e) {
			System.out.println("Kết nối thất bại!!!");
			System.err.println(e);
			return null;
		}
	}

	public static void close(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}

	public static void closeState(PreparedStatement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}
}
