package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.DBUtil;

public class CheckProductModel {
	public static boolean checkID(Connection conn, String id) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT id FROM dbo.product WHERE id LIKE ?");
			stmt.setString(1, id);
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

	public static boolean checkName(Connection conn, String name) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT name FROM dbo.product WHERE name LIKE ?");
			stmt.setString(1, name);
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

	public static int getSoLuongNhapVao(Connection conn, String name) {
		PreparedStatement stmt = null;
		int soLuongNhapVao = 0;
		try {
			stmt = conn.prepareStatement("SELECT quality FROM dbo.product WHERE name LIKE ?");
			stmt.setString(1, name);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				soLuongNhapVao = rs.getInt("quality");
			}
		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra " + e.getMessage());
		} finally {
			DBUtil.closeState(stmt);
		}
		return soLuongNhapVao;
	}

}
