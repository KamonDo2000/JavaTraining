package day7.Opt2;

import java.util.ArrayList;
import java.util.Scanner;

import common.arrList;

public class Ass3 {

//	Viết hàm kiếm tra xem bao nhiêu phần tử có giá trị X 
//	trong danh sách chứa các phần tử số nguyên (X nhập vào từ bàn phím);
	public static void main(String[] args) {
		ArrayList<Integer> arr = arrList.createArrList();
		Scanner in = new Scanner(System.in);

		System.out.print("\nNhập phần tử X cần kiểm tra:  ");
		int X = in.nextInt();

		arrList.checkValue(arr, X);
	}

}
