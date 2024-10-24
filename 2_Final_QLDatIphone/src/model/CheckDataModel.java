package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.DBUtil;

public class CheckDataModel {

	public static boolean checkEmpty(Connection conn) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.orderIP");

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
	
	public static boolean checkMaOder(Connection conn, String maOder) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT maOder FROM dbo.orderIP WHERE maOder LIKE ?");
			stmt.setString(1, maOder);
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
	
}
