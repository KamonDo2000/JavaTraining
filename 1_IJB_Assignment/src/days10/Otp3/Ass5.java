package days10.Otp3;

//Cho một mảng nums đã được sắp xếp tăng dần và một số nguyên target, trả về chỉ số nếu có giá trị đó trong mảng.
//Nếu không, hãy trả về chỉ số vị trí mà nếu chèn vào mảng đó, mảng vẫn giữ nguyên tính chất tăng dần. 
//Biết trong mảng không có phần tử nào trùng lặp

public class Ass5 {

	public static void main(String[] args) {
//					  0  1  2  3  4  5  6   7
		int[] arr = { 0, 1, 2, 4, 6, 9, 11, 15 };

		int x = 5;

		int firtIndex = 0;
		int lastIndex = arr.length - 1;

		int result = findBinaryIndex(arr, x, firtIndex, lastIndex);
		System.out.println(result);
	}

	public static int findBinaryIndex(int[] arr, int x, int firtIndex, int lastIndex) {
		int midIndex = firtIndex + (lastIndex - firtIndex) / 2;

		if (arr[midIndex] == x) {
			return midIndex;
		}
		if (arr[firtIndex] == x) {
			return firtIndex;
		}
		if (arr[lastIndex] == x) {
			return lastIndex;
		}

		if ((lastIndex - firtIndex) == 1) {
			return firtIndex + 1;
		}

		if (arr[midIndex] > x) {
			return findBinaryIndex(arr, x, firtIndex, midIndex);
		}
		if (arr[midIndex] < x) {
			return findBinaryIndex(arr, x, midIndex, lastIndex);
		}
		return 0;
	}

}
