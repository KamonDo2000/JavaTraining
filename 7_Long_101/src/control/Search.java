package control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Book;
import model.Magazine;
import model.Publication;
import view.InputBook;
import view.InputData;
import view.InputMegazine;

public class Search {

	public static List<Publication> searchByIsbn(List<Publication> arrPub) {
		String isbn = InputBook.isbn();
		List<Publication> pubListBook = new ArrayList<>();

		for (Publication pub : arrPub) {
			if (pub instanceof Book && ((Book) pub).getIsbn().equalsIgnoreCase(isbn)) {
				pubListBook.add(pub);
			}
		}
		return pubListBook;
	}

	public static List<Publication> searchByAuthor(List<Publication> arrPub) {
		String inAuthorName = InputMegazine.inAuthor();

		Map<Publication, Set<String>> autPubMap = new HashMap<>();

		for (Publication pub : arrPub) {
			if (pub instanceof Book) {
				autPubMap.put(pub, ((Book) pub).getAuthor());
			}
			if (pub instanceof Magazine) {
				Set<String> authorList = new HashSet<>();
				authorList.add(((Magazine) pub).getAuthor());
				autPubMap.put(pub, authorList);
			}
		}

		List<Publication> listPub = new ArrayList<>();

		for (Publication key : autPubMap.keySet()) {
			for (String authorName : autPubMap.get(key)) {
				if (authorName.equalsIgnoreCase(inAuthorName)) {
					listPub.add(key);
				}
			}
		}

		return listPub;

	}

	public static List<Publication> searchByPublisher(List<Publication> arrPub) {
		String publish = InputData.inPublisher();
		List<Publication> pubListPub = new ArrayList<>();

		for (Publication pub : arrPub) {
			if (pub.getPublisher().equalsIgnoreCase(publish)) {
				pubListPub.add(pub);
			}
		}
		return pubListPub;
	}

}
