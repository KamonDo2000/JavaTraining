package day9.Otp2;

import java.util.Scanner;

public class Ass3 {

	public static void main(String[] args) {
//		Mình có đoạn code sau đã được try catch “cẩn thận”, 
//		bạn xem try catch như vậy có còn khả năng gây ra lỗi nào nữa không.
		Scanner input = new Scanner(System.in);
		Integer intNumber = null;
		         
		try {
		    System.out.println("Hãy nhập vào một số nguyên: ");
		    String strNumber = input.nextLine();
		    intNumber = new Integer(strNumber);
		    System.out.println("Chuyển thành Hexa: " + Integer.toHexString(intNumber));
		} catch (NumberFormatException e) {
		    System.out.println("Vui lòng nhập vào một số nguyên");
		}
		         
		
	}
}

// hai trường hợp phát sinh lỗi là nhập vào String, nhập vào số thực
// Nếu lỗi thì không thể toHexString được nên phải đưa print vào try
