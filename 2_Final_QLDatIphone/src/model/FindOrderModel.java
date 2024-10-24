package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.DBUtil;

public class FindOrderModel {

	public static ArrayList<Order> findByDate(Connection conn, LocalDate ngayStart, LocalDate ngayEnd) {
		PreparedStatement stmt = null;
		ArrayList<Order> arrOrder = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.orderIP WHERE ngayOrder > ? AND ngayOrder < ?");

			stmt.setDate(1, Date.valueOf(ngayEnd));
			stmt.setDate(2, Date.valueOf(ngayStart));

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

	public static ArrayList<Order> findByDate(Connection conn, LocalDate nDate) {
		PreparedStatement stmt = null;
		ArrayList<Order> arrOrder = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.orderIP WHERE ngayOrder = ?");

			stmt.setDate(1, Date.valueOf(nDate));

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
