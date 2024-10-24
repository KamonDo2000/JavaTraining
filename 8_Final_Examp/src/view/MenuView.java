package view;

import java.util.Scanner;

public class MenuView {
	static Scanner sc = new Scanner(System.in);

	public static int menu() {
		System.out.println("Choose function: ");
		System.out.println("0. Exits");
		System.out.println("1. Insert Data to file");
		System.out.println("2. show infor");
		System.out.println("3. show and compare");
		System.out.println("4. ");
		System.out.println("5. ");

		int pick = -1;

		do {
			System.out.print("You choise: ");
			try {
				pick = Integer.parseInt(sc.nextLine());
				if (pick < 0 || pick > 5) {
					System.err.println("Do not choise.\n");
					continue;
				}
				break;
			} catch (Exception e) {
				System.err.println("Input only number!\n");
				continue;
			}
		} while (true);
		return pick;
	}
}
