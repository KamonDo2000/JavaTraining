package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.LichSuDatPhong;
import model.Phong;
import utils.DButil;

public class ChuyenPhongModel {

	/**
	 * Lấy từ data về các đối tượng LichSuDatPhong theo tên Họ tên khách và
	 * IDDatPhong của đoàn khách đó
	 * 
	 * @param conn
	 * @param name
	 * @param iDCTDP
	 * @return
	 */
	public static LichSuDatPhong getIDKHbyName(Connection conn, String name, String iDCTDP) {
		PreparedStatement stmt = null;
		LichSuDatPhong lSDP = new LichSuDatPhong();

		try {
			stmt = conn.prepareStatement(
					"SELECT LSDP.IDDatPhong, LSDP.TrangThai, LSDP.TruongPhong, LSDP.NgayBatDau, LSDP.NgayKetThuc, LSDP.IDKhachHang, LSDP.IDPhong\r\n"
							+ "FROM dbo.LichSuDatPhong AS LSDP, dbo.KhachHang AS KH\r\n"
							+ "WHERE LSDP.IDKhachHang = KH.IDKhachHang\r\n" + "AND LSDP.IDChiTietDatPhong = ? \r\n"
							+ "AND KH.HoVaTen = ?");
			stmt.setString(1, iDCTDP);
			stmt.setString(2, name);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				lSDP.setiDDatPhong(rs.getString("IDDatPhong"));
				lSDP.setTrangThai(rs.getString("TrangThai"));
				lSDP.setTruongPhong(rs.getString("TruongPhong"));
				lSDP.setNgayBatDau(rs.getDate("NgayBatDau").toLocalDate());
				lSDP.setNgayKetThuc(rs.getDate("NgayKetThuc").toLocalDate());
				lSDP.setiDKhachHang(rs.getString("IDKhachHang"));
				lSDP.setiDPhong(rs.getString("IDPhong"));
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
		return lSDP;
	}

	/**
	 * Lấy từ DB theo họ và tên và cmnd khách đang đặt phòng.
	 * 
	 * @param conn
	 * @param hoVaTen
	 * @return iD đặt phòng
	 */
	public static String checkKHDatPhong(Connection conn, String hoVaTen, String cmnd) {
		PreparedStatement stmt = null;
		String iDCTDP = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT LSDP.IDChiTietDatPhong \r\n" + "FROM dbo.LichSuDatPhong AS LSDP, dbo.KhachHang AS KH \r\n"
							+ "WHERE  LSDP.IDKhachHang = KH.IDKhachHang\r\n" + "AND KH.HoVaTen = ? \r\n"
							+ "AND KH.CMND = ? AND LSDP.TrangThai LIKE 'Dang Thue Phong'");

			stmt.setString(1, hoVaTen);
			stmt.setString(2, cmnd);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				iDCTDP = rs.getString("IDChiTietDatPhong");
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra " + e.getMessage());
		} finally {
			DButil.closeState(stmt);
		}
		return iDCTDP;
	}

	/**
	 * Lấy Danh sách gồm IDPhong, SoNguoiToiDa, GiaPhong. Của những phong dang trong
	 * 
	 * @param conn
	 * @param hoVaTen
	 * @return List<Phong> phongArr
	 */
	public static List<Phong> getPhongTrong(Connection conn) {
		PreparedStatement stmt = null;
		List<Phong> phongArr = new ArrayList<>();
		try {
			stmt = conn.prepareStatement(
					"SELECT IDPhong, SoNguoiToiDa, GiaPhong FROM dbo.Phong WHERE TrangThai LIKE 'Trong'");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Phong phong = new Phong();
				phong.setiDPhong(rs.getString("IDPhong"));
				phong.setSoNguoiToiDa(rs.getInt("SoNguoiToiDa"));
				phong.setGiaPhong(rs.getLong("GiaPhong"));

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
	 * Get phòng chung group và số người tối đa > số người trong phòng hiện tại
	 * 
	 * @param conn
	 */
	public static List<Phong> getPhongChungGroup(Connection conn, String iDCTDP, String idPhong) {
		PreparedStatement stmt = null;
		List<Phong> phongArr = new ArrayList<>();
		try {
			stmt = conn.prepareStatement(
					"SELECT LSDP.IDPhong, COUNT(LSDP.IDPhong) AS SoNguoiTrongPhong,  P.SoNguoiToiDa, P.GiaPhong\r\n"
							+ "FROM dbo.LichSuDatPhong AS LSDP, dbo.Phong AS P\r\n"
							+ "WHERE P.IDPhong = LSDP.IDPhong AND LSDP.TrangThai LIKE 'Dang Thue Phong' AND LSDP.IDChiTietDatPhong LIKE ? AND LSDP.IDPhong NOT LIKE ? \r\n"
							+ "GROUP BY LSDP.IDPhong, P.SoNguoiToiDa, P.GiaPhong \r\n"
							+ "HAVING P.SoNguoiToiDa > COUNT(LSDP.IDPhong)");

			stmt.setString(1, iDCTDP);
			stmt.setString(2, idPhong);

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
	 * Cập nhật lại LSDP trạng thái Khách đangthuêphòng thành chuyenPhong
	 * 
	 * @param conn
	 * @param idKH
	 * @param iDCTDP
	 */
	public static void updateLSDP(Connection conn, String idKH, String iDCTDP) {
		PreparedStatement stmt = null;
		LocalDate ngayChuyen = LocalDate.now();
		try {
			stmt = conn.prepareStatement(
					"UPDATE dbo.LichSuDatPhong \r\n" + "SET TrangThai = 'Chuyen Phong', NgayKetThuc = ? \r\n"
							+ "WHERE TrangThai = 'Dang Thue Phong' AND IDKhachHang = ? AND IDChiTietDatPhong = ?");

			stmt.setDate(1, Date.valueOf(ngayChuyen));
			stmt.setString(2, idKH);
			stmt.setString(3, iDCTDP);

			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
	}

	/**
	 * Tạo mới LSDP khi khách chuyển phòng đi.
	 * 
	 * @param conn
	 * @param idDP
	 * @param isCaptain
	 * @param ngayKT
	 * @param idKH
	 * @param iDCTDP
	 * @param idPhong
	 */
	public static void createLSDP(Connection conn, String idDP, String isCaptain, LocalDate ngayKT, String idKH,
			String iDCTDP, String idPhong) {
		PreparedStatement stmt = null;
		LocalDate ngayChuyen = LocalDate.now();
		try {
			stmt = conn.prepareStatement(
					"INSERT INTO dbo.LichSuDatPhong VALUES	(?, 'Dang Thue Phong', ?, ?, ?, ?, ?, ?);");

			stmt.setString(1, idDP);
			stmt.setString(2, isCaptain);
			stmt.setDate(3, Date.valueOf(ngayChuyen));
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
