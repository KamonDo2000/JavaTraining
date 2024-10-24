package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Multimedia;
import model.MultimediaManagement;
import model.Song;
import model.Video;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		List<Multimedia> arrPer = new ArrayList<>();
		MultimediaManagement mulmg = new MultimediaManagement(arrPer);

		do {
			int choise = menu();

			switch (choise) {
			case 1:
				Video video = new Video();

				System.out.println("----Enter video information------");
				video.createVideo();
				mulmg.addMultiMedia(video);

				continue;
			case 2:
				Song song = new Song();

				System.out.println("----Enter song information------");
				song.createSong();
				mulmg.addMultiMedia(song);
				continue;
			case 3:
				System.out.println("----LIST OF MULTIMEDIA------");
				mulmg.displayMultiMedia();
				continue;
			case 4:
				return;
			default:
				continue;
			}

		} while (true);

	}

	private static int menu() {
		do {
			System.out.println("\n");
			System.out.println("choose function: ");
			System.out.println("1. Add a new video");
			System.out.println("2. Add a new Song");
			System.out.println("3. Show all multimedia");
			System.out.println("4. Exits");
			System.out.print("You choise: ");

			try {
				int choise = Integer.parseInt(sc.nextLine());
				return choise;
			} catch (Exception e) {
				System.out.println("Do not choise.");
				continue;
			}
		} while (true);

	}

}
