package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import controller.DBUtil;

import java.sql.Date;

public class InsertBookModel {

	public static void insertBook(Connection conn, Book book) {
		PreparedStatement stmt = null;
		try {
			stmt = conn.prepareStatement("insert into dbo.ebookshop VALUES (?, ?, ?, ?, ?, ?, ?)");

			stmt.setInt(1, book.getId());
			stmt.setString(2, book.getTitle());
			stmt.setString(3, book.getAuthor());
			stmt.setDate(4, Date.valueOf(book.getDateEXP()));
			stmt.setFloat(5, book.getPrice());
			stmt.setInt(6, book.getQuantity());
			stmt.setInt(7, book.getStatus());

			int cnt = stmt.executeUpdate();
			System.out.println("Đã Thêm " + cnt + " record!");

		} catch (Exception e) {
			System.out.println("Đã có lỗi xảy ra!!!" + e);
		} finally {
			DBUtil.closeState(stmt);
		}
	}
}
