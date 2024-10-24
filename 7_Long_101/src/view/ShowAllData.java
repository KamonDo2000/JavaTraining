package view;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Book;
import model.Magazine;
import model.Publication;

public class ShowAllData {

	private static void showAll(Set<Publication> arrPub) {

		for (Publication pub : arrPub) {
			if (pub instanceof Book) {
				((Book) pub).display();

			}
			if (pub instanceof Magazine) {
				((Magazine) pub).display();
			}
		}

	}

	public static void showByYearPublisher(List<Publication> arrPub) {
		Set<Publication> arrPub2 = new HashSet<>();

		for (Publication pub : arrPub) {
			int dateLoop1 = pub.getPublivationYear();
			String publish = pub.getPublisher();
			for (Publication pub2 : arrPub) {
				if (dateLoop1 == pub2.getPublivationYear() && (publish.equals(pub2.getPublisher()))) {
					arrPub2.add(pub);
					arrPub2.add(pub2);
				}
			}
		}
		showAll(arrPub2);
	}

}
