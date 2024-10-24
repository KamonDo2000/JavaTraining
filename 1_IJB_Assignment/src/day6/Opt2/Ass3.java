package day6.Opt2;

import java.util.Scanner;

import common.func;

public class Ass3 {

//	Viết hàm Xóa 01 phần tử ở vị trí Y trong mảng số
//	nguyên bất kỳ (Mảng số nguyên đã nhập trước đó);
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhap do lon cua Arr: ");
		int n = in.nextInt();

		int[] arr;
		arr = func.inputArr(n);

		func.readArr(arr);

		System.out.print("\nMuon xoa phan tu thu:  ");
		int delIndex = in.nextInt();

		int[] newArr;
		newArr = func.delIndexArr(arr, delIndex);

		func.readArr(newArr);
	}

	

}
