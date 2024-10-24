package control;

import java.util.List;

import model.Book;
import model.Publication;
import view.InputBook;
import view.InputData;
import view.InputMegazine;

public class ControlBook {
	public static Book add() {
		Book book = new Book();
		book.setIsbn(InputBook.isbn());
		book.setAuthor(InputBook.inAuthorList());
		book.setPublicationPlace(InputBook.inPublicationPlace());

		book.setPublisher(InputData.inPublisher());
		book.setPublivationYear(InputData.inPublivationYear());
		book.setPublicationDate(InputData.inPublicationDate());

		return book;
	}

	public static void addAuthor(List<Publication> arrPub) {
		String author = InputMegazine.inAuthor();
		String isbn = InputBook.isbn();

		for (Publication pub : arrPub) {
			if (((Book) pub).getIsbn().equalsIgnoreCase(isbn)) {

				for (String aut : ((Book) pub).getAuthor()) {
					if (aut.equalsIgnoreCase(author)) {
						System.out.println("Author existed");
						return;
					}
				}

				((Book) pub).getAuthor().add(author);
				System.out.println("Add successfully");
				return;
			}
		}

	}
}
