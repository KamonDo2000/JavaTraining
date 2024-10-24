package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.DButil;

public class GenerateIDmodel {

	/**
	 * Hàm trả về IDDatPhong lớn nhất trong DB
	 * @param conn
	 * @return
	 */
	public static String getIDDatPhongforGroup(Connection conn) {
		PreparedStatement stmt = null;
		String iDLSDP = null;
		try {
			stmt = conn.prepareStatement("SELECT TOP 1 IDDatPhong FROM dbo.LichSuDatPhong ORDER BY IDDatPhong DESC");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				iDLSDP = rs.getString("IDDatPhong");
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
		return iDLSDP;
	}

	/**
	 * Hàm trả về IDChiTietDatPhong lớn nhất trong DB
	 * @param conn
	 * @return
	 */
	public static String getIDforCTDP(Connection conn) {
		PreparedStatement stmt = null;
		String iCTDP = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT TOP 1 IDChiTietDatPhong FROM dbo.ChiTietDatPhong ORDER BY IDChiTietDatPhong DESC");

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				iCTDP = rs.getString("IDChiTietDatPhong");
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
		return iCTDP;
	}

}
