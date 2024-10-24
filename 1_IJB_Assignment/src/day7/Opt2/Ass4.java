package day7.Opt2;

import java.util.ArrayList;
import java.util.Scanner;

import common.arrList;

public class Ass4 {

//	Viết hàm hiển thị các phần tử số nguyên ở danh sách L2 không có trong danh sách L1
//	(Danh sách L2 ít hơn danh sách L1).
	public static void main(String[] args) {

		System.out.println("Nhập giá trị cho mảng L1");
		ArrayList<Integer> L1 = arrList.createArrList();

		System.out.println("Nhập giá trị cho mảng L2");
		ArrayList<Integer> L2 = arrList.createArrList();

		arrList.showColection(L1, L2);
	}

	

//	public static void showColection(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
//		arr2.removeAll(arr1);
//		System.out.println(arr2);
//	}

}
