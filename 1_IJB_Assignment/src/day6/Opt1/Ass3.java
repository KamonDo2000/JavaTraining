package day6.Opt1;

import java.util.ArrayList;
import java.util.Scanner;

import common.func;

public class Ass3 {

//	Viết hàm hiển thị các giá trị chẵn	trong mảng	số nguyên	chứa N	phần tử
//	(N nhập vào từ bàn phím).Các giá trị của mảng được nhập từ hàm đã viết ở Bài 1.

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] Arr;

		System.out.print("Nhap do dai mang N: ");
		int N = input.nextInt();

		Arr = func.inputArr(N);

		System.out.print("\n\nMang da nhap vao: ");
		for (int i = 0; i < Arr.length; i++) {
			System.out.printf("{ %d }, ", Arr[i]);
		}
		func.showEvenNum(Arr);

	}

}
