package controller;

import java.sql.Connection;

import model.Book;
import model.UpdateBookModel;
import view.InsertBookView;
import view.UpdateBookView;

public class UpdateBookController {
	public static void updateBookByID(Connection conn) {
		int id = UpdateBookView.updateBookByID(conn);
		Book book = new Book();

		if (id == 0) {
			return;
		} else {
			book.setId(id);
			book.setTitle(InsertBookView.inputTitle());
			book.setAuthor(InsertBookView.inputAuthor());
			book.setDateEXP(InsertBookView.inputDate());
			book.setPrice(InsertBookView.inputPrice());
			book.setQuantity(InsertBookView.inputQuatity());
			book.setStatus(InsertBookView.inputStatus());

			UpdateBookModel.updateBookByID(conn, book);
		}
	}

	public static void updateBookByTitle(Connection conn) {
		String title = UpdateBookView.updateBookByTitle(conn);
		Book book = new Book();

		if (title == null) {
			return;
		} else {
			book.setId(InsertBookView.inputID(conn));
			book.setTitle(title);
			book.setAuthor(InsertBookView.inputAuthor());
			book.setDateEXP(InsertBookView.inputDate());
			book.setPrice(InsertBookView.inputPrice());
			book.setQuantity(InsertBookView.inputQuatity());
			book.setStatus(InsertBookView.inputStatus());

			UpdateBookModel.updateBookByTitle(conn, book);
		}
	}
}
