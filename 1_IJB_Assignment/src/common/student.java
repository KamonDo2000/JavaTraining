package common;

import java.util.Scanner;

public class student {

	/**
	 * Function nhập tên học sinh
	 * 
	 * @param n số lượng học sinh
	 * @return
	 */
	public static String[] inputNameStuden(int n) {
		Scanner input = new Scanner(System.in);
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			System.out.printf("Nhập tên học viên thứ %d:   ", i + 1);
			arr[i] = input.nextLine();
		}
		return arr;
	}

	/**
	 * Function nhập điểm số học sinh
	 * 
	 * @param n số lượng học sinh
	 * @return
	 */
	public static float[] inputMark(int n) {
		Scanner input = new Scanner(System.in);
		float[] arr = new float[n];
		for (int i = 0; i < n; i++) {
			do {
				System.out.printf("Nhập điểm cho học viên thứ %d:   ", i + 1);
				arr[i] = input.nextFloat();

				if (arr[i] > 10 || arr[i] < 0) {
					System.out.println("\n!!!Điểm Số lớn hơn 0 và nhỏ hơn 10!!!");
				}
			} while (arr[i] > 10 || arr[i] < 0);
		}
		return arr;
	}
}
