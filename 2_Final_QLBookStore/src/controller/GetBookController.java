package controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.CheckBookModel;
import model.GetAllBookModel;
import view.InsertBookView;
import view.ShowAllBookView;

public class GetBookController {

	public static void getAllBook(Connection conn) {
		List<Book> book = new ArrayList<>();

		book = GetAllBookModel.getAllBook(conn);

		ShowAllBookView.showAllBook(book);
	}

	public static void getBookByTitle(Connection conn) {
		List<Book> book = new ArrayList<>();

		String title = InsertBookView.inputTitle();
		System.out.println("\n====================");

		if (!CheckBookModel.checkTitle(conn, title)) {
			System.out.println("Khong co ten nay trong store!!");
			return;
		}

		book = GetAllBookModel.getBookByTitle(conn, title);
		ShowAllBookView.showAllBook(book);
	}

	public static void getBookByAuthor(Connection conn) {
		List<Book> book = new ArrayList<>();

		String author = InsertBookView.inputAuthor();
		System.out.println("\n====================");

		if (!CheckBookModel.checkAuthor(conn, author)) {
			System.out.println("Khong co ten nay trong store!!");
			return;
		}

		book = GetAllBookModel.getBookByAuthor(conn, author);
		ShowAllBookView.showAllBook(book);
	}

	public static void getBookByPrice(Connection conn) {
		List<Book> book = new ArrayList<>();

		double price = InsertBookView.inputPrice();
		System.out.println("\n====================");

		book = GetAllBookModel.getBookByPrice(conn, price);
		if (book != null) {
			ShowAllBookView.showAllBook(book);
		} else {
			System.out.println("Khong co book nao!!!");
		}

	}
	
	public static void getBookByPriceASC(Connection conn) {
		List<Book> book = new ArrayList<>();

		book = GetAllBookModel.getBookByPriceASC(conn);

		ShowAllBookView.showAllBook(book);
	}
	
	public static void getBookByQtyDESC(Connection conn) {
		List<Book> book = new ArrayList<>();

		book = GetAllBookModel.getBookByQtyDESC(conn);

		ShowAllBookView.showAllBook(book);
	}

}
