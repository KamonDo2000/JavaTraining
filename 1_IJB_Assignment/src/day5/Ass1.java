package day5;

import java.util.Scanner;

public class Ass1 {
//			0 1   2  3  4   5    6   7   8    9
//	In dãy số 2, -4, 6, 8, -10, 12, 14, 16, -18, ….., n (**)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i;
		int count = 1;
		int indexjunp = 2;
		int jump = 3;

		System.out.print("Nhap so n:  ");
		int n = input.nextInt();

		for (i = 2; i <= n; i+=2) {
			if (count == indexjunp) {
				System.out.print(-i + "\t");
				indexjunp += jump;
				jump++;
				count++;
			} else{
				System.out.print(i + "\t");
				count++;
			}
			if (i % 10 == 0) {
				System.out.println("\n");
			}
		}
	}

}
