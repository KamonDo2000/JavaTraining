package controller;

import java.sql.Connection;

import model.PlusPriceModel;
import view.InsertBookView;

public class PlusPriceController {
	public static void plusPrice(Connection conn) {
		String author = InsertBookView.inputAuthor();
		String title = InsertBookView.inputTitle();

		PlusPriceModel.updatePrice(conn, author, title);
	}
}
