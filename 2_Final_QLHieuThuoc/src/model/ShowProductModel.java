package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.DBUtil;

public class ShowProductModel {

	public static List<SanPham> showProduct(Connection conn) {
		PreparedStatement stmt = null;
		ArrayList<SanPham> arrSanPham = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.product");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				SanPham sanpham = new SanPham();

				sanpham.setId(rs.getString("ID"));
				sanpham.setName(rs.getString("Name"));

				String date = rs.getDate("dateExp").toString();
				sanpham.setHanSuDung(LocalDate.parse(date));

				sanpham.setSoLuongNhapVao(rs.getInt("quality"));
				sanpham.setSoLuongDaBan(rs.getInt("sell"));

				arrSanPham.add(sanpham);
			}
			return arrSanPham;

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
			return arrSanPham;
		} finally {
			DBUtil.closeState(stmt);
		}
	}

	public static List<SanPham> showProductByQtyDESC(Connection conn) {
		PreparedStatement stmt = null;
		ArrayList<SanPham> arrSanPham = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.product ORDER BY sell DESC");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				SanPham sanpham = new SanPham();

				sanpham.setId(rs.getString("ID"));
				sanpham.setName(rs.getString("Name"));

				String date = rs.getDate("dateExp").toString();
				sanpham.setHanSuDung(LocalDate.parse(date));

				sanpham.setSoLuongNhapVao(rs.getInt("quality"));
				sanpham.setSoLuongDaBan(rs.getInt("sell"));

				arrSanPham.add(sanpham);
			}
			return arrSanPham;

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
			return arrSanPham;
		} finally {
			DBUtil.closeState(stmt);
		}
	}

}
