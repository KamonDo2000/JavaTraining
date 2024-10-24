package view;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class InputBook {
	static Scanner sc = new Scanner(System.in);

	private static final String RG_ISBN = "^[0-9\\-]{10,17}$";

	public static String isbn() {
		do {
			System.out.print("\nInput isbn: ");
			String isbn = sc.nextLine();
			if (isbn.matches(RG_ISBN)) {
				return isbn;
			}
			System.err.println("\nonly input 10-17 digit Ex: 678-3-16-1486");
		} while (true);
	}

	public static String inPublicationPlace() {
		System.out.print("\nInput Publication Place: ");
		return sc.nextLine();
	}

	public static Set<String> inAuthorList() {
		Set<String> listAut = new HashSet<>();
		do {
			System.out.print("\nInput Author: ");
			String author = sc.nextLine();
			listAut.add(author);
			do {
				System.out.print("\nDo you want continue? (Y/N):  ");
				String check = sc.nextLine();
				if (check.equalsIgnoreCase("y")) {
					break;
				} else if (check.equalsIgnoreCase("n")) {
					return listAut;
				} else {
					System.out.print("\nNot choosen!! ");
					continue;
				}
			} while (true);
		} while (true);

	}

}
