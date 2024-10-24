package controller;

import java.util.List;
import java.util.Scanner;

import model.Person;
import service.FileService;
import service.SQLService;

public class Main {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("----Manager Candidate Application------");
		do {
			int choose = menu();
			switch (choose) {
			case 1:
				System.out.println("choose 1");
				continue;
			case 2:
				System.out.println("choose 2");
				continue;
			case 3:
				System.out.println("choose 3");
				continue;
			case 4:
				System.out.println("choose 4");
				continue;
			case 5:
				List<Person> persons = FileService.readFile();
				
				SQLService.insertData(persons);
				continue;

			case 0:
				System.err.println("\n========================== Exits Program ==========================");
				return;
			default:
				continue;
			}
		} while (true);
	}

	private static int menu() {
		System.out.println("==================================");
		System.out.println("Choose function: ");
		System.out.println("0. Exits");
		System.out.println("1.");
		System.out.println("2.");
		System.out.println("3.");
		System.out.println("4.");
		System.out.println("5.");
		int pick = -1;

		do {
			try {
				System.out.print("You choise: ");
				pick = Integer.parseInt(sc.nextLine());
				if (pick < 0 || pick > 5) {
					System.err.println("no choose exists!");
					continue;
				}
				break;
			} catch (Exception e) {
				System.err.println("Only input number!");
				continue;
			}
		} while (true);

		return pick;
	}

}
