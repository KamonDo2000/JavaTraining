package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Phong;
import utils.DButil;

public class ChangeStatusPhongModel {
	
	/**
	 * Lấy về một List tất cả các ID phòng
	 * 
	 * @param conn
	 * @return
	 */
	public static List<Phong> getAllIDPhong(Connection conn) {
		PreparedStatement stmt = null;
		List<Phong> phongArr = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT IDPhong FROM dbo.Phong");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Phong phong = new Phong();
				phong.setiDPhong(rs.getString("IDPhong"));
				phongArr.add(phong);
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
		return phongArr;
	}

	/**
	 * Cập nhật trạng thái của IDPhong thành trangThai
	 * 
	 * @param conn
	 * @param idPhong
	 * @param trangThai
	 */
	public static void updateTrangThaiPhong(Connection conn, String idPhong, String trangThai) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("UPDATE dbo.Phong SET TrangThai = ? WHERE IDPhong = ?");
			stmt.setString(1, trangThai);
			stmt.setString(2, idPhong);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
	}

	/**
	 * Truyền vào idPhong kiểm tra số người đang ở trong Phòng đó
	 * 
	 * @param conn
	 * @param idPhong
	 * @return
	 */
	public static int checkNguoiTrongPhong(Connection conn, String idPhong) {
		PreparedStatement stmt = null;
		int soNguoi = 0;
		try {
			stmt = conn.prepareStatement(
					"SELECT COUNT(IDPhong) AS soNguoiTrongPhong FROM dbo.LichSuDatPhong  WHERE TrangThai = 'Dang Thue Phong' AND IDPhong = ? GROUP BY IDPhong");
			stmt.setString(1, idPhong);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				soNguoi = rs.getInt("soNguoiTrongPhong");
			}

			return soNguoi;
		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
			return soNguoi;
		} finally {
			DButil.closeState(stmt);
		}
	}

}
