package General_Ass_Day1;

import java.util.Scanner;

public class Ex4 {
	static Scanner sc = new Scanner(System.in);

	public static void show() {
		int m;
		do {
			System.out.println("Input value n: ");
			m = Integer.parseInt(sc.nextLine());
			break;
		} while (true);

		int sum = 1;
		while (true) {

			sum = sum * (m % 10);
			m = m / 10;

			if (m == 0) {
				break;
			}
		}

		System.out.println("Sum = " + sum);
	}

}
