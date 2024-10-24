package day4;

import java.util.Scanner;

public class Ass7 {
//	In dãy số 2, 4, 6, 8, 10 … 2n (n là số nhập vào từ bàn phím) 
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i;

		System.out.print("Nhap n: ");
		int n = input.nextInt();

		for (i = 2; i <= (2 * n); i += 2) {
			System.out.print(i + "\t");
			if (i % 10 == 0) {
				System.out.print("\n");
			}
		}
	}

}
