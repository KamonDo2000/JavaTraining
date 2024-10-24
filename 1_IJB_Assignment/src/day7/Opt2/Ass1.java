package day7.Opt2;

import java.util.ArrayList;
import java.util.Scanner;

import common.arrList;

public class Ass1 {

//	Viết hàm tìm phần tử có giá trị X trong danh sách chứa các phần tử số nguyên 
//	(X nhập từ bàn phím). Nếu có thì hiện thị ví trí của X trong Danh sách,
//	Nếu không có thì hiển thị “Không có X” trong Danh sách
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		ArrayList<Integer> arr = arrList.createArrList();

		System.out.print("Nhập giá trị bạn muốn tìm:  ");
		int X = input.nextInt();

		arrList.findArray(arr, X);
	}
}
