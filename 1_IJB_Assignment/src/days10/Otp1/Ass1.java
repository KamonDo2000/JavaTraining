package days10.Otp1;

import java.util.Scanner;

public class Ass1 {
	static Scanner sc = new Scanner(System.in);

//	Viết hàm tìm giá trị X (X nhập vào từ bàn phím) trong mảng số nguyên A 
//	(đã được nhập ở trên) và cho biết giá trị X có tồn tại trong mảng A hay không.
	public static int[] inputArr() {
		int size;
		do {
			try {
				System.out.print("Nhập số phần tử mảng A: ");
				size = Integer.parseInt(sc.nextLine());
				if (size > 5 && size < 100) {
					break;
				}
				System.out.println("Độ lớn mảng 100 > A > 5!!!\n");
			} catch (Exception e) {
				System.out.println("Chỉ được nhập Vào số nguyên!!!\n");
			}
		} while (true);

		int[] arr = new int[size];
		for (int i = 0; i < arr.length; i++) {
			try {
				System.out.printf("Nhập phần tử thứ: %d:  ", i + 1);
				arr[i] = Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.out.println("Chỉ được nhập Vào số nguyên!!!\n");
				--i;
			}
		}

		return arr;
	}

	public static void showFindX(int[] arr) {
		do {
			try {
				System.out.print("\nNhập giá trị X cần tìm: ");
				int x = Integer.parseInt(sc.nextLine());
				boolean check = false;

				for (int i = 0; i < arr.length; i++) {
					if (x == arr[i]) {
						check = true;
						break;
					}
				}

				if (!check) {
					System.out.printf("Không có %d trong mảng!!!", x);
				} else {
					System.out.printf("Có %d trong mảng!!!", x);
				}
				break;
			} catch (Exception e) {
				System.out.println("Chỉ được nhập vào số nguyên!!!\n");
			}
		} while (true);
	}

}
