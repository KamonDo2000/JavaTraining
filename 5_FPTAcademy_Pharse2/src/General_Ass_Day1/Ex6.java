package General_Ass_Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex6 {

	static Scanner sc = new Scanner(System.in);

	public static void show() {

		int n;
		do {
			System.out.println("Input value n: ");
			n = Integer.parseInt(sc.nextLine());
			break;
		} while (true);

		List<Integer> arrV = new ArrayList<>();

		do {
			if (n == 0) {
				break;
			}
			if (n % 2 == 0) {
				n = n / 2;
				arrV.add(0);
			} else {
				n = n / 2;
				arrV.add(1);
			}
		} while (true);

		System.out.println();
		
		for (int i = arrV.size() - 1; i >= 0; i--) {
			System.out.print(arrV.get(i));
		}
	}

}
