package day2.Opt1;

import java.util.Scanner;

public class Ass2 {

	private static Scanner input;

//	Viết chương trình Java bằng cách sử dụng lớp Scanner để nhập tên, 
//	họ từ bàn phìm và sau đó  sẽ được hiển thị lên console
	public static void main(String[] args) {
		input = new Scanner(System.in);
		System.out.print("Nhập Họ Tên rồi Enter: \t");
		String variable1 = input.nextLine();
		System.out.println("Họ Tên bạn là: "+ variable1);
	}
}
