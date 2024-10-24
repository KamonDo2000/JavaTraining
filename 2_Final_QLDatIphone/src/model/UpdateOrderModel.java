package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import controller.DBUtil;

public class UpdateOrderModel {

	public static void updatePrice(Connection conn, LocalDate date, String tenSanPham, int giamGia) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("UPDATE dbo.orderIP " + "SET donGia = donGia - (donGia*?/100) "
					+ "WHERE tenSanPham LIKE ? AND ngayOrder < ?");

			stmt.setInt(1, giamGia);
			stmt.setString(2, tenSanPham);
			stmt.setDate(3, Date.valueOf(date));

			int cnt = stmt.executeUpdate();
			System.out.println("Update thành công " + cnt + " record!");

		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DBUtil.closeState(stmt);
		}
	}
	
}
