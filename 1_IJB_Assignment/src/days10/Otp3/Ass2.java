package days10.Otp3;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/*Viết hàm đếm xem có bao nhiêu phần tử còn thiếu trong mảng số nguyên A chưa được sắp xếp (đã được nhập vào từ bài 1 topic 1).
 *  Nếu không có thì trả về 0. 
 * Chú ý: Các giá trị còn thiếu trong mảng nằm trong khoảng giá trị nhỏ nhất và lớn nhất trong mảng A;
Ví dụ 1:
Input: A[] = {2, 4, 10, 7}
Output: 3, 5, 6, 8, 9
Ví dụ 2:
Input: A[] = {2, 10, 9, 4}
Output: 3, 5, 6, 7, 8
*/
public class Ass2 {

	public static void main(String[] args) {
		int[] arr = { 0, 4, 5, 16, 4, 0 };
		findValueLack(arr);
	}

	private static void findValueLack(int[] arr) {
		int min = arr[0];
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				min = arr[i];
			}
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		Set<Integer> arrLack = new HashSet<Integer>();

		if (min != max) {
			for (int i = min + 1; i < max; i++) {
				arrLack.add(i);
			}
			for (int i = 0; i < arr.length; i++) {
				arrLack.remove(arr[i]);
			}
		}

		if (arrLack.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(arrLack);
		}

	}

}
