package day4;

import java.util.Scanner;

public class Ass6a {
//	In dãy số 2, 4, -6, 8, 10, -12 … n (bằng ít nhất 2 cách khác nhau) 
//	(n là số nhập vào từ bàn phím)
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i;

		System.out.print("Nhap n tu ban phim: ");
		int n = in.nextInt();

		for (i = 2; i <= n; i += 2) {
			if (i % 3 == 0) {
				System.out.print(-i + "\t");
			} else {
				System.out.print(i + "\t");
			}

			if (i % 10 == 0) {
				System.out.print("\n");
			}
		}
	}

}
