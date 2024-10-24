package General_Ass_Day1;

public class Fx10 {

	public static void show() {
//		Pass By Value
		int a = 4;
		int b = 8;
		System.out.print("a= " + a);
		System.out.println("b= " + b);
		swapNumberPassByValue(a, b);
		System.out.print("\n\na= " + a);
		System.out.println("b= " + b);

//		Pass By Reference

		int[] num = {3,4};
		System.out.print("a= " + num[0]);
		System.out.println("b= " + num[1]);
		swapNumberPassByRefference(num);
		System.out.print("\n\na= " + num[0]);
		System.out.println("b= " + num[1]);
	}

	/**
	 * Dua vao mot array doi vi tri cac phan tu ben trong array do
	 * 
	 * @param num
	 */
	public static void swapNumberPassByRefference(int[] num) {
		num[0] = num[0] + num[1];
		num[1] = num[0] - num[1];
		num[0] = num[0] - num[1];
	}

	/**
	 * Dua vao a va b doi gia tri a,b nhung khong the
	 * 
	 * @param a
	 * @param b
	 */
	public static void swapNumberPassByValue(int a, int b) {
		a = a + b;
		b = a - b;
		a = a - b;
	}

}
