package days10.Otp1;

import java.util.Scanner;

//Viết hàm đếm số lần xuất hiện của số nguyên X (X nhập vào từ bàn phím)
//trong mảng số nguyên A (đã được nhập ở trên)Nếu không có thì hiển thị -1.
public class Ass2 {
	static Scanner sc = new Scanner(System.in);

	public static void findCountX(int[] arr) {

		do {
			try {
				System.out.println("Nhập vào số nguyên cần tìm: ");
				int x = Integer.parseInt(sc.nextLine());
				int count = 0;

				for (int i = 0; i < arr.length; i++) {
					if (x == arr[i]) {
						++count;
					}
				}
				if (count != 0) {
					System.out.printf("Phần tử %d xuất hiện %d lần trong mảng!!", x, count);
				} else {
					System.out.println("Không có phần tử trong mảng");
				}
				break;
			} catch (Exception e) {
				System.out.println("Chỉ được nhập vào số nguyên!!!\n");
			}

		} while (true);
	}
}
