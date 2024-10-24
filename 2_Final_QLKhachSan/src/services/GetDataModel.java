package services;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.ChiTietDatPhong;
import utils.DButil;

public class GetDataModel {

	/**
	 * Lấy danh sách CTDP
	 * 
	 * @param conn
	 */
	public static List<ChiTietDatPhong> getAllCTDP(Connection conn) {
		PreparedStatement stmt = null;
		List<ChiTietDatPhong> ctdpArray = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.ChiTietDatPhong ");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ChiTietDatPhong ctdp = new ChiTietDatPhong();

				ctdp.setiDChiTietDP(rs.getString("IDChiTietDatPhong"));
				ctdp.setTenDoan(rs.getString("TenDoan"));
				ctdp.setCheckIn(rs.getDate("CheckIn").toLocalDate());
				ctdp.setCheckOut(rs.getDate("CheckOut").toLocalDate());
				ctdp.setGiaSuDungPhong(rs.getLong("GiaSuDungPhong"));
				ctdp.setGiaSuDungDichVu(rs.getLong("GiaSuDungDichVu"));

				ctdpArray.add(ctdp);
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
		return ctdpArray;
	}

	/**
	 * Lấy danh sách CTDP Chưa đến ở và hiển thị
	 * 
	 * @param conn
	 */
	public static List<ChiTietDatPhong> getCTDPUpdate(Connection conn) {
		PreparedStatement stmt = null;
		List<ChiTietDatPhong> ctdpArray = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * \r\n" + "FROM dbo.ChiTietDatPhong \r\n"
					+ "WHERE IDChiTietDatPhong NOT IN (SELECT DISTINCT IDChiTietDatPhong \r\n"
					+ "								FROM dbo.LichSuDatPhong)");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ChiTietDatPhong ctdp = new ChiTietDatPhong();

				ctdp.setiDChiTietDP(rs.getString("IDChiTietDatPhong"));
				ctdp.setTenDoan(rs.getString("TenDoan"));
				ctdp.setCheckIn(rs.getDate("CheckIn").toLocalDate());
				ctdp.setCheckOut(rs.getDate("CheckOut").toLocalDate());
				ctdp.setGiaSuDungPhong(rs.getLong("GiaSuDungPhong"));
				ctdp.setGiaSuDungDichVu(rs.getLong("GiaSuDungDichVu"));

