package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import model.ChiTietDatPhong;
import utils.DButil;

public class InsertDataModel {
	/**
	 * Truyền vào đối tượng CTDP tạo mới một Chi tiết đặt phòng trên Database
	 *
	 * @param ChiTietDatPhong
	 */
	public static void insertDatPhong(Connection conn, ChiTietDatPhong ctdp) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("INSERT INTO dbo.ChiTietDatPhong VALUES (?, ?, ?, ?, ?, ?, ?)");

			stmt.setString(1, ctdp.getiDChiTietDP());
			stmt.setString(2, ctdp.getTenDoan());
			stmt.setDate(3, Date.valueOf(ctdp.getCheckIn()));
			stmt.setDate(4, Date.valueOf(ctdp.getCheckOut()));
			stmt.setLong(5, ctdp.getGiaSuDungPhong());
			stmt.setLong(6, ctdp.getGiaSuDungDichVu());
			stmt.setLong(7, ctdp.getTongTien());

			int cnt = stmt.executeUpdate();
			System.out.println("Thêm thành công " + cnt + " đơn đặt phòng!");

		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
	}

}
