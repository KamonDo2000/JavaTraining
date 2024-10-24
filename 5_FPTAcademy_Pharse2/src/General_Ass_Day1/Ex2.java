package General_Ass_Day1;

import java.util.Scanner;

public class Ex2 {
	private static Scanner sc = new Scanner(System.in);

	public static void show() {
		int n;
		double sum = 1;
		do {
			try {
				System.out.println("input n: ");
				n = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Nhap sai");
			}
		} while (true);

		for (int i = 2; i < n; i++) {
			sum = sum + (1.0 / i);
		}

		System.err.println("1+1/2+1/3+....+1/n = " + sum);
	}
}
