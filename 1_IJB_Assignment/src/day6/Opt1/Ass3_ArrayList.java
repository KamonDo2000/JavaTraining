package day6.Opt1;

import java.util.ArrayList;
import java.util.Scanner;

import common.func;

public class Ass3_ArrayList {

//	Viết hàm hiển thị các giá trị chẵn	trong mảng	số nguyên	chứa N	phần tử
//	(N nhập vào từ bàn phím).Các giá trị của mảng được nhập từ hàm đã viết ở Bài 1.
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhap do dai N: ");
		int N = in.nextInt();

		int[] arr = new int[N];
		arr = func.inputArr(N);

		ArrayList<Integer> arrEven = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if(arr[i]%2==0) {
				arrEven.add(arr[i]);
			}
		}
		
		System.out.println(arrEven.toString());
	}

}
