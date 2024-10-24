package days11;

import java.util.ArrayList;
import java.util.Iterator;

//Cho một mảng arr, nhiệm vụ của bạn là sắp xếp lại mảng arr theo các quy tắc sau:
//Các số chẵn sẽ được chuyển lên đầu mảng vào được sắp xếp tăng dần.
//Các số lẻ sẽ được chuyển về cuối mảng vào sắp xếp giảm dần.
//Hãy viết hàm để thực hiện yêu cầu trên.

//b.sử dụng sắp xếp nhanh

public class Ass1_b {
	public static void main(String[] args) {
		int[] arr = { 6, 4, 12, 10, 22, 54, 32, 9, 3, 5, 42, 21, 11 };

		ArrayList<Integer> arrEven = new ArrayList<Integer>();
		ArrayList<Integer> arrOdd = new ArrayList<Integer>();

		for (int i : arr) {
			if (i % 2 == 0) {
				arrEven.add(i);
			} else {
				arrOdd.add(i);
			}
		}
		quickSortTangDan(arrEven, 0, arrEven.size() - 1);
		quickSortGiamDan(arrOdd, 0, arrOdd.size() - 1);

		arrEven.addAll(arrOdd);
		System.out.println(arrEven);

	}

	static void quickSortTangDan(ArrayList<Integer> arr, int low, int high) {
		if (low < high) {
			int pi = tangDan(arr, low, high);

			quickSortTangDan(arr, low, pi - 1);
			quickSortTangDan(arr, pi + 1, high);
		}
	}

	static void quickSortGiamDan(ArrayList<Integer> arr, int low, int high) {
		if (low < high) {
			int pi = giamDan(arr, low, high);

			quickSortGiamDan(arr, low, pi - 1);
			quickSortGiamDan(arr, pi + 1, high);
		}
	}

	static int giamDan(ArrayList<Integer> arr, int low, int high) {
		int pivot = arr.get(high);
		int left = low;
		int right = high - 1;

		while (true) {
			while (left <= right && arr.get(left) > pivot)
				left++;
			while (right >= left && arr.get(right) < pivot)
				right--;
			if (left >= right)
				break;

			swap(arr, left, right);
			left++;
			right--;
		}
		swap(arr, left, high);
		return left;
	}

	static int tangDan(ArrayList<Integer> arr, int low, int high) {
		int pivot = arr.get(high);
		int left = low;
		int right = high - 1;

		while (true) {
			while (left <= right && arr.get(left) < pivot)
				left++;
			while (right >= left && arr.get(right) > pivot)
				right--;
			if (left >= right)
				break;

			swap(arr, left, right);
			left++;
			right--;
		}
		swap(arr, left, high);
		return left;
	}

	static void swap(ArrayList<Integer> arr, int l, int r) {
		int t = arr.get(l);
		arr.set(l, arr.get(r));
		arr.set(r, t);
	}
}
