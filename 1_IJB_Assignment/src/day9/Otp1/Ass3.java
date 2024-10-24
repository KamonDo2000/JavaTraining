package day9.Otp1;

import java.util.ArrayList;

public class Ass3 {
	public static void main(String[] args) {
//		Đoạn code sau có throw NullPointerException hay không? Giải thích vì sao?
		ArrayList<String> a = new ArrayList<String>();
		a.add("Hello");
		System.out.println(a.get(1));
	}
}

// Không bị null point exception. vì object String hello được add vào trong ArrayList
// Mà sẽ bị index out of bounds do add vào mảng a cũng chỉ có 1 phần tử nằm ở index 0
// get index 1 ra thì sẽ bị OutOfBoundsException
