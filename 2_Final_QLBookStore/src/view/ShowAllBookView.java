package view;

import java.util.List;

import model.Book;

public class ShowAllBookView {

	public static void showAllBook(List<Book> book) {
		for (Book obj : book) {
			System.out.print("ID: " + obj.getId());
			System.out.print(" || Title: " + obj.getTitle());
			System.out.println(" || Author: " + obj.getAuthor());

			System.out.print("Date: " + obj.getDateEXP().getDayOfMonth() + " - " + obj.getDateEXP().getMonth() + " - "
					+ obj.getDateEXP().getYear());

			System.out.printf(" || Price: %.1f",obj.getPrice());
			System.out.print(" || Quantity: " + obj.getQuantity());

			if (obj.getStatus() == 1) {
				System.out.println(" || Còn Hàng");
			} else {
				System.out.println(" || Hết Hàng");
			}

			System.out.println("\n====================");
		}
	}

}
