package String_Opt;

import java.util.Iterator;

public class Ass3 {
//	Cho chuỗi “Hello World” và Đếm xem có bao nhiêu chữ l
	public static void main(String[] args) {
		String str = "Hello World";
		char[] arr = str.toCharArray();
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'l') {
				++count;
			}
		}
		
		System.out.println(count);
	}

}
