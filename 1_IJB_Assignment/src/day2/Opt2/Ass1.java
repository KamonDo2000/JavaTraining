package day2.Opt2;

import java.util.Scanner;

public class Ass1 {
//	nhập vào hai giá trị nguyên và sau đó chương trình in ra kết quả cộng, trừ, nhân, chia giữa hai giá trị.
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Nhập vào giá trị nguyên thứ nhất a:  ");
		int a = input.nextInt();
		System.out.print("Nhập vào giá trị nguyên thứ hai b:  ");
		int b = input.nextInt();
		
		System.out.println("\na + b = "+ (a+b));
		System.out.println("a - b = "+ (a-b));
		System.out.println("a x b = "+ (a*b));
		System.out.println("a : b = "+ (a/b) + " dư " + (a%b));

	}

}
