package control;

import java.util.ArrayList;
import java.util.List;

import model.Magazine;
import model.Publication;

public class OrderPublication {

	public static void showTop10(List<Publication> arrPub) {
		List<Magazine> magList = new ArrayList<>();

		for (Publication pub : arrPub) {
			if (pub instanceof Magazine) {
				magList.add(((Magazine) pub));
			}
		}

		magList.sort((m1, m2) -> Integer.compare(m2.getVolumn(), m1.getVolumn()));


		int check = 0;

		for (int i = 0; i < magList.size(); i++) {
			check++;
			magList.get(i).display();
			if (check >= 10) {
				break;
			}
		}

	}

}
