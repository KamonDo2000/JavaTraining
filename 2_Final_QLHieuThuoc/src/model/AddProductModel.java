package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import controller.DBUtil;

public class AddProductModel {
	
	public static void addSanPham(Connection conn, SanPham sanpham) {
		PreparedStatement stmt = null;
		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement("INSERT INTO dbo.product VALUES (?, ?, ?, ?, ?)");

			stmt.setString(1, sanpham.getId());
			stmt.setString(2, sanpham.getName());
			stmt.setDate(3, Date.valueOf(sanpham.getHanSuDung()));
			stmt.setInt(4, sanpham.getSoLuongNhapVao());
			stmt.setInt(5, sanpham.getSoLuongDaBan());

			int cnt = stmt.executeUpdate();
			System.out.println("Đã Thêm " + cnt + " record!");
			
			conn.commit();
			conn.setAutoCommit(true);

		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DBUtil.closeState(stmt);
		}
	}
	
}
