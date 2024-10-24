package day6.Opt1;

import java.util.Scanner;

import common.func;

public class Ass1 {

//	Viết hàm nhập và hàm hiển thị tất cả các giá trị đã nhập vào
//	mảng số nguyên chứa N phần tử (N nhập vào từ bàn phím)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int[] Arr;

		System.out.print("Nhap do dai mang N: ");
		int N = input.nextInt();

		Arr = func.inputArr(N);

		for (int i = 0; i < Arr.length; i++) {
			System.out.printf("{ %d }, ", Arr[i]);
		}

	}
	
	
}
