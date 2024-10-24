package view;

import java.time.LocalDate;
import java.util.Scanner;

public class InputData {
	static Scanner sc = new Scanner(System.in);
	private static final String RG_DATE = "^(20\\d\\d|19\\d\\d)-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01])$";

	public static String inPublisher() {
		System.out.print("\nInput Publisher: ");
		return sc.nextLine();
	}

	public static int inPublivationYear() {
		do {
			try {
				System.out.print("\nInput Publivation Year: ");
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.err.println("\nonly input number");
			}
		} while (true);
	}

	public static LocalDate inPublicationDate() {
		do {
			System.out.print("\nInput Publication Date: ");
			String pubDate = sc.nextLine();
			if (pubDate.matches(RG_DATE)) {
				return LocalDate.parse(pubDate);
			}
			System.err.println("\nonly input Date EX: YYYY-MM-DD");
		} while (true);
	}

}
