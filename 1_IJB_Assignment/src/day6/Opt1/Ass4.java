package day6.Opt1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import common.func;

public class Ass4 {

//	Viết hàm chứa các giá trị CHẴN trong mảng số nguyên A chứa 
//	N phần tử (N nhập vào từ bàn phím) vào mảng số nguyên CHẴN B.

//	Các giá trị của mảng A được nhập từ hàm đã viết ở Bài 1.

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Nhap gia tri N:  ");
		int N = input.nextInt();

		int[] A = new int[N];
		int[] B;

		A = func.inputArr(N);

		System.out.println("\nMang cu A: ");
		for (int i : A) {
			System.out.print(i + "   ");
		}

		B = func.evenFillNum(A);

		System.out.println("\nMang moi B: ");
		for (int i : B) {
			System.out.print(i + "   ");
		}

	}

}
