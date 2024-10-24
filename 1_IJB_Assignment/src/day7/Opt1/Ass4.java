package day7.Opt1;

import java.util.ArrayList;
import java.util.Scanner;

import common.arrList;

public class Ass4 {

//	Viết hàm cập nhật giá trị vị tại vị trí Y trong danh sách
//	(Y nhập vào từ bàn phìm) và
//	hiển thị các giá trị trong danh sách (sử dụng hàm hiển thị ở câu 2)
	public static void main(String[] args) {
		ArrayList<Integer> arr = arrList.createArrList();
		Scanner input = new Scanner(System.in);
		int Y;

		System.out.print("\nNhap gia tri muon cap nhat: ");
		int newValue = input.nextInt();

		do {
			System.out.print("\nnhập vào từ bàn phìm vị trí Y:  ");
			Y = input.nextInt();
		} while (Y > arr.size() || Y < 1);

		arr = arrList.updateArr(arr, Y, newValue);
		arrList.showArr(arr);
	}

}
