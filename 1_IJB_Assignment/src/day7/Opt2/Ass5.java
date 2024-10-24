package day7.Opt2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import common.arrList;

public class Ass5 {

//	Viết hàm hiển thị tất cả các phần tử số nguyên có trong cả danh sách L1 và L2
	public static void main(String[] args) {

		System.out.println("Nhập giá trị cho mảng L1");
		ArrayList<Integer> L1 = arrList.createArrList();

		System.out.println("Nhập giá trị cho mảng L2");
		ArrayList<Integer> L2 = arrList.createArrList();

		showArrCommonNotDuplicate(L1, L2);
	}

	public static void showArrCommon(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		ArrayList<Integer> common = new ArrayList<Integer>();

		for (int i = 0; i < arr1.size(); i++) {
			for (int j = 0; j < arr2.size(); j++) {
				if (arr1.get(i) == arr2.get(j)) {
					common.add(arr1.get(i));
					break;
				}
			}
		}
		System.out.println(common);
	}
	
	public static void showArrCommonNotDuplicate(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
		HashSet<Integer> common = new HashSet<Integer>();

		for (int i = 0; i < arr1.size(); i++) {
			for (int j = 0; j < arr2.size(); j++) {
				if (arr1.get(i) == arr2.get(j)) {
					common.add(arr1.get(i));
					break;
				}
			}
		}
		System.out.println(common);
	}

}
