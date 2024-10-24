package view;

import java.util.Scanner;

public class Menu {

	private static Scanner sc = new Scanner(System.in);

	public static boolean checkContinue() {
		System.out.print("Do you want continue (Y/N)? ");
		String check = "";
		do {
			check = sc.nextLine();
			if (check.equalsIgnoreCase("y")) {
				return true;
			} else if (check.equalsIgnoreCase("n")) {
				return false;
			} else {
				continue;
			}
		} while (true);
	}
	
	public static int inputMenu() {
		System.out.println("==================================");
		System.out.println("1.input Experience");
		System.out.println("2.input Fresher");
		System.out.println("3.input Intern");

		int pick = -1;
		do {
			try {
				System.out.print("You choise: ");
				pick = Integer.parseInt(sc.nextLine());
				if (pick < 1 || pick > 3) {
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
