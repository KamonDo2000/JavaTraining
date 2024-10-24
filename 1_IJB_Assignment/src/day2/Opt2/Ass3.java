package day2.Opt2;

import java.util.Scanner;

public class Ass3 {
//	Viết chương trình Java để cho phép người dùng nhập hai giá trị float 
//	và sau đó chương trình sẽ cộng hai giá trị đó lại với nhau. 
//	Kết quả sẽ được gán cho biến đầu tiên	
	public static void main(String[] args) {
		Scanner Input = new Scanner(System.in);
		System.out.print("Nhập giá trị Float thứ nhất:  ");
		float num1 = Input.nextFloat();
		System.out.print("Nhập giá trị Float thứ hai:  ");
		float num2 = Input.nextFloat();
	
		num1 += num2;
		System.out.println("sum two variable is:  "+ (num1));
	}

}
