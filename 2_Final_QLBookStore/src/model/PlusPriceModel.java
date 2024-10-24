package model;

import java.sql.Connection;
import java.sql.PreparedStatement;

import controller.DBUtil; 

public class PlusPriceModel {
	public static void updatePrice(Connection conn, String author, String title) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("UPDATE dbo.ebookshop " + "SET price = price + (price*0.5) "
					+ "WHERE title LIKE ? OR author LIKE ?");

			stmt.setString(1, title);
			stmt.setString(2, author);

			int cnt = stmt.executeUpdate();
			System.out.println("Update thành công " + cnt + " record!");

		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DBUtil.closeState(stmt);
		}
	}
}
