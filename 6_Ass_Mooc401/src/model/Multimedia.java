package model;

import java.util.Scanner;

public abstract class Multimedia {

	String nameMulti;
	double duration;

	protected Multimedia() {
	}

	protected Multimedia(String name, double duration) {
		this.nameMulti = name;
		this.duration = duration;
	}

	public void createMultimedia(Scanner sc) {
		System.out.print("\nEnter name: ");
		this.nameMulti = sc.nextLine();
		System.out.print("\nEnter duration: ");
		try {
			this.duration = Double.parseDouble(sc.nextLine());
		} catch (Exception e) {
			this.duration = 0;
			System.out.println("Nhap vao sai dinh dang!!");
		}

	}

	public String getName() {
		return nameMulti;
	}

	public void setName(String name) {
		this.nameMulti = name;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "nameMulti=" + nameMulti + ", duration=" + duration;
	}
}
