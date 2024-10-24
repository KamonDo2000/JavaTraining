package days12.Otp1;

import java.util.Scanner;
import java.util.Stack;

public class Ass1 {
//	Cách in tổng n số trong Java?
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> stack = new Stack();
		int n = 3;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			System.out.println("Nhập số thứ " + (i + 1));
			int num = Integer.parseInt(sc.nextLine());
			sum = sum + stack.push(num);
		}

		System.out.println(sum);
	}

}
