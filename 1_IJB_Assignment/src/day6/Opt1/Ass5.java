package day6.Opt1;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicSliderUI.ScrollListener;

import common.func;

public class Ass5 {

//	Viết hàm chứa các giá trị LẺ trong mảng số nguyên A chứa N phần tử 
//	(N nhập vào từ bàn phím) vào mảng số nguyên LẺ B.
//	Các giá trị của mảng A được nhập từ hàm đã viết ở Bài 1.


	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhap so phan tu mang A:  ");
		int N = input.nextInt();

		int[] A;
		int[] B;

		A = func.inputArr(N);
		B = func.oddFillNum(A);
		
		for (int i : B) {
			System.out.print(i+"  ");
		}
	}

}
