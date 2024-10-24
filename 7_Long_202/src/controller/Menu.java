package controller;

import java.util.Scanner;

public class Menu {

	static Scanner sc = new Scanner(System.in);

	public static int menuFunction() {
		System.out.println("======== EMPLOYEE MANAGEMENT SYSTEM ========");
		System.out.println("Choose function: ");
		System.out.println("1. Add a new employee");
		System.out.println("2. Display employee");
		System.out.println("3. Classify employee");
		System.out.println("4. Search employee");
		System.out.println("5. Report");
		System.out.println("6. Exit");
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
