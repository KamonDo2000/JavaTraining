package modelemployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModelDelete {
	public static boolean delete(Connection conn, long id) {
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE FROM dbo.Employee WHERE id = ? ";
			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			stmt.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		}finally {
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
