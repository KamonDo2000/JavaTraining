package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controller.DBUtil;

public class CheckBookModel {

	public static boolean checkID(Connection conn, int id) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT id FROM dbo.ebookshop WHERE id LIKE ?");
			stmt.setInt(1, id);
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

	public static boolean checkTitle(Connection conn, String title) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT title FROM dbo.ebookshop WHERE title LIKE ?");
			stmt.setString(1, title);
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
	
	public static boolean checkAuthor(Connection conn, String author) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("SELECT author FROM dbo.ebookshop WHERE author LIKE ?");
			stmt.setString(1, author);
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
