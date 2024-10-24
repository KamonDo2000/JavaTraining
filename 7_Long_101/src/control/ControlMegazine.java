package control;

import model.Magazine;
import view.InputData;
import view.InputMegazine;

public class ControlMegazine {

	public static Magazine add() {
		Magazine magazine = new Magazine();

		magazine.setAuthor(InputMegazine.inAuthor());
		magazine.setVolumn(InputMegazine.inVolumn());
		magazine.setEdition(InputMegazine.inEdition());

		magazine.setPublisher(InputData.inPublisher());
		magazine.setPublivationYear(InputData.inPublivationYear());
		magazine.setPublicationDate(InputData.inPublicationDate());

		return magazine;
	}

}
