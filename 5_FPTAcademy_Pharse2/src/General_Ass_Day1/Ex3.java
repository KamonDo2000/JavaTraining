package General_Ass_Day1;

import java.util.Scanner;

public class Ex3 {
	static Scanner sc = new Scanner(System.in);

	public static void show() {
		int n;
		do {
			System.out.println("Input value n: ");
			n = Integer.parseInt(sc.nextLine());
			break;
		} while (true);
		double sum = 0;
		n = 2 * n - 1;

		for (int i = 1; i < n;) {
			double number = giaiThua(i);
			sum = sum + (1 / number);
			i += 2;
		}

		System.out.println(sum);
		sc.close();

	}

	public static int giaiThua(int n) {
		if (n > 1) {
			n = n * giaiThua(n - 1);
			return n;
		}
		return n;
	}

}
