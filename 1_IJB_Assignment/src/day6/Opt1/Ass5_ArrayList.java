package day6.Opt1;

import java.util.ArrayList;
import java.util.Scanner;

import common.func;

public class Ass5_ArrayList {

//	Viết hàm chứa các giá trị LẺ trong mảng số nguyên A chứa N phần tử 
//	(N nhập vào từ bàn phím) vào mảng số nguyên LẺ B.
//	Các giá trị của mảng A được nhập từ hàm đã viết ở Bài 1.

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhap so phan tu mang A:  ");
		int N = input.nextInt();

		int[] A;

		A = func.inputArr(N);
		ArrayList<Integer> oddList = new ArrayList<Integer>();

		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 != 0) {
				oddList.add(A[i]);
			}
		}

		Integer[] B = new Integer[oddList.size()];
		oddList.toArray(B);

		for (int i = 0; i < B.length; i++) {
			System.out.println(B[i]);
		}
	}

}
