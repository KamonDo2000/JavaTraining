package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.ChiTietDatPhong;
import model.Phong;
import utils.DButil;

public class XepPhongModel {

	/**
	 * Lấy ID khách hàng mới nhất được tạo trong DS khách theo CMND
	 * 
	 * @param conn
	 * @param cmnd
	 * @return
	 */
	public static String getIDKhachHangByCMND(Connection conn, String cmnd) {
		PreparedStatement stmt = null;
		String iDKH = null;
		try {
			stmt = conn.prepareStatement("SELECT TOP 1 IDKhachHang \r\n" + "FROM dbo.KhachHang\r\n"
					+ "WHERE CMND = ?\r\n" + "ORDER BY IDKhachHang DESC");

			stmt.setString(1, cmnd);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				iDKH = rs.getString("IDKhachHang");
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra " + e.getMessage());
		} finally {
			DButil.closeState(stmt);
		}
		return iDKH;
	}

	/**
	 * Lấy IDChiTietDatPhong, Ngày CheckIn, checkOut theo Tên Đoàn Mục đích để Xác
	 * định khách hàng A thuộc về đoàn nào khi tạo mới LSDP
	 * 
	 * @param conn
	 * @param tenDoan
	 * @return
	 */
	public static ChiTietDatPhong getCTDPByTenDoan(Connection conn, String tenDoan) {
		PreparedStatement stmt = null;
		ChiTietDatPhong ctdp = new ChiTietDatPhong();
		try {
			stmt = conn.prepareStatement("SELECT IDChiTietDatPhong, CheckIn, CheckOut\r\n"
					+ "FROM dbo.ChiTietDatPhong\r\n" + "WHERE TenDoan = ?");

			stmt.setString(1, tenDoan);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				ctdp.setiDChiTietDP(rs.getString("IDChiTietDatPhong"));
				ctdp.setCheckIn(rs.getDate("CheckIn").toLocalDate());
				ctdp.setCheckOut(rs.getDate("CheckOut").toLocalDate());
			}

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
		return ctdp;
	}

	/**
	 * Get phòng chung group và số người tối đa > số người trong phòng hiện tại
	 * 
	 * @param conn
	 */
	public static List<Phong> getPhongChungGroup(Connection conn, String iDCTDP) {
		PreparedStatement stmt = null;
		List<Phong> phongArr = new ArrayList<>();
		try {
			stmt = conn.prepareStatement(
					"SELECT LSDP.IDPhong, COUNT(LSDP.IDPhong) AS SoNguoiTrongPhong,  P.SoNguoiToiDa, P.GiaPhong\r\n"
							+ "FROM dbo.LichSuDatPhong AS LSDP, dbo.Phong AS P\r\n"
							+ "WHERE P.IDPhong = LSDP.IDPhong AND LSDP.TrangThai LIKE 'Dang Thue Phong' AND LSDP.IDChiTietDatPhong LIKE ? \r\n"
							+ "GROUP BY LSDP.IDPhong, P.SoNguoiToiDa, P.GiaPhong \r\n"
							+ "HAVING P.SoNguoiToiDa > COUNT(LSDP.IDPhong)");

			stmt.setString(1, iDCTDP);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Phong phong = new Phong();

				phong.setiDPhong(rs.getString("IDPhong"));
				phong.setSoNguoiTrongPhong(rs.getInt("SoNguoiTrongPhong"));
				phong.setSoNguoiToiDa(rs.getInt("SoNguoiToiDa"));
				phong.setGiaPhong(rs.getLong("GiaPhong"));

				if (phong.getSoNguoiToiDa() > phong.getSoNguoiTrongPhong()) {
					phongArr.add(phong);
				}

			}
			return phongArr;
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
			return phongArr;
		} finally {
			DButil.closeState(stmt);
		}
	}

	/**
	 * Tạo mới LSDP khi xếp phòng cho khách
	 * 
	 * @param conn
	 * @param idDP
	 * @param isCaptain
	 * @param ngayBD
	 * @param ngayKT
	 * @param idKH
	 * @param iDCTDP
	 * @param idPhong
	 */
	public static void createLSDP(Connection conn, String idDP, String isCaptain, LocalDate ngayKT,
			String idKH, String iDCTDP, String idPhong) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"INSERT INTO dbo.LichSuDatPhong VALUES	(?, 'Dang Thue Phong', ?, ?, ?, ?, ?, ?);");

			stmt.setString(1, idDP);
			stmt.setString(2, isCaptain);
			stmt.setDate(3, Date.valueOf(LocalDate.now()));
			stmt.setDate(4, Date.valueOf(ngayKT));
			stmt.setString(5, idKH);
			stmt.setString(6, iDCTDP);
			stmt.setString(7, idPhong);

			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
	}

}
