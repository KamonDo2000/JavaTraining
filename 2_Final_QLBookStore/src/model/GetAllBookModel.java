package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import controller.DBUtil;

public class GetAllBookModel {

	public static List<Book> getAllBook(Connection conn) {
		PreparedStatement stmt = null;
		ArrayList<Book> arrBook = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.ebookshop");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Book book = new Book();

				book.setId(rs.getInt("ID"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));

				String date = rs.getDate("dateExp").toString();
				book.setDateEXP(LocalDate.parse(date));

				book.setPrice(rs.getFloat("price"));
				book.setQuantity(rs.getInt("qty"));
				book.setStatus(rs.getInt("stt"));

				arrBook.add(book);
			}
			return arrBook;

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
			return arrBook;
		} finally {
			DBUtil.closeState(stmt);
		}
	}

	public static List<Book> getBookByTitle(Connection conn, String title) {
		PreparedStatement stmt = null;
		ArrayList<Book> arrBook = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.ebookshop where title LiKE ?");
			stmt.setString(1, title);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Book book = new Book();

				book.setId(rs.getInt("ID"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));

				String date = rs.getDate("dateExp").toString();
				book.setDateEXP(LocalDate.parse(date));

				book.setPrice(rs.getFloat("price"));
				book.setQuantity(rs.getInt("qty"));
				book.setStatus(rs.getInt("stt"));

				arrBook.add(book);
			}
			return arrBook;

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
			return arrBook;
		} finally {
			DBUtil.closeState(stmt);
		}
	}

	public static List<Book> getBookByAuthor(Connection conn, String author) {
		PreparedStatement stmt = null;
		ArrayList<Book> arrBook = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.ebookshop where author LiKE ?");
			stmt.setString(1, author);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Book book = new Book();

				book.setId(rs.getInt("ID"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));

				String date = rs.getDate("dateExp").toString();
				book.setDateEXP(LocalDate.parse(date));

				book.setPrice(rs.getFloat("price"));
				book.setQuantity(rs.getInt("qty"));
				book.setStatus(rs.getInt("stt"));

				arrBook.add(book);
			}
			return arrBook;

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
			return arrBook;
		} finally {
			DBUtil.closeState(stmt);
		}
	}
	
	public static List<Book> getBookByPrice(Connection conn, double price) {
		PreparedStatement stmt = null;
		ArrayList<Book> arrBook = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.ebookshop where price > ?");
			stmt.setDouble(1, price);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Book book = new Book();

				book.setId(rs.getInt("ID"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));

				String date = rs.getDate("dateExp").toString();
				book.setDateEXP(LocalDate.parse(date));

				book.setPrice(rs.getFloat("price"));
				book.setQuantity(rs.getInt("qty"));
				book.setStatus(rs.getInt("stt"));

				arrBook.add(book);
			}
			return arrBook;

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
			return arrBook;
		} finally {
			DBUtil.closeState(stmt);
		}
	}

	public static List<Book> getBookByPriceASC(Connection conn) {
		PreparedStatement stmt = null;
		ArrayList<Book> arrBook = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.ebookshop ORDER BY price ASC");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Book book = new Book();

				book.setId(rs.getInt("ID"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));

				String date = rs.getDate("dateExp").toString();
				book.setDateEXP(LocalDate.parse(date));

				book.setPrice(rs.getFloat("price"));
				book.setQuantity(rs.getInt("qty"));
				book.setStatus(rs.getInt("stt"));

				arrBook.add(book);
			}
			return arrBook;

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
			return arrBook;
		} finally {
			DBUtil.closeState(stmt);
		}
	}
	
	public static List<Book> getBookByQtyDESC(Connection conn) {
		PreparedStatement stmt = null;
		ArrayList<Book> arrBook = new ArrayList<>();
		try {
			stmt = conn.prepareStatement("SELECT * FROM dbo.ebookshop ORDER BY qty DESC");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Book book = new Book();

				book.setId(rs.getInt("ID"));
				book.setTitle(rs.getString("title"));
				book.setAuthor(rs.getString("author"));

				String date = rs.getDate("dateExp").toString();
				book.setDateEXP(LocalDate.parse(date));

				book.setPrice(rs.getFloat("price"));
				book.setQuantity(rs.getInt("qty"));
				book.setStatus(rs.getInt("stt"));

				arrBook.add(book);
			}
			return arrBook;

		} catch (Exception e) {
			System.out.println("Có lỗi xảy ra!!" + e);
			return arrBook;
		} finally {
			DBUtil.closeState(stmt);
		}
	}
	
}
