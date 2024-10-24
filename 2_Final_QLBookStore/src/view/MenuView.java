package view;

import java.util.Scanner;

public class MenuView {

	private static Scanner sc = new Scanner(System.in);

	public static int menu() {
		do {
			try {
				System.out.println("\n===========Menu==========");
				System.out.println("0. Quit.");
				System.out.println("1. Input info books.");
				System.out.println("2. Show all Book.");
				System.out.println("3. update Book theo (ID).");
				System.out.println("4. update Book theo (Title).");
				System.out.println("5. Find by Title.");
				System.out.println("6. Find by Author.");
				System.out.println("7. Find by price > x.");
				System.out.println("8. Tang 50% gia cho book Y va cua author Z .");
				System.out.println("9. Sap xep Book theo price tang dan.");
				System.out.println("10. Sap xep Book theo qty giam dan.");
				System.out.print("Nhập lựa chọn: ");
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("\nKhông có lựa chọn này!!!");
			}
		} while (true);
	}
}
