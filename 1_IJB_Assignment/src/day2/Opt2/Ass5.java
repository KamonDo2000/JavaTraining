package day2.Opt2;

import java.util.Scanner;

public class Ass5 {
//	Tính chu vi 2Pi*r và diện tích hình tròn Pi*r2
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		System.out.print("Nhap ban kinh hinh tron: ");
		float r = in.nextFloat();
		
		System.out.printf("Chu Vi hinh tron: %5.2f %n", (2*Math.PI*r));
		System.out.printf("Dien Tich hinh tron: %5.2f", (Math.PI*Math.pow(r, 2)));
	}
}
