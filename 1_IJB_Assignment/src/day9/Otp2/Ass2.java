package day9.Otp2;

import java.util.Random;
import java.util.Scanner;

public class Ass2 {
//	Chương trình sẽ tạo ra 10 số nguyên ngẫu nhiên và lưu vào mảng 10 phần tử.
//	Chương trình sẽ cho người dùng nhập vào một chỉ số của mảng 
//	rồi xuất giá trị của mảng đó ra console"

	public static void main(String[] args) {
		// Tạo một mảng 10 các số nguyên ngẫu nhiên
		int randomIntNumbers[] = new int[10];
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			randomIntNumbers[i] = rand.nextInt(10);
		}
//Thằng nextInt() nó có cái giở lần sau chạy lại nó sẽ skip lệnh nextInt.
//vậy nên nhập từ bàn phím ta cần dùng nextLine() sau đó ParseInt sang.
		
		// Cho người dùng nhập một số nguyên và in ra màn hình
		// phần tử mảng tương ứng
		Scanner sc = new Scanner(System.in);
		do {
			try {
				System.out.println("Bạn muốn in ra phần tử mảng thứ mấy? ");
				int index = Integer.parseInt(sc.nextLine());
				System.out.println("OK, phần tử mảng thứ " + index + " mang giá trị " + randomIntNumbers[index - 1]);
				break;
			} catch (Exception e) {
				System.out.println("Mảng này chỉ có 10 phần tử!! vị trí từ 1 -> 10");
			}
		} while (true);
	}
}
