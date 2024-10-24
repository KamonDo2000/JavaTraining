package days10.Otp1;

import java.util.Scanner;

public class Ass3 {
//Viết hàm hiển thị các vị trí chứa giá trị số nguyên X 
//(X nhập vào từ bàn phím) trong mảng số nguyên A (đã được nhập ở trên)
//Nếu không có thì hiển thị -1

	public static void findArrIndexX(int[] arr) {
		Scanner sc = new Scanner(System.in);

		do {
			try {
				System.out.println("Nhập vào số nguyên cần tìm: ");
				int x = Integer.parseInt(sc.nextLine());
				boolean check = false;

				System.out.printf("Vị trí xuất hiện %d :", x);
				for (int i = 0; i < arr.length; i++) {
					if (x == arr[i]) {
						System.out.printf(" %d ||", i + 1);
						check = true;
					}
				}
				if (!check) {
					System.out.println(-1);
				}
				break;
			} catch (Exception e) {
				System.out.println("Chỉ được nhập vào số nguyên!!!\n");
			}
		} while (true);

	}

}
