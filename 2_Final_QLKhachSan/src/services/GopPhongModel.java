package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.LichSuDatPhong;
import model.Phong;
import utils.DButil;

public class GopPhongModel {

	/**
	 * Truyền vào ID đặt phòng của Group và trả về số thành viên trong Group đó
	 * 
	 * @param conn
	 * @param iDChiTietDatPhong
	 * @return
	 */
	public static int getThanhVienTrongGroup(Connection conn, String iDChiTietDatPhong) {
		PreparedStatement stmt = null;
		int soNguoiTrongGroup = 0;
		try {
			stmt = conn.prepareStatement("SELECT COUNT(IDChiTietDatPhong) AS soNguoiTrongGroup\r\n"
					+ "FROM dbo.LichSuDatPhong\r\n" + "WHERE IDChiTietDatPhong = ?\r\n"
					+ "AND TrangThai = 'Dang Thue Phong'\r\n" + "GROUP BY IDChiTietDatPhong");

			stmt.setString(1, iDChiTietDatPhong);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				soNguoiTrongGroup = rs.getInt("soNguoiTrongGroup");
			}
		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
		return soNguoiTrongGroup;
	}

	/**
	 * Lấy về danh sách phòng Trống đủ để nhét hết người trong 1 group vào
	 * 
	 * @param conn
	 * @param soNguoiTrongGroup
	 * @return
	 */
	public static List<Phong> getPhongTrongforGroup(Connection conn, int soNguoiTrongGroup) {
		PreparedStatement stmt = null;
		List<Phong> phongArr = new ArrayList<>();
		try {
			stmt = conn.prepareStatement(
					"SELECT IDPhong, SoNguoiToiDa, GiaPhong FROM dbo.Phong WHERE TrangThai LIKE 'Trong' AND SoNguoiToiDa >= ?");

			stmt.setInt(1, soNguoiTrongGroup);

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
	 * Trả về Mã Khách hàng và Ngày checkout, khi truyền vào ID đặt phòng.
	 * 
	 * @param conn
	 * @param iDCTDP
	 * @return
	 */
	public static List<LichSuDatPhong> getListMaKHinGroup(Connection conn, String iDCTDP) {
		PreparedStatement stmt = null;
		List<LichSuDatPhong> khachHangArr = new ArrayList<>();
		try {
			stmt = conn.prepareStatement(
					"SELECT IDKhachHang, NgayKetThuc, NgayBatDau FROM dbo.LichSuDatPhong WHERE TrangThai LIKE 'Dang Thue Phong' AND IDChiTietDatPhong = ?");

			stmt.setString(1, iDCTDP);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				LichSuDatPhong kh = new LichSuDatPhong();
				kh.setiDKhachHang(rs.getString("IDKhachHang"));
				kh.setNgayKetThuc(rs.getDate("NgayKetThuc").toLocalDate());
				kh.setNgayKetThuc(rs.getDate("NgayBatDau").toLocalDate());
				khachHangArr.add(kh);
			}

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
		return khachHangArr;
	}

}
