package model;

import java.util.Scanner;

public class Song extends Multimedia {
	Scanner sc = new Scanner(System.in);
	String singer;

	public Song() {
		super();
	}

	public Song(String singer, String nameMulti, double duration) {
		super(nameMulti, duration);
		this.singer = singer;
	}

	public Song createSong() {
		Song song = new Song();
		createMultimedia(sc);
		System.out.print("\nEnter singer: ");
		this.singer = sc.nextLine();
		return song;
	}

	@Override
	public String toString() {
		super.toString();
		return "Song [sc=" + sc + ", singer=" + singer + "]";
	}

}
