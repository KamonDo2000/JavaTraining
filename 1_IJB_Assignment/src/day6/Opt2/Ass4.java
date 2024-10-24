package day6.Opt2;

import java.util.Scanner;

import common.func;

public class Ass4 {

//	Viết hàm Thay N giá trị (N < 5 và được nhập vào từ bàn phím) 
//	vào các vị trí được xác định trong mảng K (Khai báo trước hoặc nhập vào các vị trí cần chèn) 
//	vào mảng số nguyên A cho trước hoặc nhập vào (mảng A có kích thước M); 
//	Gợi ý: Nên sử dụng hàm ở bài 7 để giải quyết bài toán;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.print("Nhap Kich thuoc Array A:  ");
		int M = in.nextInt();
		int[] A = func.inputArr(M);
		func.readArr(A);
//------------------------------------------------------------------------------------------------------

		int N; // Thêm N giá trị (N < 5 và được nhập vào từ bàn phím)
		do {
			System.out.println();
			System.out.print("Bạn muốn thay đổi bao nhiêu phần tử (Số phần tử phải <5):  ");
			N = in.nextInt();
		} while (N > 5);
//------------------------------------------------------------------------------------------------------
		int[] K = new int[N]; // các vị trí được xác định trong mảng K
		for (int i = 0; i < K.length; i++) {
			do {
				System.out.printf("\nNhập VỊ TRÍ thay đổi thứ %d:\t", i + 1);
				K[i] = in.nextInt();
				if (K[i] > M || K[i] < 1) {
					System.out.printf("\nMảng của bạn chỉ có %d giá trị ", M);
				}
			} while (K[i] > M || K[i] < 1);
		}
//------------------------------------------------------------------------------------------------------

		int[] newValue = new int[N]; // các Giá trị muốn thay đổi vào đó
		System.out.println();
		for (int i = 0; i < newValue.length; i++) {
			System.out.printf("\nNhập GIÁ TRỊ muốn thay đổi tại vị trí thứ %d: \t", K[i]);
			newValue[i] = in.nextInt();
		}
//------------------------------------------------------------------------------------------------------

		int[] newArr;
		newArr = func.changeArrValue(A, K, newValue);
		func.readArr(newArr);
	}

}
