package modelemployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModelUpdate {

	public static boolean update(Connection conn, Employee employee) {
		PreparedStatement stmt = null;
		try {
			String sql = "UPDATE Employee SET name = ?, age= ?, diachi = ?, salary= ?, sumTimeWork= ? WHERE id = ?;";
			stmt = conn.prepareStatement(sql);

			stmt.setLong(6, employee.getId());
			stmt.setString(1, employee.getName());
			stmt.setInt(2, employee.getAge());
			stmt.setString(3, employee.getAddress());
			stmt.setDouble(4, employee.getSalary());
			stmt.setInt(5, employee.getSumTimeWork());

			stmt.executeUpdate();

			return true;
		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return false;
	}

}
