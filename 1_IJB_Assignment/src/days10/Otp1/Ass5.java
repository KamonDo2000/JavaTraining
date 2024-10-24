package days10.Otp1;

import java.util.Scanner;

//Cho một dãy số khoảng 1000000 kí tự số toàn 0 và 1. Biết rằng các số 0 đứng
//trước các chữ số 1: 000....0011...11. Hãy cho biết vị trí của số 0 cuối cùng trong
//dãy.

public class Ass5 {

	public static void main(String[] args) {
		String stringBit = "000000000000000000000000000000000000000000000011111111111";

		char[] arrayBit = stringBit.toCharArray();
		int firtIndex = 0;
		int lastIndex = arrayBit.length - 1;
		int result = binarySearchBit(arrayBit, firtIndex, lastIndex);

		if (result == -1)
			System.out.printf("khong co số 0 trong dãy: ");
		else
			System.out.printf("vị trí của số 0 cuối cùng trong dãy: %d", result);
	}

	private static int binarySearchBit(char[] arr, int firtIndex, int lastIndex) {
		int midIndex = firtIndex + (lastIndex - firtIndex) / 2;
		if (arr[midIndex] == '0' && arr[midIndex + 1] == '1') {
			return midIndex;
		}
		if (arr[midIndex] == '0' && arr[midIndex + 1] == '0') {
			firtIndex = midIndex + 1;
			return binarySearchBit(arr, firtIndex, lastIndex);
		}
		if (arr[midIndex] == '1' && arr[firtIndex] == '0') {
			lastIndex = midIndex - 1;
			return binarySearchBit(arr, firtIndex, lastIndex);
		}
		return -1;
	}

}
