package services;

import java.sql.Connection;
import java.sql.PreparedStatement;

import utils.DButil;

public class DeleteDataModel {

	/**
	 * Xóa LichSuDichVu và ChiTietDatPhong theo id ChiTietDatPhong truyền vào
	 * 
	 * @param conn
	 * @param id
	 */
	public static void deleteCTDP(Connection conn, String id) {
		PreparedStatement stmt = null;
		PreparedStatement stmtLSDP = null;
		PreparedStatement stmtLSDV = null;
		try {
			stmtLSDV = conn.prepareStatement("DELETE FROM dbo.LichSuDichVu WHERE IDChiTietDatPhong = ?");
			stmtLSDP = conn.prepareStatement("DELETE FROM dbo.LichSuDatPhong WHERE IDChiTietDatPhong = ?");
			stmt = conn.prepareStatement("DELETE FROM dbo.ChiTietDatPhong WHERE IDChiTietDatPhong = ?");

			stmtLSDV.setString(1, id);
			stmtLSDP.setString(1, id);
			stmt.setString(1, id);

			int cnt = stmtLSDV.executeUpdate();
			int cmt = stmtLSDP.executeUpdate();
			stmt.executeUpdate();

			if (cnt > 0) {
				System.out.println("Xóa lịch sử dịch vụ đơn đặt phòng " + id);
			} else if (cmt > 0) {
				System.out.println("Xóa lịch sử đặt phòng đơn đặt phòng " + id);
			}

			System.out.println("Xóa thành công đơn đặt phòng!");

		} catch (Exception e) {
			System.err.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DButil.closeState(stmtLSDV);
			DButil.closeState(stmtLSDP);
			DButil.closeState(stmt);
		}
	}

}
