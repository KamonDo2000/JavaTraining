package General_Ass_Day1;

import java.util.Scanner;

public class Ex9 {

	private static Scanner sc = new Scanner(System.in);

	public static void show() {

		System.out.println("Input colum: ");
		int n = inputValue();

		System.out.println("Input row: ");
		int m = inputValue();

		int[][] arrTD = new int[n][m];

		int num = 0;

		for (int mi = 0; mi < m; mi++) {
			for (int ni = 0; ni < n; ni++) {
				arrTD[ni][mi] = num;
				num++;
			}
		}

		int boiSo3 = 1;

		for (int ni = 0; ni < n; ni++) {
			if (arrTD[ni][0] % 3 == 0 && arrTD[ni][0] != 0) {
				boiSo3 *= arrTD[ni][0];
			}
		}

		System.out.println("helo " + boiSo3);

		int[] arr = new int[m];
		int maxRow = 0;

		for (int mi = 0; mi < m; mi++) {
			for (int ni = 0; ni < n; ni++) {
				if (arrTD[ni][mi] > maxRow) {
					maxRow = arrTD[ni][mi];
				}
			}
			arr[mi] = maxRow;
		}

		for (int i : arr) {
			System.err.print(i + "   ");
		}

	}

	private static int inputValue() {
		int n;
		while (true) {
			try {
				System.out.print("Input number: ");
				n = Integer.parseInt(sc.nextLine());
				break;
			} catch (Exception e) {
				System.out.println("Nhap sai");
				continue;
			}
		}
		return n;
	}

}
