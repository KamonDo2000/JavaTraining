package controller;

import java.sql.Connection;

import model.Book;
import model.InsertBookModel;
import view.InsertBookView;

public class InsertBookController {
	
	public static void inputBook(Connection conn) {
		Book book = new Book();
		
		book.setId(InsertBookView.inputID(conn));
		book.setTitle(InsertBookView.inputTitle());
		book.setAuthor(InsertBookView.inputAuthor());
		book.setDateEXP(InsertBookView.inputDate());
		book.setPrice(InsertBookView.inputPrice());
		book.setQuantity(InsertBookView.inputQuatity());
		book.setStatus(InsertBookView.inputStatus());
		
		InsertBookModel.insertBook(conn, book);
	}
	
}
