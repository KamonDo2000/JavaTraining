package day5;

import java.util.Iterator;
import java.util.Scanner;

public class Ass6 {

//		Viết chương trình tính  :
//		S = 1+1/3!+1/5!+…..+1/(2n-1)!                        (*)
//		Số n được nhập từ bàn phím

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i;
		float sum = 0;
		System.out.print("Nhap so n:  ");
		int n = input.nextInt();

		for (i = 1; i <= (2*n-1); i+=2) {
				sum += (float) 1 / tinhGiaiThua(i);
		}
		System.out.print("S=  " + sum);
	}

	public static int tinhGiaiThua(int i) {
		int giaiThua = 1;
		for (int c = 1; c <= i; c++) {
			giaiThua *= c;
		}
		return giaiThua;
	}

}
