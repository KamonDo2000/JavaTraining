package days10.Otp2;

import java.util.Scanner;

//Tìm giá trị nhỏ nhất còn thiếu trong mảng số nguyên dương A (Đã nhập vào ở Bài 1).

public class Ass5 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = {0, 1, 1, 4, 4, 6};

//		{ 0, 1, 2, 3, 4}  {0, 1, 2, 4, 6, 9, 11, 15} {0, 1, 2, 3, 4, 6} { 1, 2, 3, 4, 6}
		
		int firtIndex = 0;
		int lastIndex = arr.length - 1;

		int x = findMinLack(arr, firtIndex, lastIndex);
		System.out.println(x);

	}

	private static int findMinLack(int[] arr, int firtIndex, int lastIndex) {
		int midIndex = firtIndex + (lastIndex - firtIndex) / 2;

		if (arr[0] != 0) {
			return 0;
		}
		if ((lastIndex - firtIndex) == 1) {
			return arr[firtIndex] + 1;
		}

		int sumLeft = sumXtoY(arr[firtIndex], arr[midIndex]);
		int sumRight = sumXtoY(arr[midIndex], arr[lastIndex]);

		int sumArrLeft = sumArr(arr, firtIndex, midIndex);
		int sumArrRight = sumArr(arr, midIndex, lastIndex);

		if (sumArrLeft == sumLeft && sumRight == sumArrRight) {
			return -1;
		}
		if (sumArrLeft == sumLeft && sumRight != sumArrRight) {
			return findMinLack(arr, midIndex, lastIndex);
		}
		if (sumArrLeft != sumLeft) {
			return findMinLack(arr, firtIndex, midIndex);
		}

		return -1;
	}

	private static int sumArr(int[] arr, int firtIndex, int lastIndex) {
		int result = 0;
		while (firtIndex <= lastIndex) {
			result += arr[firtIndex];
			++firtIndex;
		}
		return result;
	}

	private static int sumXtoY(int firt, int last) {
		if (firt > last) {
			return 0;
		} else {
			if (firt == last) {
				return firt + sumXtoY(++firt, last);
			} else {
				return firt + last + sumXtoY(++firt, --last);
			}
		}
	}

}
