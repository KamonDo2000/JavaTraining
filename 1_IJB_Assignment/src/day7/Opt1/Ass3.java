package day7.Opt1;

import java.util.ArrayList;
import java.util.Scanner;

import common.arrList;

public class Ass3 {

//	Viết hàm lấy giá trị tại vị trí X (X nhập vào từ bàn phím)
//	trong danh sách đã được tạo ở bài 2 và hiển thị giá trị tại vị trí X
//	ra man hình (sử dụng hàm hiển thị ở câu 2)
	public static void main(String[] args) {
		ArrayList<Integer> arr = arrList.createArrList();
		Scanner in = new Scanner(System.in);
		int X;
		do {
			System.out.print("nhập vào từ bàn phím vị trí X: ");
			X = in.nextInt();
		} while (X > arr.size() || X < 1);
		arrList.showValueIndex(arr, X);
	}
}
