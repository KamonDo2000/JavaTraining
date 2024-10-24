package model;

import java.util.List;

public class MultimediaManagement {

	List<Multimedia> listOfMultimedia;

	public MultimediaManagement(List<Multimedia> listOfMultimedia) {
		this.listOfMultimedia = listOfMultimedia;
	}

	public void addMultiMedia(Multimedia multimedia) {
		this.listOfMultimedia.add(multimedia);
	}

	public void displayMultiMedia() {
		for (Multimedia mul : listOfMultimedia) {
			if (mul instanceof Song) {
				System.out.println("\n");
				System.out.print("Song: \t");
				System.out.print(((Song) mul).singer + " \t");
				System.out.print(mul.nameMulti + " \t");
				System.out.print(mul.duration + " \t");

			}
			if (mul instanceof Video) {
				System.out.println("\n");
				System.out.print("Video: \t");
				System.out.print(mul.duration + " \t");
				System.out.print(mul.nameMulti + " \t");

			}
		}
	}

}
