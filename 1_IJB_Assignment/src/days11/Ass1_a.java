package days11;

import java.util.Iterator;

//Cho một mảng arr, nhiệm vụ của bạn là sắp xếp lại mảng arr theo các quy tắc sau:
//Các số chẵn sẽ được chuyển lên đầu mảng vào được sắp xếp tăng dần.
//Các số lẻ sẽ được chuyển về cuối mảng vào sắp xếp giảm dần.
//Hãy viết hàm để thực hiện yêu cầu trên.

//a. Sử dụng sắp xếp nổi bọt

public class Ass1_a {
	public static void main(String[] args) {
//			Index	  0  1   2  3   4    5   6   7  8  9  10  11   12
//					  4  6  10  12  22  32  42  54  3  5  9   11   21  
		int[] arr = { 6, 4, 12, 10, 22, 54, 32, 9, 3, 5, 42, 21, 11 };
		bubbleSortArr(arr);
		for (int i : arr) {
			System.out.print(i + "  ");
		}
	}

	public static void bubbleSortArr(int[] arr) {
		int n = arr.length - 1;
		int lastEven = -1; //tìm ra phần tử even cuối cùng

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				if (arr[j] > arr[j + 1]) {
					swap(arr, j, j + 1);
				}
			}
		} //sort min -> max

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - i; j++) {
				if (arr[j] % 2 != 0 && arr[j + 1] % 2 == 0) {
					swap(arr, j, j + 1);
					lastEven = j;
				}
			}
		} //sort even -> odd
		
		if (arr[0] % 2 == 0 && arr[1] % 2 != 0)
			lastEven = 0;

		if (lastEven != -1) {
			for (int i = 0; i < (n - lastEven) - 1; i++) {
				int indexOdd = lastEven + 1;
				for (int j = 0; j < ((n - lastEven) - i) - 1; j++) {
					if (arr[indexOdd] < arr[indexOdd + 1]) {
						swap(arr, indexOdd, indexOdd + 1);
						indexOdd++;
					}
				}
			}
		} //sort odd giảm dần

	}

	public static void swap(int[] arr, int index1, int index2) {
		arr[index1] = arr[index1] + arr[index2];
		arr[index2] = arr[index1] - arr[index2];
		arr[index1] = arr[index1] - arr[index2];
	}
}
