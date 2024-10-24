package day4;

import java.util.Iterator;

//Viết chương trình Java bằng cách sử dụng ba vòng lặp for để in mẫu sau
//1******
//12*****
//123****
//1234***
//12345**
//123456*
//1234567
public class Ass2 {

	public static void main(String[] args) {
//		int i, j, n;
//		for (i = 1; i < 8; i++) {
//			for (j = 1; j <= i; j++) {
//				System.out.print(j);
//			}
//
//			for (n = 7; n > i; n--) {
//				System.out.print("*");
//			}
//			System.out.print("\n");
//		}
		
		for(int i=1; i<=7;i++) {
			
			for(int j=1; j<=7;j++) {
				if(i<j) {
					System.out.print("*");
				}else {
					System.out.print(j);
				}
			}
			
			System.out.println();
		}
		
	}

}
