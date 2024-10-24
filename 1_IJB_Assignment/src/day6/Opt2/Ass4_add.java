package day6.Opt2;

import java.util.Scanner;

import common.func;

public class Ass4_add {

//	Viết hàm Thêm N giá trị (N < 5 và được nhập vào từ bàn phím) 
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
			System.out.print("Bạn muốn thêm bao nhiêu phần tử (Số phần tử phải <5):  ");
			N = in.nextInt();
		} while (N > 5);
//------------------------------------------------------------------------------------------------------
		int[] K = new int[N]; // các vị trí được xác định trong mảng K
		for (int i = 0; i < K.length; i++) {
			do {
				System.out.printf("\nNhập VỊ TRÍ muốn thêm vào thứ %d:\t", i + 1);
				K[i] = in.nextInt();
				if (K[i] > M + 1 || K[i] < 1) {
					System.out.printf("\nMảng của bạn chỉ có %d vị trí || nếu muốn thêm cuối mảng nhập %d", M, M + 1);
				}
			} while (K[i] > M + 1 || K[i] < 1);
		}
//------------------------------------------------------------------------------------------------------
		int[] newValue = new int[N]; // các Giá trị muốn thêm vào đó
		System.out.println();
		for (int i = 0; i < newValue.length; i++) {
			System.out.printf("\nNhập GIÁ TRỊ muốn thêm tại vị trí thứ %d: \t", K[i]);
			newValue[i] = in.nextInt();
		}

//------------------------------------------------------------------------------------------------------
		int[] newArr= A;
		for (int i = 0; i < N; i++) {
			if(K[i] == M+1) {
				newArr = func.addValueLastArr(newArr, newValue[i]);
			}else {
				newArr = func.addValueArr(newArr, newValue[i], K[i]);
			}
		}
		
		func.readArr(newArr);

	}
}
