package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.LichSuDatPhong;
import utils.DButil;

public class ThongKeModel {

	/**
	 * Truyền vào tháng và năm chỉ định Trả về ID phong, NgayBD, NgayKT, GiaPhong
	 * của bất kỳ phòng nào có NgayBD hoặc NgayKT thuê có tháng và năm khớp với chỉ
	 * định
	 * 
	 * @param conn
	 * @param mounth
	 * @param year
	 * @return
	 */
	public static List<LichSuDatPhong> getThongKeLSDP(Connection conn, int mounth, int year) {
		PreparedStatement stmt = null;
		List<LichSuDatPhong> lsdpArray = new ArrayList<>();
		try {
			stmt = conn
					.prepareStatement("SELECT DISTINCT LSDP.IDPhong, LSDP.NgayBatDau, LSDP.NgayKetThuc, P.GiaPhong\r\n"
							+ "FROM dbo.LichSuDatPhong AS LSDP, dbo.Phong AS P\r\n"
							+ "WHERE LSDP.IDPhong = P.IDPhong \r\n"
							+ "AND (MONTH(NgayBatDau) = ? AND YEAR(NgayBatDau) = ? \r\n"
							+ "OR MONTH(NgayKetThuc) = ? AND YEAR(NgayKetThuc) = ?) AND LSDP.TrangThai LIKE 'Tra Phong'");
			stmt.setInt(1, mounth);
			stmt.setInt(2, year);
			stmt.setInt(3, mounth);
			stmt.setInt(4, year);

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				LichSuDatPhong lsdp = new LichSuDatPhong();

				lsdp.setiDPhong(rs.getString("IDPhong"));
				lsdp.setNgayBatDau(rs.getDate("NgayBatDau").toLocalDate());
				lsdp.setNgayKetThuc(rs.getDate("NgayKetThuc").toLocalDate());
				lsdp.setGiaPhong(rs.getLong("GiaPhong"));

				lsdpArray.add(lsdp);
			}

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
		} finally {
			DButil.closeState(stmt);
		}
		return lsdpArray;
	}

}
