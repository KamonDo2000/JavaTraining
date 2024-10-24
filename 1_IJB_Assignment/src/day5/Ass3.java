package day5;

import java.util.Scanner;

public class Ass3 {

//				+2 +2*2 +2*2*2
//	In dãy số 1, 3, 7, 15, 31, … (n là số nhập vào từ bàn phím)
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int i;
		int jump=1;
		System.out.print("Nhap so n:  ");
		int n = input.nextInt();
		
		for(i=1; i<=n; i+=jump) {
			System.out.print(i+"\t");
			jump*=2;
		}
	}

}
