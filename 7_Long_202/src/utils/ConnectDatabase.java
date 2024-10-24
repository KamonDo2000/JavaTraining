package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {

	private final String dBName = "CandidateManagement";

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		String connectionUrl = "jdbc:jtds:sqlserver://localhost:1433;databaseName=" + dBName
				+ ";user=sa;password=12345;integratedSecurity=true;trustServerCertificate=true";
		try {
			conn = DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
