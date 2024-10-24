package ass_series301;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FrequentNumber {

	static final String RG_CHECK = "^[yYnN]$";

	static Scanner sc = new Scanner(System.in);

	public static void show() {
		int n;
		while (true) {
			try {
				System.out.println("input lenght array: ");
				n = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Nhap sai");
			}
		}
		int[] intArray = new int[n];

		inputArray(intArray);

		int value;
		int count = 0;
		List<Integer> index = new ArrayList<>();

		while (true) {
			try {
				System.out.println("input value check number: ");
				value = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Nhap sai");
			}
		}

		for (int i = 0; i < intArray.length; i++) {
			if (value == intArray[i]) {
				index.add(i);
				count++;
			}
		}

		System.out.println("Amount of frequence:" + count);
		System.out.print("Indexs: ");
		for (Integer i : index) {
			System.out.print("  " + i);
		}
	}

	private static int[] inputArray(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			String check = null;
			do {
				try {
					System.out.println("input value number: ");
					arr[i] = Integer.parseInt(sc.nextLine());
					break;
				} catch (Exception e) {
					System.out.println("Nhap sai");
				}
			} while (true);
			if (!checkContinue(check)) {
				break;
			}
		}
		return arr;
	}

	private static boolean checkContinue(String check) {
		while (true) {
			System.out.println("Do you want to continue?: Y/N");
			check = sc.nextLine();

			if (!check.matches(RG_CHECK)) {
				System.out.println("Chi duoc nhap y/n");
				continue;
			}

			if (check.equalsIgnoreCase("n")) {
				return false;
			} else {
				break;
			}
		}
		return true;
	}

}
