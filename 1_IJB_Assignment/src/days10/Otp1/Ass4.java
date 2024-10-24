package days10.Otp1;

import java.util.Scanner;

//Viết hàm đếm xem có bao nhiêu phần tử có giá trị nằm trong khoảng [X,Y]
//(X và Y nhập vào từ bàn phím) trong mảng số nguyên A (đã được nhập ở trên). 
//Nếu không có thì hiển thị -1.
public class Ass4 {
	public static void checkScope(int[] arr) {
		Scanner sc = new Scanner(System.in);

		do {
			try {
				int count = 0;
				System.out.println("Nhập Khoảng giá trị x và y: ");
				System.out.print("X: ");
				int x = Integer.parseInt(sc.nextLine());
				System.out.print("\nY: ");
				int y = Integer.parseInt(sc.nextLine());

				if (x >= y) {
					System.out.println("Phần tử X phải nhỏ hơn Y!!\n");
					continue;
				}

				for (int i = 0; i < arr.length; i++) {
					if (x < arr[i] && arr[i] < y) {
						++count;
					}
				}

				if (count ==0) {
					System.out.println(-1);
				} else {
					System.out.printf("Có %d phần tử trong khoảng [%d] - [%d]!!!", count, x, y);
				}
				break;
			} catch (Exception e) {
				System.out.println("Chỉ được nhập vào số nguyên!!!\n");
			}
		} while (true);
	}
}
