package modelemployee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class model_CheckID {
	public static boolean checkID(Connection conn, long id) {
		try {
			String sql = "SELECT id FROM dbo.Employee WHERE id LIKE ? ";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			ResultSet result = stmt.executeQuery();

			while (result.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		}

		return false;
	}
}
