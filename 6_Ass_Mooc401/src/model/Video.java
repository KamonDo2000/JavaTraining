package model;

import java.util.Scanner;

public class Video extends Multimedia {
	Scanner sc = new Scanner(System.in);

	public Video() {
		super();
	}

	public Video(String name, double duration) {
		super(name, duration);
	}

	public Video createVideo() {
		Video video = new Video();
		createMultimedia(sc);
		return video;
	}

	@Override
	public String toString() {
		return super.toString();
	}

}
