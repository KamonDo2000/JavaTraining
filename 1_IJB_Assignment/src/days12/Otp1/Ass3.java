package days12.Otp1;

import java.util.Stack;

public class Ass3 {
//	Tính giá trị biểu thức: 4 5 - 3 2 / + 5 * 
	// là số thì bỏ vào stack là dấu thì lấy 2 số từ ngăn ra tính rồi bỏ vô lại.

	public static void main(String[] args) {
		String string = "4 5 - 3 2 / + 5 *";
		Stack<Double> stack = new Stack<>();

		String[] arrValue = string.split(" ");

		for (String value : arrValue) {
			if (value.equals("*") || value.equals("/") || value.equals("+") || value.equals("-")) {

				double numRight = stack.pop();
				double numLeft = stack.pop();

				double result = tinhToanTheoDau(value, numLeft, numRight);
				stack.push(result);
			} else {
				stack.push(Double.parseDouble(value));
			}
		}

		System.out.println("S: " + stack.pop());
	}

	private static double tinhToanTheoDau(String Dau, double numLeft, double numRight) {
		switch (Dau) {
		case "+":
			return numLeft + numRight;
		case "-":
			return numLeft - numRight;
		case "*":
			return numLeft * numRight;
		case "/":
			return numLeft / numRight;
		default:
			return 0;
		}
	}

}
