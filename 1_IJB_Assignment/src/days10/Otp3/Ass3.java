package days10.Otp3;

import java.util.Iterator;
import java.util.Scanner;
//Viết hàm đếm xem có bao nhiêu phần tử có giá trị Nhỏ hơn X nhưng lớn hơn Y 
//trong mảng số nguyên A (đã được nhập vào từ bài 1 topic 1).

public class Ass3 {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = { 0, 4, 5, 16, 4, 0 };
		findValueBeXY(arr);
	}

	private static void findValueBeXY(int[] arr) {
		int x, y;
		int count = 0;

		do {
			try {
				System.out.print("Nhap X: ");
				x = Integer.parseInt(sc.nextLine());
				System.out.print("Nhap Y (Y<X): ");
				y = Integer.parseInt(sc.nextLine());
				if (x > y) {
					break;
				}
				System.out.println("Y < X, moi nhap lai\n");
			} catch (Exception e) {
				System.out.println("Chi được nhập số nguyên\n");
			}
		} while (true);

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > y && arr[i] < x) {
				count++;
			}
		}

		if (count == 0) {
			System.out.println("Không phần tử nào");
		} else {
			System.out.printf("Có %d phần tử trong khoảng %d -> %d ", count, y, x);
		}

	}

}
