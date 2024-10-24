package day6.Opt2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import common.func;

public class Ass2 {

//	Viết hàm Thay 01 phần tử có giá trị X vào vị trí Y 
//	trong mảng số nguyên bất kỳ (Mảng số nguyên đã nhập trước đó);

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhap độ lớn của mảng N:  ");
		int n = in.nextInt();
		int j = 1;

		int[] arr;
		arr = func.inputArr(n);

		func.readArr(arr);

		System.out.print("\nNhâp giá trị X bạn muốn thêm:  ");
		int X = in.nextInt();
		System.out.print("\nNhâp vị trí Y bạn muốn thay:  ");
		int Y = in.nextInt();

		int[] newArr = new int[n];
		newArr = func.changeValueArr(arr, X, Y); // function change

		func.readArr(newArr);
	}
}
