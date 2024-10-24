package view;

import java.util.Scanner;

public class MainMenu {
	private static Scanner sc = new Scanner(System.in);

	public static int menu() {
		System.out.println("==================================");
		System.out.println("Choose function: ");
		System.out.println("0. Exits");
		System.out.println("1. Input Candidate");
		System.out.println("2. Show");
		System.out.println("3. Show count candidate");
		System.out.println("4. show all name candidate");
		System.out.println("5. Update by Concur");
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
