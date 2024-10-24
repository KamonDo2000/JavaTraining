package General_Ass_Day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex8 {
	private static Scanner sc = new Scanner(System.in);

	private static int inputValue() {
		int n;
		while (true) {
			try {
				System.out.print("Input so: ");
				n = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Nhap sai");
				continue;
			}
		}
		return n;
	}

	public static void show() {
		List<Integer> arrInt = new ArrayList<>();
		System.out.println("Nhap Do lon cua mang:  ");
		int n = inputValue();

		System.out.println("Nhap cac phan tu vao mang:  ");
		for (int i = 0; i < n; i++) {
			arrInt.add(inputValue());
		}
		System.out.println("=======================================================");

		int sum = 0;
		for (Integer i : arrInt) {
			if (i > 0) {
				sum += i;
			}
		}
		System.out.println("Tong Duong cua mang: " + sum);
		System.out.println("=======================================================");
		System.out.println("Nhap k:  ");
		int k = inputValue();

		System.out.print("Vi tri của K:  ");
		
		for (int i = 0; i < arrInt.size(); i++) {
			if (arrInt.get(i) == k) {
				System.out.print(i + "   ");
			}
		}
		System.out.println("\n=======================================================");
		arrInt.sort(null);
		for (Integer i : arrInt) {
			System.out.print(i + "   ");
		}

		System.out.println("\n=======================================================");
		System.out.println("Nhap a:  ");
		int a = inputValue();

		arrInt.add(a);
		arrInt.sort(null);
		
		for (Integer i : arrInt) {
			System.out.print(i + "   ");
		}

		sc.close();
	}

}
