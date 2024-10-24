package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import utils.DButil;

public class CheckDataModel {

	/**
	 * Kiểm tra IDCTDP có tồn tại trong DB không
	 * 
	 * @param conn
	 * @param iDChiTietDP
	 * @return boolean
	 */
	public static boolean checkIDCTDP(Connection conn, String iDChiTietDP) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT IDChiTietDatPhong FROM dbo.ChiTietDatPhong WHERE IDChiTietDatPhong LIKE ?");
			stmt.setString(1, iDChiTietDP);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra " + e.getMessage());
		} finally {
			DButil.closeState(stmt);
		}
		return false;
	}

	/**
	 * Kiểm tra Tên Đoàn có tồn tại trong DB không
	 * 
	 * @param conn
	 * @param tenDoan
	 * @param checkIn
	 * @return boolean
	 */
	public static boolean checkTenDoan(Connection conn, String tenDoan, LocalDate checkIn) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT TenDoan FROM dbo.ChiTietDatPhong WHERE TenDoan = ? AND CheckIn = ?");
			stmt.setString(1, tenDoan);
			stmt.setDate(2, Date.valueOf(checkIn));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra " + e.getMessage());
		} finally {
			DButil.closeState(stmt);
		}
		return false;
	}

	/**
	 * Kiểm tra Tên KH có tồn tại trong DB không
	 * 
	 * @param conn
	 * @param tenKhachHang
	 * @return boolean
	 */
	public static boolean checkTenKhachHang(Connection conn, String tenKhachHang) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT HoVaTen FROM dbo.KhachHang WHERE HoVaTen LIKE ?");
			stmt.setString(1, tenKhachHang);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra " + e.getMessage());
		} finally {
			DButil.closeState(stmt);
		}
		return false;
	}

	/**
	 * Kiểm tra ID LSDP có tồn tại trong DB không
	 * 
	 * @param conn
	 * @param iDDatPhong
	 * @return boolean
	 */
	public static boolean checkIDDatPhong(Connection conn, String iDDatPhong) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT IDDatPhong FROM dbo.LichSuDatPhong WHERE iDDatPhong LIKE ?");
			stmt.setString(1, iDDatPhong);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra " + e.getMessage());
		} finally {
			DButil.closeState(stmt);
		}
		return false;
	}

	/**
	 * Kiểm tra có đơn đặt phòng có rỗng không
	 * 
	 * @param conn
	 * @param iDDatPhong
	 * @return boolean
	 */
	public static boolean checkDatPhongEmpty(Connection conn) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.ChiTietDatPhong");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra " + e.getMessage());
		} finally {
			DButil.closeState(stmt);
		}
		return false;
	}

	/**
	 * Kiểm tra CMND có tồn tại trong DB không
	 * 
	 * @param conn
	 * @param cmnd
	 * @return boolean
	 */
	public static boolean checkCMND(Connection conn, String cmnd) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT CMND FROM dbo.KhachHang WHERE CMND LIKE ?");
			stmt.setString(1, cmnd);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra " + e.getMessage());
		} finally {
			DButil.closeState(stmt);
		}
		return false;
	}

	/**
	 * Kiểm tra Khách hàng có đang ở trong phòng nào không
	 * 
	 * @param conn
	 * @param iDKH
	 * @return boolean
	 */
	public static boolean getKHDatPhongChua(Connection conn, String iDKH) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT IDDatPhong\r\n" + "FROM dbo.LichSuDatPhong\r\n"
					+ "WHERE IDKhachHang = ? AND TrangThai NOT LIKE 'Tra Phong'");

			stmt.setString(1, iDKH);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra " + e.getMessage());
		} finally {
			DButil.closeState(stmt);
		}
		return false;
	}

}
