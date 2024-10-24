package days10.Otp3;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

//Hiển thị các giá trị trùng nhau trong mảng số nguyên A 
//(đã được nhập vào từ bài 1 topic 1). Nếu không có thì hiển thị 0;
public class Ass1 {
	
	public static void main(String[] args) {
		int[] arr = { 0, 4, 5, 16, 4, 0 };
		findDuplicate(arr);
	}

	public static void findDuplicate(int[] arr) {
		Set<Integer> arrSet = new HashSet<Integer>();

		for (int i = 0; i < arr.length; i++) {
			for (int f = arr.length - 1; f > i; f--) {
				if (arr[i] == arr[f]) {
					arrSet.add(arr[i]);
				}
			}
		}

		if (arrSet.isEmpty()) {
			System.out.println(0);
		} else {
			System.out.println(arrSet);
		}

	}
}
