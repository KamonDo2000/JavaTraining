package view;

import java.util.Scanner;

public class Menu {
	static Scanner sc = new Scanner(System.in);

	public static int mainMenu() {
		System.out.println();
		System.out.println("0.	Exits");
		System.out.println("1.	Add a book");
		System.out.println("2.	Add a magazine");
		System.out.println("3.	Display books and magazines");
		System.out.println("4.	Add author to book");
		System.out.println("5.	Display top 10 of magazines by volume");
		System.out.println("6.	Search book by (isbn, author, publisher)");

		do {
			System.out.print("\nPlease choose function you'd like to do: ");
			int check;
			try {
				check = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.err.println("\nOnly input number!!");
				continue;
			}
			if (check < 0 || check > 6) {
				System.err.println("\nDo not choose!!");
				continue;
			}
			return check;
		} while (true);
	}

}
