package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.DBUtil;

public class ASCsoTietKiem {

	public static ArrayList<BankBook> showAllData(Connection conn) {
		PreparedStatement stmt = null;
		ArrayList<BankBook> arrSanPham = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.BankBook");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				BankBook bankBook = new BankBook();

				bankBook.setMaSoTK(rs.getString("MaSoTK"));
				bankBook.setHoTen(rs.getString("HoTen"));
				bankBook.setCmnd(rs.getString("CMND"));
				bankBook.setDiaChi(rs.getString("DiaChi"));
				bankBook.setSoDienThoai(rs.getString("SoDienThoai"));

				String date = rs.getDate("NgayGuiTK").toString();
				bankBook.setNgayGuiTK(LocalDate.parse(date));

				bankBook.setSoTien(rs.getFloat("SoTien"));
				bankBook.setKyHan(rs.getString("KyHan"));
				bankBook.setPTTaiTuc(rs.getInt("PTTaiTuc"));

				arrSanPham.add(bankBook);
			}
			return arrSanPham;

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
			return arrSanPham;
		} finally {
			DBUtil.closeState(stmt);
		}
	}

	public static ArrayList<BankBook> showProductByQtyDESC(Connection conn) {
		PreparedStatement stmt = null;
		ArrayList<BankBook> arrSanPham = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.BankBook ORDER BY SoTien ASC, NgayGuiTK DESC");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				BankBook bankBook = new BankBook();

				bankBook.setMaSoTK(rs.getString("MaSoTK"));
				bankBook.setHoTen(rs.getString("HoTen"));
				bankBook.setCmnd(rs.getString("CMND"));
				bankBook.setDiaChi(rs.getString("DiaChi"));
				bankBook.setSoDienThoai(rs.getString("SoDienThoai"));

				String date = rs.getDate("NgayGuiTK").toString();
				bankBook.setNgayGuiTK(LocalDate.parse(date));

				bankBook.setSoTien(rs.getFloat("SoTien"));
				bankBook.setKyHan(rs.getString("KyHan"));
				bankBook.setPTTaiTuc(rs.getInt("PTTaiTuc"));

				arrSanPham.add(bankBook);
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
