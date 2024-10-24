package day5;

import java.util.Scanner;

public class Ass2b {

//	In dãy số 1, 2, 3, 5, 8, 13, … (n là số nhập vào từ bàn phím) (*)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Nhap so n:  ");
		int n = input.nextInt();
		
		for(int i=1; i<=n; i++) {
			int num = fib(i);
			if(i%10==0) {
				System.out.println("\n");
			}
			System.out.print(num+"\t");
		}
	}

	static int fib(int i) {
		if (i <= 1) {
			return i;
		}
		return fib(i - 1) + fib(i - 2);
	}
}
