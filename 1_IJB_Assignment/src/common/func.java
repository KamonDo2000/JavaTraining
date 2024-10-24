package common;

import java.util.Scanner;

public class func {

	/**
	 * Function is input Array value
	 * 
	 * @param N
	 * @return Array với N phần tử có số phần tử đã Input
	 */
	public static int[] inputArr(int N) {
		Scanner input = new Scanner(System.in);
		int[] arr;
		arr = new int[N];

		for (int i = 0; i < arr.length; i++) {
			System.out.printf("Nhập giá trị thứ %d trong mảng:  ", i + 1);
			arr[i] = input.nextInt();
		}
		return arr;
	}

	/**
	 * Read the Array you transmisson
	 * 
	 * @param arr
	 */
	public static void readArr(int[] arr) {
		int index = 1;
		System.out.println("\nGiá trị của Array:");
		for (int i : arr) {
			System.out.printf("[ %d ], vi tri thu %d\n", i, index);
			index++;
		}
	}

	/**
	 * Function is show the even number in the array
	 * 
	 * @param arr
	 */
	public static void showEvenNum(int[] arr) {
		System.out.print("\n\nMang so chan: ");
		for (int i : arr) {
			if (i % 2 == 0) {
				System.out.printf("[ %d ], ", i);
			}
		}
	}

	/**
	 * Function is fill even number in array
	 * 
	 * @param arr
	 * @return Array đã lọc số có trị chẵn.
	 */
	public static int[] evenFillNum(int[] arr) {
		int[] B = new int[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0) {
				B = increArr(B); // khởi tạo mảng mới B kích thước tăng thì phải có chỗ để.
				B[B.length - 1] = arr[i];
			}
		}
		return B;
	}

	/**
	 * function is Fill odd number in array
	 * 
	 * @param arr
	 * @return Arr đã fill ra các số lẻ
	 */
	public static int[] oddFillNum(int[] arr) {
		int[] B = new int[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 != 0) {
				B = func.increArr(B);
				B[B.length - 1] = arr[i];
			}
		}
		return B;
	}

	/**
	 * Function is increted Array index
	 * 
	 * @param B Aray cũ
	 * @return array đã tăng size lên 1 đơn vị và đổ data cũ vào
	 */
	public static int[] increArr(int[] B) {
		int[] arr = new int[B.length + 1];
		// tạo một mảng mới là arr độ lớn = lenght B+1 có dữ liệu toàn 0
		for (int i = 0; i < B.length; i++) {
			arr[i] = B[i];
		}
		// nếu không đổ data từ mảng B cũ qua mảng Arr
		// thì hàm này chỉ tăng size thôi chứ không tạo mảng mới có data cũ và size +1
		return arr;
	}

	/**
	 * Function is Sum value in the Array
	 * 
	 * @param arr
	 * @return Tổng giá trị Array
	 */
	public static int sumInt(int[] arr) {
		int result = 0;
		for (int i = 0; i < arr.length; i++) {
			result += arr[i];
		}
		return result;
	}

	/**
	 * function is change value into index in Array
	 * 
	 * @param arr mảng thay thế
	 * @param X   Giá trị muốn thay thế
	 * @param Y   vị trí muốn thay thế, bắt đầu từ 1
	 * @return
	 */
	public static int[] changeValueArr(int[] arr, int X, int Y) {
		int[] newArr = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			if (i == Y - 1) {
				newArr[i] = X;
			} else {
				newArr[i] = arr[i];
			}
		}
		return newArr;
	}

	/**
	 * function is add value into index in Array
	 * 
	 * @param arr mảng muốn thêm
	 * @param X   Giá trị muốn thêm
	 * @return
	 */
	public static int[] addValueLastArr(int[] arr, int X) {
		int[] newArr = new int[arr.length + 1];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i];
		}
		newArr[newArr.length-1]=X;
		return newArr;
	}

	/**
	 * function is add value into index in Array
	 * 
	 * @param arr mảng muốn thêm
	 * @param X   Giá trị muốn thêm
	 * @param Y   vị trí muốn thay thêm, bắt đầu từ 1
	 * @return
	 */
	public static int[] addValueArr(int[] arr, int X, int Y) {
		int[] newArr = new int[arr.length + 1];
		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			if (i == Y - 1) {
				newArr[count] = X;
				newArr[++count] = arr[i];
				++count;
			} else {
				newArr[count] = arr[i];
				count++;
			}
		}

		return newArr;
	}

	/**
	 * 
	 * function thay đổi nhiều giá trị trong một mảng
	 * 
	 * @param arr:         Mảng ban đầu chưa thay đổi
	 * @param indexChange: mảng những vị trí muốn thay đổi trong Arr
	 * @param valueChange: Mảng những giá trị muốn thay đổi
	 * @return
	 */
	public static int[] changeArrValue(int[] arr, int[] indexChange, int[] valueChange) {
		int newArr[] = new int[0];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < indexChange.length; j++) {
				if (i == indexChange[j] - 1) {
					int giaTri = valueChange[j];
					int viTri = indexChange[j];
					newArr = func.changeValueArr(arr, giaTri, viTri);
					arr = newArr;
				}
			}
		}
		return newArr;
	}

	/**
	 * Xóa phần tử tại vị trí index đó trong mảng truyền vào
	 * 
	 * @param Arr
	 * @param index
	 * @return Arr Delete value in index
	 */
	public static int[] delIndexArr(int[] Arr, int index) {
		int[] newArr = new int[0];
		for (int i = 0; i < Arr.length; i++) {
			if (i == index - 1) {
				continue;
			}
			newArr = func.increArr(newArr);
			newArr[newArr.length - 1] = Arr[i];
		}
		return newArr;
	}

}
