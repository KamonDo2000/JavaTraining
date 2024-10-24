package days12.Otp2;

import java.util.Stack;

public class Ass1 {
//Viết chương trình đổi 1 số nguyên dương từ hệ thập phân sang hệ nhị phân.
	public static void main(String[] args) {

		Stack stack = new Stack();
		int num = 123;

		while (num != 0) {
			int mod = num % 2;
			stack.push(mod);
			num = num / 2;
		}

		String n = "";
		while (!stack.isEmpty()) {
			n +=stack.pop().toString();
		}
		
		num = Integer.parseInt(n);
		System.err.println(num);

	}

}
