package day6.Opt2;

import java.util.Scanner;

import common.func;

public class Ass2_add {

//	Viết hàm Thêm 01 phần tử có giá trị X vào vị trí Y 
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

		int Y;
		do {
			System.out.print("\nNhâp vị trí Y bạn muốn thêm:  ");
			Y = in.nextInt();
			if(Y > n + 1 || Y < 1) {
				System.out.printf("\nMảng của bạn có độ lớn %d nếu bạn muốn thêm cuối mảng thì vị trí là %d", n, n+1);
			}
		} while (Y > n + 1 || Y < 1);

		int[] newArr = new int[n];
		if(Y == n+1) {
			newArr = func.addValueLastArr(arr, X);
		}else {
			newArr = func.addValueArr(arr, X, Y); // function change
		}

		func.readArr(newArr);
	}

}
