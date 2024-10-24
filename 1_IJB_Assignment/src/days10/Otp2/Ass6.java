package days10.Otp2;

//Cho một danh sách arr[] đã được sắp xếp gồm n phần từ
//viết một hàm đưa ra vị trí của phần từ x trong mảng

//arr[] = {15, 20, 25, 30,31, 44,66 }. 
//Tìm x = 25.


public class Ass6 {

	public static void main(String[] args) {
		int[] arr = { 15, 20, 25, 30, 31, 44, 66 };
		int lastIndex = arr.length - 1;
		int firtIndex = 0;

		int x = 44;

		int index = findX(arr, x, firtIndex, lastIndex);
		System.out.println(index);

	}

	private static int findX(int[] arr, int x, int firtIndex, int lastIndex) {
		int midIndex = firtIndex + (lastIndex - firtIndex) / 2;
		if (x > arr[firtIndex] && x < arr[lastIndex]) {
			if ((lastIndex - firtIndex) == 1 && lastIndex != x && firtIndex != x) {
				return -1;
			}
			if (arr[midIndex] == x) {
				return midIndex;
			}
			if (arr[midIndex] < x) {
				return findX(arr, x, midIndex, lastIndex);
			}
			if (arr[midIndex] > x) {
				return findX(arr, x, firtIndex, midIndex);
			}
		}
		return -1;
	}

}
