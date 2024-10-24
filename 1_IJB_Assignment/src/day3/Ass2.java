package day3;

import java.util.Scanner;

public class Ass2 {
//	Viết chương trình Java để xác định xem một số đầu vào có phải là số chẵn hay không
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num;

		do {
			System.out.println("Nhập một số coi:  ");
			num = in.nextInt();
			if (num <= 0) {
				System.out.println("Số nhập vào phải >0!!!");
			}
			;
		} while (num <= 0);

		if ((num % 2) == 0) {
			System.out.printf("Số %d là số chẵn", num);
		} else {
			System.out.printf("Số %d là số lẻ", num);
		}
	}

}
