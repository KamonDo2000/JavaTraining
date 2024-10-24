package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.DBUtil;

public class SortOrderModel {

	public static ArrayList<Order> sortOrder(Connection conn) {
		PreparedStatement stmt = null;
		ArrayList<Order> arrOrder = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.orderIP ORDER BY ngayOrder DESC, maOder ASC");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Order order = new Order();

				order.setMaOder(rs.getString("maOder"));
				order.setTenKhachHang(rs.getString("tenKhachHang"));
				order.setSoDienThoai(rs.getString("soDienThoai"));
				order.setTenSanPham(rs.getString("tenSanPham"));
				order.setSoLuong(rs.getInt("soLuong"));
				order.setDonGia(rs.getInt("donGia"));

				String date = rs.getDate("ngayOrder").toString();
				order.setNgayOrder(LocalDate.parse(date));

				arrOrder.add(order);
			}
			return arrOrder;

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
			return arrOrder;
		} finally {
			DBUtil.closeState(stmt);
		}
	}

}
