package days12.Otp1;

import java.util.Stack;

//Viết chương trình đổi 1 số nguyên dương từ hệ thập phân sang hệ bát phân.
public class Ass4 {
	public static void main(String[] args) {
//		int answer = (int) Math.pow(10, 2);
		Stack stack = new Stack();
		int num = 123;

		while (num != 0) {
			int mod = num % 8;
			stack.push(mod);
			num = num / 8;
		}

		String n = "";
		while (!stack.isEmpty()) {
			n +=stack.pop().toString();
		}
		
		num = Integer.parseInt(n);
		System.err.println(num);

	}
}
