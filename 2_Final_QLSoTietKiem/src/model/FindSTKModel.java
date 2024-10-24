package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

import controller.DBUtil;

public class FindSTKModel {

	public static ArrayList<BankBook> findByDate(Connection conn, LocalDate ngayStart, LocalDate ngayEnd) {
		PreparedStatement stmt = null;
		ArrayList<BankBook> arrBankBook = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.BankBook WHERE NgayGuiTK > ? AND NgayGuiTK < ?");

			stmt.setDate(1, Date.valueOf(ngayStart));
			stmt.setDate(2, Date.valueOf(ngayEnd));

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

				arrBankBook.add(bankBook);
			}
			return arrBankBook;

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
			return arrBankBook;
		} finally {
			DBUtil.closeState(stmt);
		}
	}

	public static ArrayList<BankBook> findByKH(Connection conn, String kyHan) {
		PreparedStatement stmt = null;
		ArrayList<BankBook> arrBankBook = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.BankBook WHERE KyHan LIKE ?");

			stmt.setString(1, kyHan);

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

				arrBankBook.add(bankBook);
			}
			return arrBankBook;

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
			return arrBankBook;
		} finally {
			DBUtil.closeState(stmt);
		}
	}

}
