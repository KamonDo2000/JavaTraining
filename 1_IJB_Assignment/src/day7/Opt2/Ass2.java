package day7.Opt2;

import java.util.ArrayList;

import common.arrList;

public class Ass2 {

//	Viết hàm kiểm tra xem hai danh sách số nguyên L1 và L2 có giống nhau hay không?
	public static void main(String[] args) {
		System.err.println("Nhap List số nguyên L1:  ");
		ArrayList<Integer> L1 = arrList.createArrList();

		System.err.println("Nhap List số nguyên L2:  ");
		ArrayList<Integer> L2 = arrList.createArrList();

		arrList.checkLikeList(L1, L2);
	}
}
