package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import controller.DBUtil;

public class UpdateBookModel {

	public static void updateBookByID(Connection conn, Book book) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("UPDATE dbo.ebookshop "
					+ "SET title = ?, author= ?, dateExp=?, price=?, qty=?, stt=?"
					+ " WHERE id = ?");

			stmt.setString(1, book.getTitle());
			stmt.setString(2, book.getAuthor());
			stmt.setDate(3, Date.valueOf(book.getDateEXP()));
			stmt.setFloat(4, book.getPrice());
			stmt.setInt(5, book.getQuantity());
			stmt.setInt(6, book.getStatus());
			stmt.setInt(7, book.getId());

			int cnt = stmt.executeUpdate();
			System.out.println("Update thành công " + cnt + " record!");

		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DBUtil.closeState(stmt);
		}
	}

	public static void updateBookByTitle(Connection conn, Book book) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement(
					"UPDATE dbo.ebookshop SET id = ? , author= ?, dateExp=?, price=?, qty=?, stt=? WHERE title LIKE ?");

			stmt.setInt(1, book.getId());
			stmt.setString(2, book.getAuthor());
			stmt.setDate(3, Date.valueOf(book.getDateEXP()));
			stmt.setFloat(4, book.getPrice());
			stmt.setInt(5, book.getQuantity());
			stmt.setInt(6, book.getStatus());

			stmt.setString(7, book.getTitle());

			int cnt = stmt.executeUpdate();
			System.out.println("Update thành công " + cnt + " record!");

		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DBUtil.closeState(stmt);
		}
	}

}
