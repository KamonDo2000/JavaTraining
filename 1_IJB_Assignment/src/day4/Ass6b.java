package day4;

import java.util.Scanner;

public class Ass6b {

//	In dãy số 2, 4, -6, 8, 10, -12 … n (bằng ít nhất 2 cách khác nhau) 
//	(n là số nhập vào từ bàn phím)
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int i = 2;

		System.out.print("Nhap n tu ban phim: ");
		int n = in.nextInt();

		while (i <= n) {
			if (i % 3 == 0) {
				System.out.print("-" + i + "\t");
			} else {
				System.out.print(i + "\t");
			}
			if (i % 10 == 0) {
				System.out.print("\n");
			}
			i += 2;
		}
	}

}
