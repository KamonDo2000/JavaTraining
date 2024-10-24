package days12.Otp1;

import java.util.Iterator;
import java.util.Stack;

//Cách đảo ngược một String bởi sử dụng Stack trong Java?
public class Ass2 {
	public static void main(String[] args) {
		String str = "Hello World";

		Stack stack = new Stack();
		char[] arrStr = str.toCharArray();

		for (int i = 0; i < arrStr.length; i++) {
			stack.push(arrStr[i]);
		}

		String newStr = "";
		while (!stack.isEmpty()) {
			newStr+=stack.pop();
		}
		
		System.out.println(newStr);
	}
}
