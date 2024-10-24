package day4;

import java.util.Scanner;

public class Ass3 {
//	In dãy số 1, 2, 3, 4, 5 … n (n là số nhập vào từ bàn phím)
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i;

		System.out.print("Nhap n tu ban phim:  ");
		int n = in.nextInt();

		for (i = 1; i <= n; i++) {
			if (i % 10 == 0) {
				System.out.println("\n");
			}
			System.out.print(i + "\t");
		}
	}

}
