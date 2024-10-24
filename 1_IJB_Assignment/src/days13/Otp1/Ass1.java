package days13.Otp1;

import java.util.Iterator;

//Tính dãy số Fibonacci sử dụng đệ quy

public class Ass1 {

	public static void main(String[] args) {
		int fibIndex = 10;
		for (int i = 0; i <= fibIndex; i++) {
			System.out.print(fibonacy(i)+ "  ");
		}

	}

	public static int fibonacy(int fibIndex) {
		if (fibIndex == 1) {
			return 1;
		}
		if (fibIndex == 0) {
			return 0;
		}
		return fibonacy(fibIndex - 1) + fibonacy(fibIndex - 2);
	}

}
