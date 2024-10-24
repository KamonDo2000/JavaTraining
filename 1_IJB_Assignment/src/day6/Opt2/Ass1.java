package day6.Opt2;

import java.util.ArrayList;
import java.util.Scanner;

import common.func;

public class Ass1 {

//	Viết hàm tính tổng các giá trị trong mảng số nguyên bất kỳ và
//	áp dụng tính tổng các giá trị số nguyên trong mảng Chẵn và Lẻ ở Bài 4 và 5;


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhap do dai cua Array:  ");
		int N = input.nextInt();

		int[] arr = new int[N];
		int[] evenArr;
		int[] oddArr;

		arr = func.inputArr(N);
		evenArr = func.evenFillNum(arr);
		oddArr = func.oddFillNum(arr);

		int resultEven = func.sumInt(evenArr);
		int resultOdd = func.sumInt(oddArr);

		System.out.println("Gia tri mang chan:  " + resultEven);
		System.out.println("Gia tri mang le:  " + resultOdd);

	}

}
