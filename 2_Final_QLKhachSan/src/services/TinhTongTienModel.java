package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DichVu;
import model.LichSuDatPhong;
import utils.DButil;

public class TinhTongTienModel {

	/**
	 * Kiểm tra Group đó có phòng nào đang ở không
	 * 
	 * 
	 * @param conn
	 * @param idCTDP
	 * @return boolean
	 */
	public static boolean checkLSDPGroup(Connection conn, String idCTDP) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT IDDatPhong\r\n" + "FROM dbo.LichSuDatPhong \r\n"
					+ "WHERE TrangThai NOT LIKE 'Tra Phong' AND IDChiTietDatPhong = ?");
			stmt.setString(1, idCTDP);
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
	 * Trả về danh sách Phòng và giá phòng trong Group đang được ở
	 * 
	 * @param conn
	 * @param iDCTDP
	 * @return
	 */
	public static List<LichSuDatPhong> getAllPhongInGroup(Connection conn, String iDCTDP) {
		PreparedStatement stmt = null;
		List<LichSuDatPhong> lsdpArr = new ArrayList<>();
		try {
			stmt = conn.prepareStatement(
					"SELECT LSDP.IDPhong, MIN(LSDP.NgayBatDau) AS NgayBatDau, MAX(LSDP.NgayKetThuc) AS NgayKetThuc, P.GiaPhong\r\n"
							+ "FROM dbo.LichSuDatPhong AS LSDP, dbo.Phong AS P\r\n"
							+ "WHERE LSDP.IDPhong = P.IDPhong\r\n" + "AND LSDP.TrangThai NOT LIKE 'Tra Phong' \r\n"
							+ "AND LSDP.IDChiTietDatPhong = ?\r\n" + "GROUP BY LSDP.IDPhong, P.GiaPhong");

			stmt.setString(1, iDCTDP);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				LichSuDatPhong lsdp = new LichSuDatPhong();
				lsdp.setiDPhong(rs.getString("IDPhong"));
				lsdp.setNgayBatDau(rs.getDate("NgayBatDau").toLocalDate());
				lsdp.setNgayKetThuc(rs.getDate("NgayKetThuc").toLocalDate());
				lsdp.setGiaPhong(rs.getLong("GiaPhong"));

				lsdpArr.add(lsdp);
			}

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
		return lsdpArr;
	}

	/**
	 * Trả về danh sách Dịch vụ và giá dịch vụ Group đã sử dụng
	 * 
	 * @param conn
	 * @param iDCTDP
	 * @return
	 */
	public static List<DichVu> getAllDichVuInGroup(Connection conn, String iDCTDP) {
		PreparedStatement stmt = null;
		List<DichVu> dichVuArr = new ArrayList<>();
		try {
			stmt = conn.prepareStatement(
					"SELECT DV.TenDichVu, SUM(LSDV.SoLuong) AS SoLuong, SUM(LSDV.SoLuong * DV.GiaDichVu) AS TongTien\r\n"
							+ "	FROM dbo.DichVu AS DV, dbo.LichSuDichVu AS LSDV \r\n"
							+ "	WHERE DV.IDDichVu = LSDV.IDDichVu\r\n" + "		AND LSDV.IDChiTietDatPhong = ?\r\n"
							+ "		AND LSDV.TrangThai = 'Chua Thanh Toan'\r\n"
							+ "	GROUP BY LSDV.IDDichVu, LSDV.IDChiTietDatPhong, DV.TenDichVu");

			stmt.setString(1, iDCTDP);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				DichVu dichVu = new DichVu();
				dichVu.setTenDichVu(rs.getString("TenDichVu"));
				dichVu.setSoLuong(rs.getInt("SoLuong"));
				dichVu.setGiaDichVu(rs.getLong("TongTien"));

				dichVuArr.add(dichVu);
			}

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
		return dichVuArr;
	}

	/**
	 * Cập nhật lại Đặt Phòng (ChiTietDatPhong) khi tính các loại tiền đoàn phải trả
	 * 
	 * @param conn
	 * @param idCTDP
	 * @param giaP
	 * @param giaDV
	 */
	public static void updateCTDP(Connection conn, String idCTDP, long giaP, long giaDV) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"UPDATE dbo.ChiTietDatPhong SET GiaSuDungPhong = ?, GiaSuDungDichVu = ?, TongTien = ? WHERE IDChiTietDatPhong = ?");

			stmt.setLong(1, giaP);
			stmt.setLong(2, giaDV);
			stmt.setLong(3, (giaDV + giaP));
			stmt.setString(4, idCTDP);

			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
	}

}
