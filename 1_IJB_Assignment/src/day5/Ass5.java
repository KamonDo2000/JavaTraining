package day5;

import java.util.Scanner;

public class Ass5 {

//	Viết chương trình tính :
//		S=1+1/2+1/3+....+1/n
//		Số n được nhập từ bàn phím

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i;
		float sum = 0;
		System.out.print("Nhap so n:  ");
		int n = input.nextInt();

		for (i = 1; i <= n; i++) {
			sum += (float) 1 / i;
		}
		System.out.print("S=  " + sum);
	}

}
