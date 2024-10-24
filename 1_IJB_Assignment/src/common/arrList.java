package common;

import java.util.ArrayList;
import java.util.Scanner;

public class arrList {

	/**
	 * Hàm nhập giá trị vào Danh sách Liên kết
	 * 
	 * @return ArrayList có value
	 */
	public static ArrayList<Integer> createArrList() {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> Arr = new ArrayList<Integer>();
		
		System.out.print("Nhap Số lượng phần tử cần thêm vào Danh sách:  ");
		int N = in.nextInt();

		for (int i = 0; i < N; i++) {
			System.out.print("Nhap phần tử chứa giá trị số nguyên vào danh sách:  ");
			Arr.add(in.nextInt());
		}
		return Arr;
	}

	/**
	 * Hàm show full array List
	 * 
	 * @param Array truyền vào
	 */
	public static void showArr(ArrayList<Integer> A) {
		for (Integer i : A) {
			System.out.printf("\t[ %d ]\t", i);
		}
	}

	/**
	 * Hàm show giá trị index trong List
	 * 
	 * @param arr   array có sẵn
	 * @param index trong array đó
	 */
	public static void showValueIndex(ArrayList<Integer> arr, int index) {
		ArrayList<Integer> arrnew = new ArrayList<Integer>();
		for (int i = 0; i < arr.size(); i++) {
			if (i == index - 1) {
				arrnew.add(arr.get(i));
			}
		}
		showArr(arrnew);
	}

	/**
	 * 
	 * Hàm cập nhật value vào index của array
	 * 
	 * @param arr
	 * @param index
	 * @param value
	 * @return
	 */
	public static ArrayList<Integer> updateArr(ArrayList<Integer> arr, int index, int value) {
		ArrayList<Integer> newArr = new ArrayList<Integer>();

		for (int i = 0; i < arr.size(); i++) {
			if (i == index - 1) {
				newArr.add(value);
			} else {
				newArr.add(arr.get(i));
			}
		}

		return newArr;
	}

	/**
	 * Xóa một value tại vị trí index
	 * 
	 * @param arr
	 * @param index
	 * @return
	 */
	public static ArrayList<Integer> delArr(ArrayList<Integer> arr, int index) {
		ArrayList<Integer> newArr = new ArrayList<Integer>();

		for (int i = 0; i < arr.size(); i++) {
			if (i == index - 1) {
				continue;
			}
			newArr.add(arr.get(i));
		}

		return newArr;
	}

	/**
	 * 
	 * Hàm kiểm tra value có trong arr hay không
	 * 
	 * @param arr
	 * @param value
	 */
	public static void findArray(ArrayList<Integer> arr, int value) {
		ArrayList<Integer> indexArr = new ArrayList<Integer>();
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) == value) {
				indexArr.add(i);
			}
		}

		if (indexArr.size() > 0) {
			System.out.println("ví trí của X trong Danh sách là " + indexArr);
		} else {
			System.out.println("Không có X");
		}
	}

	/**
	 * 
	 * Kiểm tra 2 mảng giống nhau không
	 * 
	 * @param arr1
	 * @param arr2
	 */
	public static void checkLikeList(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		boolean check = true;
		if (arr1.size() != arr2.size()) {
			check = false;
		} else {
			for (int i = 0; i < arr1.size(); i++) {
				if (arr1.get(i) != arr2.get(i)) {
					check = false;
					break;
				}
			}
		}
		if (check) {
			System.out.print("\n\n2 Mang nay Giong nhau");
		} else {
			System.out.print("\n\nHai mang deo giong nhau");
		}
	}

	/**
	 * 
	 * kiểm tra có value trong mảng arr không
	 * 
	 * @param arr
	 * @param value
	 */
	public static void checkValue(ArrayList<Integer> arr, int value) {
		int count = 0;
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i) == value) {
				count++;
			}
		}
		System.out.printf("Có %d phần tử có giá trị %d trong danh sách.", count, value);
	}

	/**
	 * Hàm hiển thị phần tử có trong mảng 2 nhưng không có trong 1
	 * 
	 * @param arr1
	 * @param arr2
	 */
	public static void showColection(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		for (int i = 0; i < arr2.size(); i++) {
			for (int j = 0; j < arr1.size(); j++) {
				if (arr2.get(i) == arr1.get(j)) {
					arr2 = delArr(arr2, i + 1); //tính từ 0 nên phải cộng 1, không như bài 3 xóa x tính từ 1
				}
			}
		}

		System.out.println(arr2);
	}
}
