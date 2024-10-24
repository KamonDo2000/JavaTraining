package General_Ass_Day1;

import java.util.Scanner;

public class Ex7 {

	static Scanner sc = new Scanner(System.in);

	public static void show() {
		System.out.print("\nNhap S: ");
		String s = sc.nextLine();

		System.out.println("===========");
		char[] arr = s.toCharArray();
		for (int i = arr.length - 1; i >= 0; --i) {
			System.out.print(arr[i]);
		}
		System.out.println("\n===========");
		System.out.println(s.toUpperCase());
		System.out.println("===========");

		System.out.println(s.toLowerCase());
		System.out.println("===========");

		for (int i = 0; i < arr.length; i++) {
			int count = 1;
			for (int i_1 = i + 1; i_1 < arr.length; i_1++) {
				if (arr[i] == arr[i_1]) {
					++count;
					arr[i_1] = 0;
				}
			}
			if (arr[i] != 0) {
				System.out.println("ky tu " + arr[i] + " xuat hien " + count + " lan");
			}

		}
		int n = 0;
		int m = 0;
		System.out.println("===========");
		try {
			System.out.print("\nNhap N: ");
			n = Integer.parseInt(sc.nextLine());
			System.out.print("\nNhap M: ");
			m = Integer.parseInt(sc.nextLine());
		} catch (Exception e) {
			System.out.println("N M phai la so nguyen");
		}

		if (n > m) {
			n = n + m;
			m = n - m;
			n = n - m;
		}
		if (m > s.length()) {
			m = s.length();
		}
		System.out.println(s.substring(n, m));

	}

}
