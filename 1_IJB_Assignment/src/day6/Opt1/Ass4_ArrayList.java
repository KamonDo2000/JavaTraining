package day6.Opt1;

import java.util.ArrayList;
import java.util.Scanner;

import common.func;

public class Ass4_ArrayList {

//	Viết hàm chứa các giá trị CHẴN trong mảng số nguyên A chứa 
//	N phần tử (N nhập vào từ bàn phím) vào mảng số nguyên CHẴN B.

//	Các giá trị của mảng A được nhập từ hàm đã viết ở Bài 1.

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.print("Nhap gia tri N:  ");
		int N = input.nextInt();

		int[] A = new int[N];

		A = func.inputArr(N);

		ArrayList<Integer> arrEven = new ArrayList<Integer>();

		for (int i = 0; i < A.length; i++) {
			if (A[i] % 2 == 0) {
				arrEven.add(A[i]);
			}
		}
		Integer[] B = new Integer[arrEven.size()];// Khi lưu vào arrlist là lưu dạng object nên khi convert sang mảng,
													// mảng phải có dạng object

		B = arrEven.toArray(B);

		for (int i = 0; i < B.length; i++) {
			System.out.println(B[i]);
		}
	}

}
