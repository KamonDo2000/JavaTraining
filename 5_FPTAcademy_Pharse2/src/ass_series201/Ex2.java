package ass_series201;

import java.util.Scanner;

public class Ex2 {
	public static void show() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			try {
				System.out.print("Input first number: ");
				int a = Integer.parseInt(sc.nextLine());

				System.out.print("Input second number: ");
				int b = Integer.parseInt(sc.nextLine());

				System.out.print("Input third number: ");
				int c = Integer.parseInt(sc.nextLine());

				System.out.print("Input fourth number: ");
				int d = Integer.parseInt(sc.nextLine());

				if (a == b && a == c && c == d) {
					System.out.println("Numbers are equal!");
				} else {
					System.out.println("Numbers are not equal!");
				}
				sc.close();
				break;
			} catch (Exception e) {
				System.out.println("Nhap sai");
				continue;
			}
		}
	}
}
