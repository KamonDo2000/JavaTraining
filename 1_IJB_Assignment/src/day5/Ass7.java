package day5;

import java.util.Scanner;

public class Ass7 {
	
//	Tính tổng và tích các chữ số của một số m, m được nhập từ bàn phím
//	(Ví dụ : m = 234 => S = 2 + 3 + 4 = 9, P = 2 * 3 * 4 = 24)

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int s=0;
		int p=1;
		
		System.out.print("Nhap so m:  ");
		int m = input.nextInt();
		
		while(m>0) {
			int num =m%10;
			s+=num;
			p*=num;
			m/=10;
		}
		
		System.out.println("=> S =  "+ s);
		System.out.println("=> P =  "+ p);
	}

}
