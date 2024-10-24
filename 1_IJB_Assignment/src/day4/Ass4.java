package day4;

import java.util.Scanner;

public class Ass4 {
//	In dãy số 1, 3, 5, 7, 9 … n (n là số nhập vào từ bàn phím)
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i;

		System.out.print("Nhap n tu ban phim: ");
		int n = in.nextInt();

		for (i = 1; i <= n; i += 2) {
			System.out.print(i + "\t");
			if (i % 5 == 0) {
				System.out.print("\n");
			}
		}
	}

}
