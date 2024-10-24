package day5;

import java.util.Scanner;

public class Ass2 {

//	In dãy số 1, 2, 3, 5, 8, 13, … (n là số nhập vào từ bàn phím) (*)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int after_i = 0;
		int i = 1;
		int before_i = 1;
		int num;

		System.out.print("Nhap so n:  ");
		int n = input.nextInt();

		for (; before_i <= n; before_i = i + after_i) {
			num = i;
			i = before_i;
			after_i = num;
			System.out.print(before_i + "\t");
		}
	}

}
