package day2.Opt1;

import java.util.Scanner;

public class Ass5 {
	static Scanner input;
	
//	Nhập vào 2 số nguyên, lưu vào 2 biến a và b.
//	Sau đó, đảo giá trị của 2 biến này rồi xuất giá trị của chúng ra màn hình console.	
	public static void main(String[] args) {
		int temp;
		input = new Scanner(System.in);
		System.out.print("Nhap vao so a: ");
		int a = input.nextInt();
		
		System.out.print("Nhap vao so b: ");
		int b = input.nextInt();
		
		System.out.println("Gia tri cua a: "+ a +"\t Gia tri cua b: "+ b);
		temp = a;
		a = b;
		b = temp;
		System.out.println("Gia tri cua a: "+ a +"\t Gia tri cua b: "+ b);
	}
}