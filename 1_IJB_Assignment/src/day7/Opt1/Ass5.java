package day7.Opt1;

import java.util.ArrayList;
import java.util.Scanner;

import common.arrList;

public class Ass5 {

//	Viết hàm Xóa giá trị vị tại vị trí Z trong danh sách (Z nhập vào từ bàn phìm)
//	và hiển thị các giá trị trong danh sách (sử dụng hàm hiển thị ở câu 2)

	public static void main(String[] args) {
		ArrayList<Integer> arr = arrList.createArrList();
		Scanner in = new Scanner(System.in);
		int Z;

		do {
			System.out.print("Nhap vi tri muon xoa Z: ");
			Z = in.nextInt();
		} while (Z > arr.size() || Z < 1);

		ArrayList<Integer> newArr;
		newArr = arrList.delArr(arr, Z);

		System.out.println(newArr);

	}

}
