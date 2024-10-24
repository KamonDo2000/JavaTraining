package days10;

import java.util.Iterator;

public class test {

	// Tìm kiếm phần tử lớn thứ hai trong mảng, swap hai phần tử, không dùng đến
	// biến tạm
	public static void main(String[] args) {
		int[] arr = {0, 0, 0, 0} ;

		int max = arr[0];
		int min = Integer.MAX_VALUE;
		int result = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
		}

		if (min != max) {
			result = min;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] > result && arr[i] < max) {
					result = arr[i];
				}
			}
			System.out.println(result);
		} else {
			System.out.println("Không có giá trị lớn thứ 2");
		}

		System.out.println(min);
		System.out.println(max);
		
		
		SwapAB();
	}
	
	public static void SwapAB() {
		int a = 10;
		int b = 20;

//		a = a + b;
//		b = a - b;
//		a = a - b;
		
		a *= b;
		b = a/b;
		a = a/b;
		
		System.out.println(a);

		System.out.println(b);
	}
}
