package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import controller.DBUtil;

public class DeleteProductModel {

	public static void deleteProductQuaHan(Connection conn, LocalDate day) {
		PreparedStatement stmt = null;
		try {
			String sql = "DELETE FROM dbo.product WHERE dateExp < ? ";
			stmt = conn.prepareStatement(sql);

			stmt.setDate(1, Date.valueOf(day));

			int cmt = stmt.executeUpdate();
			System.out.println("Đã xoa " + cmt + " record!");
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DBUtil.closeState(stmt);
		}
	}

}
