package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.time.LocalDate;

import controller.DBUtil;

public class UpdateSTKModel {
	public static void updateByMaSTK(Connection conn, String maSTK, LocalDate ngayGuiTK, float soTien, String kyHan) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("UPDATE dbo.BankBook SET NgayGuiTK=?, SoTien=?, KyHan=? WHERE MaSoTK = ?");

			stmt.setDate(1, Date.valueOf(ngayGuiTK));
			stmt.setFloat(2, soTien);
			stmt.setString(3, kyHan);

			stmt.setString(4, maSTK);

			stmt.executeUpdate();
			System.out.println("Đã update sổ tiết kiệm " + maSTK + " thành công");
			System.out.println("====================");

		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DBUtil.closeState(stmt);
		}
	}
}
