package day6.Opt2;

import java.util.ArrayList;
import java.util.Scanner;

import common.func;

public class Ass1_ArrayList {

//	Viết hàm tính tổng các giá trị trong mảng số nguyên bất kỳ và
//	áp dụng tính tổng các giá trị số nguyên trong mảng Chẵn và Lẻ ở Bài 4 và 5;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhap do dai cua Array:  ");
		int N = in.nextInt();

		int[] arr = new int[N];
		ArrayList<Integer> evenArr = new ArrayList<Integer>();
		ArrayList<Integer> oddArr = new ArrayList<Integer>();

		arr = func.inputArr(N);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				evenArr.add(arr[i]);
			} else {
				oddArr.add(arr[i]);
			}
		}
		int resultEven = 0;
		int resultOdd = 0;

		for (int i = 0; i < evenArr.size(); i++) {
			resultEven += evenArr.get(i);
		}

		for (int i = 0; i < oddArr.size(); i++) {
			resultOdd += oddArr.get(i);
		}

		System.out.println("\nGia tri tong so chan:  " + resultEven);
		System.out.println("\nGia tri tong so le:  " + resultOdd);
	}
}
