package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.DBUtil;

public class CheckSTKModel {
	
	public static boolean checkSTK(Connection conn, String stk) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT MaSoTK FROM dbo.BankBook WHERE MaSoTK LIKE ?");
			stmt.setString(1, stk);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra " + e.getMessage());
		} finally {
			DBUtil.closeState(stmt);
		}
		return false;
	}
	
	public static boolean checkEmpty(Connection conn) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.BankBook");

			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				return false;
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra " + e.getMessage());
		} finally {
			DBUtil.closeState(stmt);
		}
		return true;
	}
	
}
