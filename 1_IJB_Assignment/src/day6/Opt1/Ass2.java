package day6.Opt1;

import java.util.Random;
import java.util.Scanner;

public class Ass2 {

//	Viết hàm sinh ra N giá trị số nguyên bất kỳ cho mảng và 
//	hiển thị các giá trị trong mảng ra màn hình (N nhập vào từ bàn phím)
	public static void main(String[] args) {
		int[] arr ;
		Scanner input=new Scanner(System.in);
		Random rd = new Random();
		
		System.out.print("Nhap N:  ");
		int N = input.nextInt();
		
		arr = new int[N];
		
		for(int i=0; i<arr.length;i++) {
			arr[i]=rd.nextInt(100)+1;
		}
		
		for (int i : arr) {
			System.out.printf("[ %d ], ", i);
		}
	}

}
