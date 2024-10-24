package day9.Otp1;

public class Asss10 {
//	Code lại đoạn code có thêm exception và cho biết nó báo exception loại nào:
//		int value = 10 / 0;
//		System.out.println(value);

//Loại Exception sẽ là by zero;

	public static void main(String[] args) {
		try {
			int value = 10 / 0;
			System.out.println(value);
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
	}
}
