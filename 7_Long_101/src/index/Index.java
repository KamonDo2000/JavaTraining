package index;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import control.ControlBook;
import control.ControlMegazine;
import control.OrderPublication;
import model.Book;
import model.Magazine;
import model.Publication;
import view.Menu;
import view.MenuSearch;
import view.ShowAllData;

public class Index {

	public static void main(String[] args) {
		System.out.println("====== LIBRARY MANAGEMENT SYSTEM ======");
		System.out.println("");

		List<Publication> listPub = new ArrayList<>();

		do {
			int check = Menu.mainMenu();

			switch (check) {
			case 0:
				return;
			case 1:
//				listPub.add(ControlBook.add());
				fakeData(listPub);
				continue;
			case 2:
				listPub.add(ControlMegazine.add());
				continue;
			case 3:
				ShowAllData.showByYearPublisher(listPub);
				continue;
			case 4:
				ControlBook.addAuthor(listPub);
				continue;
			case 5:
				OrderPublication.showTop10(listPub);
				continue;
			case 6:
				MenuSearch.search(listPub);
				continue;

			default:
				System.out.println("\nDo not choose!!");
				continue;
			}
		} while (true);
	}

	private static void fakeData(List<Publication> arr) {
		Set<String> listAut = new HashSet<>();
		listAut.add("Nguyen Van Phi");
		listAut.add("Nguyen Van Hoa");
		listAut.add("Nguyen Trong Tuyen");

		Set<String> listAut2 = new HashSet<>();
		listAut2.add("Nguye asdasd");
		listAut2.add("Nguyen dfvvf");
		listAut2.add("Nguyen dfvdvdv");

		Set<String> listAut3 = new HashSet<>();
		listAut3.add("Nguye as");
		listAut3.add("Nguyen asd");
		listAut3.add("Nguyen ac");

		Book book = new Book();
		book.setIsbn("678-3-16-1486");
		book.setAuthor(listAut2);
		book.setPublicationPlace("NXB Tuoi Tre");
		book.setPublisher("Hanh Dong");
		book.setPublivationYear(3);
		book.setPublicationDate(LocalDate.now());

		Book book1 = new Book();
		book1.setIsbn("678-5-66-1829");
		book1.setAuthor(listAut3);
		book1.setPublicationPlace("NXB Tuoi Moi");
		book1.setPublisher("Hanh Dong");
		book1.setPublivationYear(5);
		book1.setPublicationDate(LocalDate.now());

		Book book2 = new Book();
		book2.setIsbn("298-5-66-9839");
		book2.setAuthor(listAut);
		book2.setPublicationPlace("NXB Hong Lac");
		book2.setPublisher("Hanh Dong");
		book2.setPublivationYear(4);
		book2.setPublicationDate(LocalDate.now());

		Magazine magazine = new Magazine();
		magazine.setAuthor("do Huy");
		magazine.setVolumn(5);
		magazine.setEdition(7);
		magazine.setPublisher("Ho chi Minh");
		magazine.setPublivationYear(2000);
		magazine.setPublicationDate(LocalDate.now());

		Magazine magazine1 = new Magazine();
		magazine1.setAuthor("Huy Do the");
		magazine1.setVolumn(8);
		magazine1.setEdition(3);
		magazine1.setPublisher("Hai Phong");
		magazine1.setPublivationYear(2024);
		magazine1.setPublicationDate(LocalDate.now());

		Magazine magazine2 = new Magazine();
		magazine2.setAuthor("To Hieu");
		magazine2.setVolumn(6);
		magazine2.setEdition(9);
		magazine2.setPublisher("Ha Noi");
		magazine2.setPublivationYear(2000);
		magazine2.setPublicationDate(LocalDate.now());

		arr.add(book);
		arr.add(magazine);
		arr.add(book1);
		arr.add(magazine2);
		arr.add(magazine1);
		arr.add(book2);

	}

}
