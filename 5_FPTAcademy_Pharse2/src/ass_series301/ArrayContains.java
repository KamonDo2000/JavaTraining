package ass_series301;

import java.util.Scanner;

public class ArrayContains {
	public static void show() {
		Scanner sc = new Scanner(System.in);

		int n;
		while (true) {
			try {
				System.out.println("input value String: ");
				n = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Nhap sai");
			}
		}
		String[] stringArray = new String[n];

		for (int i = 0; i < stringArray.length; i++) {
			System.out.println("input value String: ");
			stringArray[i] = sc.nextLine();
		}

		System.out.println("input value String: ");
		String sValue = sc.nextLine();

		for (String s : stringArray) {
			if (sValue.equals(s)) {
				System.out.println("Check '" + sValue + "' in Array: Contained!");
				sc.close();
				return;
			}
		}
		System.out.println("Check '" + sValue + "' in Array: No Contain!");
		sc.close();
	}

}
