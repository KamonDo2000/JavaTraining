package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import controller.DBUtil;

public class DeleteAllData {
	public static void delete(Connection conn) {
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE FROM dbo.BankBook";
			stmt = conn.prepareStatement(sql);

			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DBUtil.closeState(stmt);
		}
	}
}
