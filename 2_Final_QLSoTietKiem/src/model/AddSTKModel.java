package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import controller.DBUtil;

public class AddSTKModel {

	public static void addSanPham(Connection conn, BankBook bankBook) {

		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO dbo.BankBook VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");

			stmt.setString(1, bankBook.getMaSoTK());
			stmt.setString(2, bankBook.getHoTen());
			stmt.setString(3, bankBook.getCmnd());
			stmt.setString(4, bankBook.getDiaChi());
			stmt.setString(5, bankBook.getSoDienThoai());
			stmt.setDate(6, Date.valueOf(bankBook.getNgayGuiTK()));
			stmt.setFloat(7, bankBook.getSoTien());
			stmt.setString(8, bankBook.getKyHan());
			stmt.setInt(9, bankBook.getPTTaiTuc());

			stmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DBUtil.closeState(stmt);
		}
	}

}
