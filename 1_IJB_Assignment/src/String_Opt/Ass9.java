package String_Opt;

import java.util.Scanner;

public class Ass9 {
//	Thực hiện các việc chuyển đổi sau:
//		a. Chuyển đổi String thành int trong java
//		b. Chuyển đổi int thành String trong java

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		do {
			try {
				String str = sc.nextLine();
				
				a = Integer.parseInt(str);
				break;
			} catch (Exception e) {
				System.out.println("String Nhap vao chi la so");
			}
		} while (true);
		System.out.println(a);
		
		int b=123;
		
		System.out.println(String.valueOf(b));
		
		System.out.println(Integer.toString(b));
	}

}
