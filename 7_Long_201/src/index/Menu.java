package index;

import java.util.Scanner;

public class Menu {
	private static Scanner sc = new Scanner(System.in);

	public static int menu() {
		System.out.println("==================================");
		System.out.println("Choose function: ");
		System.out.println("0.Exits");
		System.out.println("1.create a new airport");
		System.out.println("2.add to an airport one or more fixed wing airplane");
		System.out.println("3.add to an airport one or more helicopter(s)");
		System.out.println("4.add fixed wing to airport");
		System.out.println("5.add helicopter to airport");
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
