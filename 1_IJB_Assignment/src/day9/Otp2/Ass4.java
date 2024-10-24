package day9.Otp2;

public class Ass4 {

	public static void main(String[] args) {
//		Viết thêm xử lý exception cho đoạn code dưới:
		int num1 = 30, num2 = 0;
		try {
			int output = num1 / num2;
			System.out.println("Result: " + output);
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
//----------------------------------------------------------------------------------------
		int a[] = new int[10];
		// Array has only 10 elements
		try {
			a[11] = 9;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}

//----------------------------------------------------------------------------------------
		try {
			int num = Integer.parseInt("XYZ");
			System.out.println(num);
		} catch (NumberFormatException e) {
			System.out.println(e);
		}
//----------------------------------------------------------------------------------------	
		try {
			String str = null;
			System.out.println(str.length());
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		

	}

}
