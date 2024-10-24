package day2.Opt1;

import java.util.Scanner;

public class Ass3 {
	private static Scanner input;

//	Giải phương trình bậc 1	
	public static void main(String[] args) {
		System.out.println("Giải Phương Trình A*x + b = 0");
		input = new Scanner(System.in);
		System.out.print("Nhập vào a: \t");
		float a = Float.parseFloat(input.nextLine());
		System.out.print("Nhập vào b: \t");
		float b = Float.parseFloat(input.nextLine());
		if (a == 0) {
			if (b != 0) {
				System.out.println("phương trình này vô nghiệm");
			} else {
				System.out.println("Biến x có vô số nghiệm");
			}
		} else {
			System.out.println("Biến x có giá trị là: " + (-b / a));
		}
	}
}
