package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import model.ChiTietDatPhong;
import utils.DButil;

public class UpdateDataModel {

	/**
	 * Cập nhật CTDP khi Đoàn đó chưa đến ở
	 * 
	 * @param conn
	 * @param ctdp
	 */
	public static void updateCTDP(Connection conn, ChiTietDatPhong ctdp) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"UPDATE dbo.ChiTietDatPhong SET TenDoan = ?, CheckIn = ?, CheckOut = ? WHERE IDChiTietDatPhong = ?");

			stmt.setString(1, ctdp.getTenDoan());
			stmt.setDate(2, Date.valueOf(ctdp.getCheckIn()));
			stmt.setDate(3, Date.valueOf(ctdp.getCheckOut()));
			stmt.setString(4, ctdp.getiDChiTietDP());

			stmt.executeUpdate();
			System.out.println("Update thành công đơn đặt phòng!");

		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
	}

}
