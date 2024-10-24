package day3;

import java.util.Scanner;

public class Ass1 {
//	Viết chương trình Java để cho phép người dùng nhập tuổi của họ. 
//	Sau đó chương trình sẽ hiển thị xem người đó có đủ điều 
//	kiện để bỏ phiếu hay không. Người đủ điều kiện bầu cử phải lớn hơn hoặc bằng 18 tuổi.
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int age;

		do {
			System.out.println("Nhập tuổi Phải lớn hơn 0 nghe!!!");
			System.out.print("Nhập tuổi mày vào đây: ");
			age = input.nextInt();
		} while (age <= 0);

		if (age >= 18) {
			System.out.println("ok đủ tuổi rồi đó đi bỏ phiếu đi");
		} else {
			System.out.println("Mày chưa đủ tuổi!!");
		}
	}

}
