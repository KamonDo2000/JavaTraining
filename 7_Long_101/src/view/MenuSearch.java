package view;

import java.util.List;
import java.util.Scanner;

import control.Search;
import model.Book;
import model.Publication;

public class MenuSearch {

	static Scanner sc = new Scanner(System.in);

	public static int menuSearch() {
		int choosen = 0;
		do {
			System.out.println("Input choosen: ");
			System.out.println("1. search book by isbn");
			System.out.println("2. search book by author");
			System.out.println("3. search book by publisher");

			System.out.println("Do you want? ");

			try {
				choosen = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Chi duoc Nhap so!!");
				continue;
			}

			if (choosen > 3 || choosen < 1) {
				System.out.println("Chi co lua chon 1,2,3!!");
				continue;
			}

			return choosen;
		} while (true);

	}

	public static void search(List<Publication> arrPub) {
		switch (menuSearch()) {
		case 1:
			showSearch(Search.searchByIsbn(arrPub));
			break;
		case 2:
			showSearch(Search.searchByAuthor(arrPub));
			break;
		case 3:
			showSearch(Search.searchByPublisher(arrPub));
			break;

		default:
			break;
		}
	}

	private static void showSearch(List<Publication> arrPub) {

		arrPub.sort((obj1, obj2) -> {
			if (((Book) obj1).getIsbn() != null && ((Book) obj2).getIsbn() != null
					&& ((Book) obj1).getIsbn().compareTo(((Book) obj2).getIsbn()) != 0) {
				return ((Book) obj1).getIsbn().compareTo(((Book) obj2).getIsbn());
			} else {
				((Book) obj1).getPublicationDate().compareTo(((Book) obj2).getPublicationDate());
			}
			return 0;
		});

		for (Publication pub : arrPub) {
			pub.display();
		}

	}

}