				ctdpArray.add(ctdp);
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
		return ctdpArray;
	}

	/**
	 * Lấy danh sách CTDP không phải đang ở
	 * 
	 * @param conn
	 */
	public static List<ChiTietDatPhong> getCTDPDelete(Connection conn) {
		PreparedStatement stmt = null;
		List<ChiTietDatPhong> ctdpArray = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * \r\n" + "FROM dbo.ChiTietDatPhong \r\n"
					+ "WHERE IDChiTietDatPhong NOT IN (SELECT DISTINCT IDChiTietDatPhong \r\n"
					+ "								FROM dbo.LichSuDatPhong\r\n"
					+ "								WHERE TrangThai NOT LIKE 'Tra Phong')");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ChiTietDatPhong ctdp = new ChiTietDatPhong();

				ctdp.setiDChiTietDP(rs.getString("IDChiTietDatPhong"));
				ctdp.setTenDoan(rs.getString("TenDoan"));
				ctdp.setCheckIn(rs.getDate("CheckIn").toLocalDate());
				ctdp.setCheckOut(rs.getDate("CheckOut").toLocalDate());
				ctdp.setGiaSuDungPhong(rs.getLong("GiaSuDungPhong"));
				ctdp.setGiaSuDungDichVu(rs.getLong("GiaSuDungDichVu"));

				ctdpArray.add(ctdp);
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
		return ctdpArray;
	}

	/**
	 * Lấy danh sách CTDP Theo IDCTDP
	 * 
	 * @param conn, IDCTDP
	 */
	public static ChiTietDatPhong getCTDPByID(Connection conn, String id) {
		PreparedStatement stmt = null;
		ChiTietDatPhong ctdp = new ChiTietDatPhong();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.ChiTietDatPhong WHERE IDChiTietDatPhong LIKE ?");
			stmt.setString(1, id);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ctdp.setiDChiTietDP(rs.getString("IDChiTietDatPhong"));
				ctdp.setTenDoan(rs.getString("TenDoan"));
				ctdp.setCheckIn(rs.getDate("CheckIn").toLocalDate());
				ctdp.setCheckOut(rs.getDate("CheckOut").toLocalDate());
				ctdp.setGiaSuDungPhong(rs.getLong("GiaSuDungPhong"));
				ctdp.setGiaSuDungDichVu(rs.getLong("GiaSuDungDichVu"));
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
		return ctdp;
	}

	/**
	 * Hiển thị thông tin khách hàng theo tên
	 * 
	 * @param conn, nameKH
	 */
	public static void getInforByName(Connection conn, String name) {
		PreparedStatement stmt = null;

		try {
			stmt = conn.prepareStatement(
					"SELECT DISTINCT  KH.HoVaTen, KH.SoDienThoai, KH.CMND, KH.GioiTinh, P.IDPhong, P.GiaPhong, P.SoNguoiToiDa, LP.TenLoaiPhong\r\n"
							+ "	FROM dbo.KhachHang AS KH, dbo.Phong AS P, dbo.LoaiPhong AS LP, dbo.LichSuDatPhong AS LSDP\r\n"
							+ "	WHERE LP.IDLoaiPhong = P.IDLoaiPhong AND LSDP.IDKhachHang = KH.IDKhachHang AND LSDP.IDPhong = P.IDPhong\r\n"
							+ "		AND KH.HoVaTen LIKE ?");
			stmt.setString(1, name);

			ResultSet rs = stmt.executeQuery();
			int check = 0;
			while (rs.next()) {
				System.out.print("Ho Ten:" + rs.getString("HoVaTen"));
				System.out.print(" || SDT:" + rs.getString("SoDienThoai"));
				System.out.print(" || CMND:" + rs.getString("CMND"));
				System.out.print(" || GioiTinh:" + rs.getString("GioiTinh"));
				System.out.print(" || Ma Phong:" + rs.getString("IDPhong"));
				System.out.print(" || Gia:" + rs.getLong("GiaPhong"));
				System.out.print(" || chua toi da:" + rs.getInt("SoNguoiToiDa"));
				System.out.println(" || loai phong:" + rs.getString("TenLoaiPhong"));
				System.out.println("======================================================");
				check = 1;
			}
			if (check == 0) {
				System.out.println("Khách hàng này chưa đặt phòng!");
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
	}

	/**
	 * Lấy Tên KH theo CMND
	 * 
	 * @param conn, CMND
	 */
	public static String getNameByCMND(Connection conn, String cmnd) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT HoVaTen FROM dbo.KhachHang WHERE CMND LIKE ?");
			stmt.setString(1, cmnd);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cmnd = rs.getString("HoVaTen");
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
		return cmnd;
	}

	/**
	 * Lấy idChiTietDatPhong Theo Ten Doan Và ngày Checkin
	 * 
	 * @param conn, TenDoan, CheckIn
	 */
	public static String getIDbyCheckinAndName(Connection conn, String tenDoan, LocalDate checkIn) {
		PreparedStatement stmt = null;
		String idCTDP = null;
		try {
			stmt = conn.prepareStatement(
					"SELECT IDChiTietDatPhong FROM dbo.ChiTietDatPhong WHERE TenDoan = ? AND CheckIn = ?");
			stmt.setString(1, tenDoan);
			stmt.setDate(2, Date.valueOf(checkIn));
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				idCTDP = rs.getString("IDChiTietDatPhong");
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra " + e.getMessage());
		} finally {
			DButil.closeState(stmt);
		}
		return idCTDP;
	}

}
