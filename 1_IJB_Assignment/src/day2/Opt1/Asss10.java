package day2.Opt1;

import java.util.Scanner;

public class Asss10 {
	
//	Cho các ví dụ về ép kiểu mà độ chính xác không bị thay đổi, như thứ tự bên dưới:
//		byte->short->int->long->float->double"	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("moi nhap:");
		double h = input.nextDouble(); 
		float q = (float) h;
		long m = (long) q;
		int t = (int)m;
		
		System.out.println(h);
		System.out.println(q);
		System.out.println(m);
		System.out.println(t);
		
		byte a = 100;
		short b = a;
		System.out.println("Giá trị biến short sau khi ép từ byte: "+b);
		int c = b;
		System.out.println("Giá trị biến int sau khi ép từ short: "+c);
		long d = c;
		System.out.println("Giá trị biến long sau khi ép từ int: "+d);
		float e = (float)d;
		System.out.println("Giá trị biến float sau khi ép từ long: "+e);
		double f = (double)e;
		System.out.println("Giá trị biến double sau khi ép từ float: "+f);
	}

}
