package view;

import java.util.Scanner;

public class InputMegazine {
	static Scanner sc = new Scanner(System.in);

	public static String inAuthor() {
		System.out.print("\nInput Author: ");
		return sc.nextLine();
	}

	public static int inVolumn() {
		do {
			try {
				System.out.print("\nInput volumn megazine: ");
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.print("\nOnly input number!!");
				continue;
			}
		} while (true);
	}

	public static int inEdition() {
		do {
			try {
				System.out.print("\nInput edition megazine: ");
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.print("\nOnly input number!!");
				continue;
			}
		} while (true);
	}

}
