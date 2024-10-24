package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import controller.DBUtil;

public class AddOrderModel {
	public static void addSanPham(Connection conn, Order order) {

		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO dbo.orderIP VALUES (?, ?, ?, ?, ?, ?, ?)");

			stmt.setString(1, order.getMaOder());
			stmt.setString(2, order.getTenKhachHang());
			stmt.setString(3, order.getSoDienThoai());
			stmt.setString(4, order.getTenSanPham());
			stmt.setInt(5, order.getSoLuong());
			stmt.setInt(6, order.getDonGia());
			stmt.setDate(7, Date.valueOf(order.getNgayOrder()));

			int cnt = stmt.executeUpdate();
			System.out.println("Thêm thành công " + cnt + " order!");

		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DBUtil.closeState(stmt);
		}
	}
}
